package com.garment.dapei.service.imple;

import com.garment.dapei.dao.FigureDao;
import com.garment.dapei.dao.UserDao;
import com.garment.dapei.model.Figure;
import com.garment.dapei.model.User;
import com.garment.dapei.service.IFigureInfo;
import com.garment.dapei.service.ILoginService;
import com.garment.dapei.vo.AllUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

@Service
public class UserService implements ILoginService, IFigureInfo {

    //依赖注入，调用dao层访问数据库
    @Autowired
    UserDao userDao;

    @Autowired
    FigureDao figureDao;

    @Override
    public AllUserInfo register(String name, String birthday, int sex) {
        User user = new User();
        user.setUserName(name);
        user.setUserSex(sex);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = (Date)simpleDateFormat.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setUserBirthday(date);
        Figure figure = new Figure();
        figure.setWeight(60);
        figure.setHeight(170);
        int figureID = figureDao.insertUserFigure(figure);
        user.setUserFigureID(figureID);
        int userID = userDao.insertUser(user);
        User haveUser = userDao.selectUserByID(userID);
        Figure haveFigure = figureDao.selectUserFigure(figureID);
        AllUserInfo allUserInfo = new AllUserInfo();
        allUserInfo.setFigure(figure);
        allUserInfo.setUser(user);
        return allUserInfo;
    }

    @Override
    public void update(User user){
        userDao.updateUser(user);
    }

    @Override
    public Figure getFigureInfo(int figureID) {
        Figure figure = figureDao.selectUserFigure(figureID);
        return figure;
    }

    @Override
    public void inputFigureInfo(Figure figure) {
        figureDao.updateUserFigure(figure);
    }

    public User getUserInfo(String userName){
        User user = userDao.selectUserByName(userName);
        return user;
    }
}
