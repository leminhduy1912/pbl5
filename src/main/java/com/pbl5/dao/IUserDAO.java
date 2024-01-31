package com.pbl5.dao;

import com.pbl5.models.User;

public interface IUserDAO {
    User findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
    User findByEmail(String email);
    void save(User user);
}
