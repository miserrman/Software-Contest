package com.garment.dapei.service;

import com.garment.dapei.model.User;

public interface ILoginService {

    public String register(String name, String birthday, int sex);

    public String update(User user);
}
