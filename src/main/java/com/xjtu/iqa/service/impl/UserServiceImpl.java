package com.xjtu.iqa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.pojo.User;
import com.xjtu.iqa.pojo.UserExample;
import com.xjtu.iqa.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	
	@Override
    public void add(User user) {
		userMapper.insert(user);
    }
    
    @Override
    public void delete(String id) {
    	userMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public void update(User user) {
    	userMapper.updateByPrimaryKeySelective(user);
    }
    
    @Override
    public User get(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
    
    //获取所有待审核用户 -- 即USERSTATE = 1    
    @Override
    public List<User> userPendingAudits(){
    	UserExample example = new UserExample();
    	example.createCriteria().andUSERSTATEEqualTo(1);
    	example.setOrderByClause("USERID desc");
    	List<User> users =userMapper.selectByExample(example);
    	return users;
    }
}
