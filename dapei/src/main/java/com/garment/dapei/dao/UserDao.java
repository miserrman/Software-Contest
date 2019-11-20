package com.garment.dapei.dao;

import com.garment.dapei.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;

@Repository
public interface UserDao {
    public List<User>selectAllUsers();

    User selectUserByName(String userName);

    User selectUserBySex(int sex);

    User selectUserByBirthday(Date userBirthda);

    int insertUser(User user);

    void deleteUser(int userID);

    void updateUser(User user);

    User selectUserByID(int userID);
}
