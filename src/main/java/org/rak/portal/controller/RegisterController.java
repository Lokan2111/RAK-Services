package org.rak.portal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rak/api/v1")
public class RegisterController {
	
	@GetMapping(path = "/sample")
    public String register() {
        return "You are authenticated";
    }

}
