package org.rak.portal.api;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserResponse {


	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class UserResult {
		List<UserApi> userApiList;
	}

}
