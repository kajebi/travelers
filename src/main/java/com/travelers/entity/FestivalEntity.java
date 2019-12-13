package com.travelers.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import java.util.Date;

@Entity // �뜲�씠�꽣踰좎씠�뒪 �뿰寃곕릺�뒗 媛앹껜�떎
@Table(name="festivals") // �뿰寃곕릺�뒗 �뀒�씠釉� �씠由� �젙�쓽
@NoArgsConstructor // �깮�꽦�옄�쓽 留ㅺ컻蹂��닔媛� �뾾�떎
@Data // 濡щ났�쑝濡� getter, setter �옄�룞 �깮�꽦
public class FestivalEntity {
	
	@Id  // �뀒�씠釉붿쓽 pk�엫�쓣 吏��젙
	@GeneratedValue(strategy=GenerationType.AUTO) // �옄�룞利앷� 而щ읆
	private int festivalNo;
	
	@Column(nullable=false, updatable = false) // �뀒�씠釉붿뿉 而щ읆�쑝濡� �븘�뱶瑜� 吏��젙
	private int festivalUserId;
	
	@Column(nullable=false) // �뀒�씠釉붿뿉 而щ읆�쑝濡� �븘�뱶瑜� 吏��젙
	private String festivalUser;
	
	@Column(nullable=false)
	private String festivalSubject;
	
	@Column(nullable=false)
	private Date festivalDate;
	
	@Column(nullable=false)
	private String festivalContent;
	
	@Column(nullable=false)
	private String festivalAvgrating;
	
	@Column(columnDefinition = "TEXT", updatable = false)
	// mysql�쓽 LONGTEXT 泥섎━瑜� �쐞�빐�꽌 ���엯�쓣 吏��젙�빐以�
	private String festivalContentImg;
	
}
