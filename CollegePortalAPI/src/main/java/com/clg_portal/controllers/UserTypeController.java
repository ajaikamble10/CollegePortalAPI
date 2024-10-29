package com.clg_portal.controllers; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clg_portal.dtos.UserTypeDto;
import com.clg_portal.services.UserTypeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserTypeController {
	
	@Autowired
	private UserTypeService userTypeService;
	
	@GetMapping("/")
	public ResponseEntity<List<UserTypeDto>> UserTypesList(){
		List<UserTypeDto> list = userTypeService.getAllUserTypes();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/")
	public ResponseEntity<UserTypeDto> createNewUserType(@Valid @RequestBody UserTypeDto userTypeDto){
		UserTypeDto NewUserType = userTypeService.createUserType(userTypeDto);
		return new ResponseEntity<>(NewUserType,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserTypeDto> updateUserType(@Valid @RequestBody UserTypeDto userTypeDto, @PathVariable Integer id){
		UserTypeDto updatedUserType = userTypeService.updateUserType(userTypeDto, id);
		return ResponseEntity.ok(updatedUserType);
	}

}
