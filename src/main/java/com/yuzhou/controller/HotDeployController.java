package com.yuzhou.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HotDeployController {
	
	@RequestMapping(value = "/say", method = RequestMethod.GET)
	public String say(HttpServletRequest request) {
		request.setAttribute("say", "hello yuhzou");
		return "yuzhou";
	}

}
