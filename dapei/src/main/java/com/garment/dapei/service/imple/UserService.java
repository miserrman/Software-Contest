package com.garment.dapei.service.imple;

import com.garment.dapei.dao.UserDao;
import com.garment.dapei.model.User;
import com.garment.dapei.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements ILoginService {

    //依赖注入，调用dao层访问数据库
    @Autowired
    UserDao userDao;

    @Override
    public String register(String name, String birthday, int sex) {
        /*示例代码,用于注册User,注意要转换时间
        User user = new User();
        user.setUserName(name);
        user.setUserSex(sex);
        userDao.insertUser()
         */
        return null;
    }

    @Override
    public String update(User user) {
        return null;
    }
}
