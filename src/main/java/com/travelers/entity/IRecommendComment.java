package com.travelers.entity;

import java.util.Date;

public interface IRecommendComment {
	int getCommentNo();
	String getCommentContent();
	String getCommentUser();
	String getCommentUserImg();
	float getCommentRating();
	Date getCommentDate();
	int getRecommendNo();
	
}
