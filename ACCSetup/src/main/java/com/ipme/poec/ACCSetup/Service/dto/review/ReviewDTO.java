package com.ipme.poec.ACCSetup.Service.dto.review;

import com.ipme.poec.ACCSetup.Service.dto.SetupDTO;
import com.ipme.poec.ACCSetup.Service.dto.user.UserDTO;

public class ReviewDTO {
	
	private Long id;
	
	private String title;
	
	private String comment;
	
	private UserDTO userDTO;
	
	private SetupDTO setupDTO;

	public ReviewDTO() {
	}

	public ReviewDTO(String title, String comment) {
		this.title = title;
		this.comment = comment;
	}

	public ReviewDTO(String title, String comment, UserDTO userDTO, SetupDTO setupDTO) {
		this.title = title;
		this.comment = comment;
		this.userDTO = userDTO;
		this.setupDTO = setupDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public SetupDTO getSetupDTO() {
		return setupDTO;
	}

	public void setSetupDTO(SetupDTO setupDTO) {
		this.setupDTO = setupDTO;
	}

}
