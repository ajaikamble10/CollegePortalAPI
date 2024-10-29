package com.clg_portal.services;

import java.util.List;

import com.clg_portal.dtos.UserTypeDto;

public interface UserTypeService {
	public List<UserTypeDto> getAllUserTypes();
	public UserTypeDto createUserType(UserTypeDto usertypeDto);
	public UserTypeDto updateUserType(UserTypeDto userTypeDto,int id);
}
