package com.howtodoinjava;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/test")
	public String home(Map<String, Object> model) {
		model.put("message", "Testing Page!!");
		return "test";
	}
	
	@RequestMapping("/test2")
	public String next(Map<String, Object> model) {
		model.put("message", "You are on Test2 Page!");
		return "test2";
	}
	
}
