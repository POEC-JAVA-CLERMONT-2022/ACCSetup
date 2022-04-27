package com.ipme.poec.ACCSetup.Service.dto.review;

import javax.validation.constraints.NotBlank;

import com.ipme.poec.ACCSetup.Model.Setup;
import com.ipme.poec.ACCSetup.Model.User;

public class CreateReviewDTO {
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String comment;
	
	@NotBlank
	private User user;

	@NotBlank
	private Setup setup;

	public CreateReviewDTO() {
	}

	public CreateReviewDTO(String title, String comment, User user,
			Setup setup) {
		this.title = title;
		this.comment = comment;
		this.user = user;
		this.setup = setup;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}

	
}
