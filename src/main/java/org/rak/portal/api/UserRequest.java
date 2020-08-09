package org.rak.portal.api;

import java.math.BigInteger;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateOfBirth;
	
	@NotNull
	private BigInteger phoneNumber;
	
	private String email;
	
	private String profession;
	
	private String country;
}
