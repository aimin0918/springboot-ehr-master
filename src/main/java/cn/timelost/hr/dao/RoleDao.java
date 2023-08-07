package cn.timelost.hr.dao;
import java.util.List;

import cn.timelost.hr.pojo.Role;


public interface RoleDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAll();
}