package cn.timelost.hr.dao;
import java.util.Collection;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.timelost.hr.pojo.Recruitment;


public interface RecruitmentDao {

    int deleteByPrimaryKey(Integer id);


    int insert(Recruitment record);


    int insertSelective(Recruitment record);


    Recruitment selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Recruitment record);

    int updateByPrimaryKey(Recruitment record);

    List<Recruitment> selectAll(@Param("departmentName") String departmentName, @Param("recruitStatus") Integer recruitStatus);

    int deleteByIdIn(@Param("idList") Collection<Integer> idList);
}