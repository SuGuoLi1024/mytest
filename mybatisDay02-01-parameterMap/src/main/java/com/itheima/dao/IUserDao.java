package com.itheima.dao;

import com.itheima.entity.QueryVo;
import com.itheima.entity.User;

import java.util.List;

public interface IUserDao {
    //根据主键查询
    User findById(Integer id);
    //添加
    void save(User user);
    //添加后保存数据的主键值
    void save2(User user);
    //修改
    void update(User user);
    //删除
    void delete(int id);
    //多条件查询
    List<User> findByCondition(QueryVo queryVo);
    //模糊查询
    List<User> findByUsername(String username);
    //查询全部
    List<User> findAll();
}
