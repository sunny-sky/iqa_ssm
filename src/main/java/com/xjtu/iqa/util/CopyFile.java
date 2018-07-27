package com.xjtu.iqa.util;

import java.io.File;

public class CopyFile {
	public String copyFile(String path,String username,String time) {
		File fold = new File(path);
		String newPath="D:\\workspace\\eclipse\\faq_ssm\\src\\main\\webapp\\images\\faqPic\\";
		File file = new File(newPath);
		if(!file.exists()){
			file.mkdirs();
		}
		String newPath1 = newPath+fold.getName();
		File file2 = new File(newPath+fold.getName());
		fold.renameTo(file2);
		return newPath1;
		} 
}
