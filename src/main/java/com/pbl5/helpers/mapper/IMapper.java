package com.pbl5.helpers.mapper;

import java.sql.ResultSet;

public interface IMapper<T> {
    T mapRow(ResultSet result);
}
