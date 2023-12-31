package cn.timelost.hr.service.impl;

import cn.timelost.hr.dao.PersonalRewardDao;
import cn.timelost.hr.enums.ResultEnum;
import cn.timelost.hr.exception.BaseException;
import cn.timelost.hr.pojo.PersonalReward;
import cn.timelost.hr.service.PersonalRewardService;
import cn.timelost.hr.service.PersonalService;
import cn.timelost.hr.vo.PersonalVo;
import cn.timelost.hr.vo.input.PersonalRewardForm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;


@Service
@CacheConfig(cacheNames = "reward")
public class PersonalRewardServiceImpl implements PersonalRewardService {

    @Resource
    PersonalRewardDao personalRewardDao;
    @Resource
    PersonalService personalService;

    @Override
    @Cacheable(key = "#year+'-'+#month+'-'+#departmentName+'-'+#personalId+'-'+#pageNum+'-'+#pageSize")
    public PageInfo<PersonalReward> findAll(int year, int month, String departmentName, int personalId, int pageNum, int pageSize) {
        if (ObjectUtils.isEmpty(departmentName)) {
            departmentName = null;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<PersonalReward> personalRewards = personalRewardDao.selectAll(year, month, departmentName, personalId);
        return new PageInfo<>(personalRewards);
    }

    @Override
    @Cacheable(key = "#root.methodName")
    public List<PersonalReward> all() {
        return personalRewardDao.selectAll(0, 0, null, 0);
    }

    @Override
    public PersonalReward find(int id) {
        PersonalReward personalReward = personalRewardDao.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(personalReward)) {
            throw new BaseException(ResultEnum.PERSONAL_REWARD_NOT_EXIST);
        }
        return personalReward;
    }

    @Override
    @CacheEvict(allEntries = true)
    public void insert(PersonalRewardForm personalRewardForm) {
        PersonalVo personalVo = personalService.find(personalRewardForm.getPersonalId());
        PersonalReward personalReward = new PersonalReward();
        BeanUtils.copyProperties(personalRewardForm, personalReward);
        personalReward.setPersonalName(personalVo.getName());
        personalReward.setDepartmentName(personalVo.getDepartmentName());
        personalReward.setPositionName(personalVo.getPositionName());
        personalRewardDao.insertSelective(personalReward);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteById(Integer id) {
        PersonalReward personalReward = personalRewardDao.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(personalReward)) {
            throw new BaseException(ResultEnum.PERSONAL_REWARD_NOT_EXIST);
        }
        personalRewardDao.deleteByPrimaryKey(id);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteByIdIn(Collection<Integer> idList) {
        personalRewardDao.deleteByIdIn(idList);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void updateById(Integer id, PersonalRewardForm personalRewardForm) {
        PersonalReward personalReward = personalRewardDao.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(personalReward)) {
            throw new BaseException(ResultEnum.PERSONAL_REWARD_NOT_EXIST);
        }
        BeanUtils.copyProperties(personalRewardForm, personalReward);
        PersonalVo personalVo = personalService.find(personalRewardForm.getPersonalId());
        personalReward.setPersonalName(personalVo.getName());
        personalReward.setDepartmentName(personalVo.getDepartmentName());
        personalReward.setPositionName(personalVo.getPositionName());
        personalRewardDao.updateByPrimaryKeySelective(personalReward);
    }
}
