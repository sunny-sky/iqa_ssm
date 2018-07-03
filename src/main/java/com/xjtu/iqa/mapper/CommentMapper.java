package com.xjtu.iqa.mapper;

import com.xjtu.iqa.pojo.Comment;
import com.xjtu.iqa.pojo.CommentExample;
import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(String COMMENTID);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(String COMMENTID);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}