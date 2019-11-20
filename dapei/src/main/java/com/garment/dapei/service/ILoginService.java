package com.garment.dapei.service;

import com.garment.dapei.model.User;
import com.garment.dapei.vo.AllUserInfo;

public interface ILoginService {

    public AllUserInfo register(String name, String birthday, int sex);

    public void update(User user);

}
