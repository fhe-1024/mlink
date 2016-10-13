package com.mdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sdn")
public class SdnController {

	@RequestMapping(path = "/index")
	public String index() {
		return "sdn";
	}
}
