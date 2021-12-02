package com.example.websitebanhang.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "Accounts")
public class Account  implements Serializable{
	@Id
	@NotBlank(message="Không được để trống username")
	String username;

	@NotBlank(message="Không được để trống password")
	String password;

	@NotBlank(message="Không được để trống fullname")
	String fullname;

	@NotBlank(message="Không được để trống email")
	@Email(message="Email không đúng định dạng")
	String email;

	String photo;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;
}
