package org.rak.portal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@EntityScan
@Table(name = "User")
@AllArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") 
	private Integer user_id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "phone_number")
	private Long phoneNumber;
	
	@Column(name = "profession")
	private String profession;
	
	@Column(name = "country")
	private String country;
}
