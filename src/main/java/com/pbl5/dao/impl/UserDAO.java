package com.pbl5.dao.impl;

import com.pbl5.dao.IUserDAO;

import com.pbl5.helpers.BcryptPassword;
import com.pbl5.helpers.IDGeneration;
import com.pbl5.helpers.mapper.UserMapper;
import com.pbl5.models.User;


import java.util.List;

import java.util.logging.Logger;

public class UserDAO extends AbstractDAO<User> implements IUserDAO {
    private static final Logger logger = Logger.getLogger("UserDAO");

    @Override
    public User findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        logger.info("Find By Email");
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM users AS U INNER JOIN roles AS R ON u.role_id = r.role_id  " +
                " WHERE U.email = ? ";

        List<User> users = query(sql, new UserMapper(false, true), email);

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        logger.info("Save User");
        String sql = "INSERT INTO users (user_id," + "role_id," + "address," + "email," + "point," + "status," + "password," + "createdAt," + "createdBy)" + " VALUES(?,?,?,?,?,?,?,?,?)";

        insert(sql, user.getId(), 2, user.getAddress(), user.getEmail(), user.getPoint(), 1, user.getPassword(), user.getCreatedAt(), user.getCreatedBy());
    }
}
