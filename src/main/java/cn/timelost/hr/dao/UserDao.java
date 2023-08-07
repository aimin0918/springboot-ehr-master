package cn.timelost.hr.dao;
import java.util.Collection;
import java.util.List;

import cn.timelost.hr.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import cn.timelost.hr.pojo.User;


public interface UserDao {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsername(@Param("username") String username);

    List<UserVo> selectAll();

    int deleteByIdIn(@Param("idList") Collection<Integer> idList);
}