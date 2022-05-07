package com.ipme.poec.ACCSetup.Service.dto.review;


public class ReviewDTO {
	
	private Long id;
	
	private String title;
	
	private String comment;
	
	private int userId;
	
	private int setupId;

	public ReviewDTO() {
	}

	public ReviewDTO(String title, String comment) {
		this.title = title;
		this.comment = comment;
	}

	public ReviewDTO(String title, String comment, int userId, int setupId) {
		this.title = title;
		this.comment = comment;
		this.userId = userId;
		this.setupId = setupId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSetupId() {
		return setupId;
	}

	public void setSetupId(int setupId) {
		this.setupId = setupId;
	}

	

}
