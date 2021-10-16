package com.nit.shashi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String getHome() {
		return "homePage";
	}
	@GetMapping("/welcome")
	public String getWelcome() {
		return "welcomePage";
	}
	@GetMapping("/student")
	public String getStudent() {
		return "studentPage";
	}

	
	@GetMapping("/emp")
	public String getEmployee() {
		return "employeePage";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "adminPage";
	}

	@GetMapping("/change")
	public String getChange() {
		return "changePage";
	}
	@GetMapping("/denied")
	public String getDeniedPage() {
return "deniedPage";
	}
	
}
