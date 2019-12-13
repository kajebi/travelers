package com.travelers.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Column;

import java.util.Date;

@Entity // �뜲�씠�꽣踰좎씠�뒪 �뿰寃곕릺�뒗 媛앹껜�떎
@Table(name="course_comments") // �뿰寃곕릺�뒗 �뀒�씠釉� �씠由� �젙�쓽
@NoArgsConstructor // �깮�꽦�옄�쓽 留ㅺ컻蹂��닔媛� �뾾�떎
@Data // 濡щ났�쑝濡� getter, setter �옄�룞 �깮�꽦
public class CourseCommentEntity {
	
	@Id  // �뀒�씠釉붿쓽 pk�엫�쓣 吏��젙
	@GeneratedValue(strategy=GenerationType.AUTO) // �옄�룞利앷� 而щ읆
	private int commentNo;
	
	@Column(nullable=false)
	private String commentContent;
	
	@Column(nullable=false) // �뀒�씠釉붿뿉 而щ읆�쑝濡� �븘�뱶瑜� 吏��젙
	private String commentUser;
	
	@Column(columnDefinition = "TEXT", updatable = false)
	private String commentUserImg;
	
	@Column(nullable=false)
	private float commentRating;

	//@OneToMany
	//@JoinColumn(name="Course_no")
	@Column(nullable=false)
	private int courseNo;
	
	@Column(nullable=false)
	private Date commentDate;
	
}
