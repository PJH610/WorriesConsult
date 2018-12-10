package com.worriesconsult.dao;

import com.worriesconsult.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SX-503 on 2018/12/7.
 */
@Repository
public interface UserDao {

    int insert(User user);

    List<User> list();

    List<User> select (Long id);

    User selectById(Long id);

    User selectByUname(String username);

    int updateById(User user); // 通过id进行修改

    int deleteById(Long... id);
}
