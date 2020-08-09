package org.rak.portal.domain;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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
	private BigInteger phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "profession")
	private String profession;
	
	@Column(name = "country")
	private String country;
}
