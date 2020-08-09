package org.rak.portal.api;

import java.util.Date;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	
	@NotNull
	private Integer user_id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;

	@NotNull
	private Date dateOfBirth;
	
	@NotNull
	private Long phoneNumber;
	
	private String email;
	
	private String profession;
	
	private String country;
}
