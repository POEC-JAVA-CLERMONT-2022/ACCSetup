package com.ipme.poec.ACCSetup.Model;

import javax.persistence.*;

import com.sun.istack.NotNull;


@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reviewId", length = 11)
	private Long reviewId;
	
	@Column(name = "reviewTitle", length = 20)
	@NotNull
	private String reviewTitle;
	
	@Column(name = "reviewComment", length = 144)
	@NotNull
	private String reviewComment;
	
	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@JoinColumn(name = "setup_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Setup setup;

	public Review(String reviewTitle, String reviewComment) {
		this.reviewTitle = reviewTitle;
		this.reviewComment = reviewComment;
	}
	
	public Review(String reviewTitle, String reviewComment, User user, Setup setup) {
		this(reviewTitle, reviewComment);
		this.user = user;
		this.setup = setup;
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

	public Long getReviewId() {
		return reviewId;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public String getReviewComment() {
		return reviewComment;
	}


}
