package com.barbecue;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/")
public class HomeController {
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goHome(Model model) {
		return "home";
	}
	
}
