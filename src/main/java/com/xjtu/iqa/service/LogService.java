package com.xjtu.iqa.service;

import java.util.List;

import com.xjtu.iqa.vo.logindexView;

public interface LogService {
	/**
	 * zpz_knowledgeindex_FAQ的展示
	 */
	List<logindexView> logindexViews(int startnum,int count);
}
