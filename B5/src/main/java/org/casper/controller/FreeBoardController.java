package org.casper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;



@Controller
@RequestMapping("/boards/*")
@Log
public class FreeBoardController {

	@GetMapping("/list")
	public void list() {
		log.info("list....page....");
	}
}
