package com.xjtu.iqa.vo;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	//当前页
		private int curPageIndex;
		//当前页显示的条数
		private int PageEntryCount;
		//总条数
		private int totalEntryCount;
		//总页数
		private int totalPage;
		
		private int beginPageIndex;    // 页码列表的开始索引(包含)
		private int endPageIndex;    // 页码列表的结束索引(包含)
		
		//每页显示的数据
		private List<T> EntryList = new ArrayList<T>();
		
		
		
		public int getBeginPageIndex() {
			return beginPageIndex;
		}
		public void setBeginPageIndex(int beginPageIndex) {
			this.beginPageIndex = beginPageIndex;
		}
		public int getEndPageIndex() {
			return endPageIndex;
		}
		public void setEndPageIndex(int endPageIndex) {
			this.endPageIndex = endPageIndex;
		}
		public int getCurPageIndex() {
			return curPageIndex;
		}
		public void setCurPageIndex(int curPageIndex) {
			this.curPageIndex = curPageIndex;
		}
		public int getPageEntryCount() {
			return PageEntryCount;
		}
		public void setPageEntryCount(int pageEntryCount) {
			PageEntryCount = pageEntryCount;
		}
		public int getTotalEntryCount() {
			return totalEntryCount;
		}
		public void setTotalEntryCount(int totalEntryCount) {
			this.totalEntryCount = totalEntryCount;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public List<T> getEntryList() {
			return EntryList;
		}
		public void setEntryList(List<T> entryList) {
			EntryList = entryList;
		}
}
