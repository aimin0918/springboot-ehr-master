package cn.timelost.hr.service;

import cn.timelost.hr.pojo.Role;
import cn.timelost.hr.pojo.User;
import cn.timelost.hr.vo.UserVo;
import com.github.pagehelper.PageInfo;

import java.util.Collection;
import java.util.List;

public interface UserService {

    User findByUsername(String username);

    User find(int id);

    PageInfo<UserVo> findList(int pageNum, int pageSize);

    void deleteById(int id);

    void deleteByIdIn(Collection<Integer> idList);

    void insert(User user);

    void updateById(User user);

    List<Role> roleList();
}
