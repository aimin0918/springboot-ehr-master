package cn.timelost.hr.dao;

import cn.timelost.hr.pojo.Personal;
import cn.timelost.hr.vo.PersonalVo;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;


public interface PersonalDao {

    int deleteByPrimaryKey(Integer id);


    int insert(Personal record);


    int insertSelective(Personal record);


    PersonalVo selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Personal record);


    int updateByPrimaryKey(Personal record);

    List<PersonalVo> selectAll(@Param("departmentId") Integer departmentId, @Param("personalName") String personalName, @Param("workStatus") int workStatus);

    int deleteByIdIn(@Param("idList") Collection<Integer> idList);
}