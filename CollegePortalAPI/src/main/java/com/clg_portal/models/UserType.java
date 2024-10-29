package com.clg_portal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_user_type")
@NoArgsConstructor
@Setter
@Getter
public class UserType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_type_id")
	private int id;
	@Column(name="user_type_desc",nullable = false)
	private String userTypeDesc;
	@Column(name="status",length = 1,nullable = false)
	private Character status;
}
