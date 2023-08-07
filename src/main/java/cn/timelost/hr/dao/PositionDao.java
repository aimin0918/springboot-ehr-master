package cn.timelost.hr.dao;

import cn.timelost.hr.vo.PositionSelectVo;
import cn.timelost.hr.vo.PositionVo;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

import cn.timelost.hr.pojo.Position;


public interface PositionDao {

    int deleteByPrimaryKey(Integer id);


    int insert(Position record);


    int insertSelective(Position record);


    Position selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Position record);


    int updateByPrimaryKey(Position record);

    List<PositionVo> selectAll(@Param("departmentId") Integer departmentId, @Param("positionName") String positionName);

    int deleteByIdIn(@Param("idList") Collection<Integer> idList);

    List<PositionSelectVo> selectAllByDepartmentId(@Param("departmentId") Integer departmentId);
}