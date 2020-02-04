package com.inno.dao;

import com.inno.pojo.User;

import java.util.Collection;

public interface IUserDao {
    boolean addUser(User user);
    User getUserById(int id);
    User getUserByEmail(String email);
    User getUserByLogin(String login);
    Collection<User> showUsers();
}
