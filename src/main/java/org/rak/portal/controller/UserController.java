package org.rak.portal.controller;

import java.util.List;

import org.rak.portal.api.UserApi;
import org.rak.portal.api.UserRequest;
import org.rak.portal.mapper.UserMapper;
import org.rak.portal.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rak/api/v1")
public class UserController {
	
	private UserService userService;
	
	private UserMapper userMapper;
	
	public UserController(UserService userService, UserMapper userMapper) {
		this.userService = userService;
		this.userMapper = userMapper;
	}
	
	@GetMapping
    public ResponseEntity<List<UserApi>> getAllUsers() {
		List<UserApi> userApis = this.userMapper.fromUsersToApis(this.userService.getAllUsers());
        return new ResponseEntity<>(userApis, HttpStatus.FOUND);
    }
	
	@PostMapping(path = "/register")
    public ResponseEntity<UserApi> register(UserRequest userRequest) {
		UserApi userApi = this.userMapper.fromUsertoApi(this.userService.saveOrUpdate(this.userMapper.toUser(userRequest)));
        return new ResponseEntity<>(userApi, HttpStatus.CREATED);
    }

}
