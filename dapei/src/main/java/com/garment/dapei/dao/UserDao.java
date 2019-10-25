package com.garment.dapei.dao;

import com.garment.dapei.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public List<User>selectAllUsers();
}
