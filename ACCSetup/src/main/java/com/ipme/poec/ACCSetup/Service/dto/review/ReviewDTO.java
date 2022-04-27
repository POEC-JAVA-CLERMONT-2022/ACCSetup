package com.ipme.poec.ACCSetup.Service.dto.review;

import com.ipme.poec.ACCSetup.Model.Setup;
import com.ipme.poec.ACCSetup.Model.User;

public class ReviewDTO {
	
	private Long id;
	
	private String title;
	
	private String comment;
	
	private User user;
	
	private Setup setup;

	public ReviewDTO() {
	}

	public ReviewDTO(String title, String comment) {
		this.title = title;
		this.comment = comment;
	}

	public ReviewDTO(String title, String comment, User user, Setup setup) {
		this.title = title;
		this.comment = comment;
		this.user = user;
		this.setup = setup;
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
