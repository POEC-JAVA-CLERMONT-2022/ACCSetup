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
	private Long userId;

	@NotBlank
	private Long setupId;

	public CreateReviewDTO() {
	}

	public CreateReviewDTO(String title, String comment) {
		this.title = title;
		this.comment = comment;
	}

	public CreateReviewDTO(String title, String comment, Long userId,
			Long setupId) {
		this.title = title;
		this.comment = comment;
		this.userId = userId;
		this.setupId = setupId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSetupId() {
		return setupId;
	}

	public void setSetupId(Long setupId) {
		this.setupId = setupId;
	}

	

	
}
