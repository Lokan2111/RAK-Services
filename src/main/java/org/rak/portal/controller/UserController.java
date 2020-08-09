package org.rak.portal.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.rak.portal.api.UserApi;
import org.rak.portal.api.UserRequest;
import org.rak.portal.domain.User;
import org.rak.portal.mapper.UserMapper;
import org.rak.portal.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(path = "/user/id/{userId}")
    public ResponseEntity<UserApi> getUser(@PathVariable("userId") Integer userId) {
		Optional<User> user = this.userService.getUserById(userId);
		if (user.isPresent()) {
			UserApi userApi = this.userMapper.fromUsertoApi(user.get());
			return new ResponseEntity<>(userApi, HttpStatus.CREATED);
		}
       return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
	
	@GetMapping(path = "/user/contact/{mobileNumber}")
    public ResponseEntity<UserApi> getUserByMobileNumber(@PathVariable("mobileNumber") BigInteger mobileNumber) {
		Optional<User> user = this.userService.getUserByMobileNumber(mobileNumber);
		if (user.isPresent()) {
			UserApi userApi = this.userMapper.fromUsertoApi(user.get());
			return new ResponseEntity<>(userApi, HttpStatus.CREATED);
		}
       return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
	
	@PostMapping(path = "/register")
    public ResponseEntity<UserApi> register(@RequestBody UserRequest userRequest) {
		UserApi userApi = this.userMapper.fromUsertoApi(this.userService.saveOrUpdate(this.userMapper.toUser(userRequest)));
        return new ResponseEntity<>(userApi, HttpStatus.CREATED);
    }
	
	@PostMapping(path = "/update")
    public ResponseEntity<UserApi> update(@RequestBody UserRequest userRequest) {
		Optional<User> user = this.userService.getUserById(userRequest.getUser_id());
		if (user.isPresent()) {
		UserApi userApi = this.userMapper.fromUsertoApi(this.userService.saveOrUpdate(this.userMapper.toUser(userRequest)));
        return new ResponseEntity<>(userApi, HttpStatus.CREATED);
		}
		 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
	
	

}
