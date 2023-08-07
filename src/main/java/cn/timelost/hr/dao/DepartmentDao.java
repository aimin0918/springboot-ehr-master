package cn.timelost.hr.dao;
import cn.timelost.hr.vo.DepartmentSelectVo;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;
import java.util.List;

import cn.timelost.hr.pojo.Department;


public interface DepartmentDao {

    int deleteByPrimaryKey(Integer id);


    int insert(Department record);


    int insertSelective(Department record);


    Department selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Department record);


    int updateByPrimaryKey(Department record);

    List<Department> selectAll();

    int deleteByIdIn(@Param("idList") Collection<Integer> idList);

    List<Department> selectAllByDepartmentNameLike(@Param("departmentName") String departmentName);

    List<DepartmentSelectVo> selectAllSelect();
}