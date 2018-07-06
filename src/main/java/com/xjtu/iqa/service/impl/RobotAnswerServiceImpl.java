package com.xjtu.iqa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.iqa.mapper.RobotAnswerMapper;
import com.xjtu.iqa.po.RobotAnswer;
import com.xjtu.iqa.po.RobotAnswerExample;
import com.xjtu.iqa.service.RobotAnswerService;



@Service
public class RobotAnswerServiceImpl implements RobotAnswerService{
	@Autowired
	RobotAnswerMapper robotAnswerMapper;
	
	
	@Override
    public void add(RobotAnswer ra) {
		robotAnswerMapper.insert(ra);
    }
    
    @Override
    public void delete(String id) {
    	robotAnswerMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public void update(RobotAnswer ra) {
    	robotAnswerMapper.updateByPrimaryKeySelective(ra);
    }
    
    @Override
    public RobotAnswer get(String id) {
        return robotAnswerMapper.selectByPrimaryKey(id);
    }
    
    //返回不满意的所有RobotAnswer,即待处理事件
    @Override
    public List<RobotAnswer> Unresolved(){
    	RobotAnswerExample example = new RobotAnswerExample();
    	example.createCriteria().andSATICFACTIONEqualTo(0);
    	example.setOrderByClause("ROBOTANSWERID desc");
    	List<RobotAnswer> ras =robotAnswerMapper.selectByExample(example);
    	return ras;
    }
}
