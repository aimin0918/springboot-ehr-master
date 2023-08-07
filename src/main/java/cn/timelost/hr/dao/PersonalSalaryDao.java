package cn.timelost.hr.dao;

import java.util.Collection;

import java.util.Date;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.timelost.hr.pojo.PersonalSalary;


public interface PersonalSalaryDao {

    int deleteByPrimaryKey(Integer id);

    int insert(PersonalSalary record);

    int insertSelective(PersonalSalary record);

    PersonalSalary selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(PersonalSalary record);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKey(PersonalSalary record);

    List<PersonalSalary> selectAll(
            @Param("year") Integer year, @Param("month") Integer month,
            @Param("departmentName") String departmentName, @Param("personalId") Integer personalId);

    int deleteByIdIn(@Param("idList") Collection<Integer> idList);
}