package org.rak.portal.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.rak.portal.api.UserApi;
import org.rak.portal.api.UserRequest;
import org.rak.portal.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
	
	public UserApi fromUsertoApi(User user) {
		return UserApi.builder().user_id(user.getUser_id())
		.firstName(user.getFirstName())
		.lastName(user.getLastName())
		.dateOfBirth(user.getDateOfBirth())
		.phoneNumber(user.getPhoneNumber())
		.email(user.getEmail())
		.country(user.getCountry())
		.profession(user.getProfession()).build();
	}
	
	public User toUser(UserRequest userRequest) {
		return User.builder().user_id(userRequest.getUser_id())
				.firstName(userRequest.getFirstName())
				.lastName(userRequest.getLastName())
				.dateOfBirth(userRequest.getDateOfBirth())
				.phoneNumber(userRequest.getPhoneNumber())
				.email(userRequest.getEmail())
				.country(userRequest.getCountry())
				.profession(userRequest.getProfession()).build();
	}
	
	public List<UserApi> fromUsersToApis(List<User> users) {
		return users.stream().map(this::fromUsertoApi).collect(Collectors.toList());
	}

}
