package com.xjtu.iqa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class PageController {

	@RequestMapping("adminPage")
    public String loginPage() {
        return "admin/adminPage";
    }
	
	@RequestMapping("adminHomePage")
    public String adminHomePage() {
        return "admin/adminHomePage";
    }
}
