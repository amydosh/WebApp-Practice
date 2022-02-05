package com.howtodoinjava;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class logincontroller {



		@RequestMapping("/login")
		public String home(Map<String, Object> model) {
			model.put("message", "Testing Page!!");
			return "login2";
		}
		
		@RequestMapping("/loginhandler")
		public String next(Map<String, Object> model) {
			model.put("message", "You are on the loginhandler page!");
			return "login2";
		}
		
	}


