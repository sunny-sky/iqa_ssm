package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.pojo.User;

public interface UserService {
	void add(User u);    
    void delete(String id);
    User get(String id);
    void update(User u);
    
  //获取所有待审核用户 -- 即USERSTATE = 1
    List<User> userPendingAudits();
}
