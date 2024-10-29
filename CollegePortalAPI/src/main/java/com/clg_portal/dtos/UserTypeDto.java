package com.clg_portal.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserTypeDto {
	public int id;
	@NotNull
	@Size(min=4,max = 10,message = "User Type must be contains minimum 4 characters.")
	public String userTypeDesc;
	@NotNull
	public Character status;
}
