package com.clg_portal.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clg_portal.dtos.UserTypeDto;
import com.clg_portal.exceptions.ResourceNotFoundException;
import com.clg_portal.models.UserType;
import com.clg_portal.repos.UserTypeRepository;
import com.clg_portal.services.UserTypeService;

@Service
public class UserTypeServiceImpl implements UserTypeService {
	
	@Autowired
	private UserTypeRepository userTypeRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<UserTypeDto> getAllUserTypes() {
		List<UserType> list = userTypeRepo.findAll();
		List<UserTypeDto> AllUserTypes = list.stream().map(items->UserTypeToDto(items)).collect(Collectors.toList());
		return AllUserTypes;
	}
	
	public UserTypeDto UserTypeToDto(UserType userType) {
		UserTypeDto typeDto = modelMapper.map(userType, UserTypeDto.class);
		return typeDto;
	}
	
	public UserType DtoToUserType(UserTypeDto userTypeDto) {
		UserType type = modelMapper.map(userTypeDto, UserType.class);
		return type;
	}

	@Override
	public UserTypeDto createUserType(UserTypeDto usertypeDto) {
		UserType userType=DtoToUserType(usertypeDto);
		UserType saveUserType = userTypeRepo.save(userType);
		return UserTypeToDto(saveUserType);
	}

	@Override
	public UserTypeDto updateUserType(UserTypeDto userTypeDto, int id) {
		UserType userType = userTypeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User Type","id",id));
		userType.setUserTypeDesc(userTypeDto.getUserTypeDesc());
		userType.setStatus(userTypeDto.getStatus());
		UserType updatedUserType = userTypeRepo.save(userType);
		UserTypeDto updatedUserTypeDto = UserTypeToDto(updatedUserType);
		return updatedUserTypeDto;
	}

}
