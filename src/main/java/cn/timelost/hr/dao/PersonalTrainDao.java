package cn.timelost.hr.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

import cn.timelost.hr.pojo.PersonalTrain;


public interface PersonalTrainDao {

    int deleteByPrimaryKey(Integer id);


    int insert(PersonalTrain record);

    int insertSelective(PersonalTrain record);

    PersonalTrain selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(PersonalTrain record);


    int updateByPrimaryKey(PersonalTrain record);

    List<PersonalTrain> selectAll(@Param("departmentName") String departmentName, @Param("personalId") Integer personalId,
                                                  @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

    int deleteByIdIn(@Param("idList") Collection<Integer> idList);
}