package com.xjtu.iqa.mapper;

import java.util.List;

import com.xjtu.iqa.po.Comment;
import com.xjtu.iqa.po.CommentExample;

public interface CommentMapper {
    int deleteByPrimaryKey(String COMMENTID);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(String COMMENTID);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}