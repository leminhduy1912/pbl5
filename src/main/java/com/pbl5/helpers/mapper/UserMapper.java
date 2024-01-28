package com.pbl5.helpers.mapper;

import com.pbl5.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements IMapper<User> {
    private boolean withDate = false;
    private boolean withPassword = false;

    public UserMapper() {
    }

    public UserMapper(boolean withDate, boolean withPassword) {
        this.withDate = withDate;
        this.withPassword = withPassword;
    }
    @Override
    public User mapRow(ResultSet result) {
        User user = new User();
        try {
            user.setId(result.getString("userId"));
//            user.setRoleId(result.getInt("role_id"));
            user.setEmail(result.getString("email"));

            if (this.withPassword) user.setPassword(result.getString("password"));
            user.setRoleCode(result.getString("rolecode"));
            user.setAddress(result.getString("address"));
            System.out.println("data :......... " +user.getPassword());
            return user;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        return null;

    }
}
