package com.travelers.entity;

import java.util.Date;
//projection�쓣 �씠�슜�븯�뿬 �듅�젙而щ읆留� 議고쉶�븯寃좊떎.
//�씤�꽣�럹�씠�뒪 �깮�꽦
public interface IRecommend {
	
	// �븘�뱶�쓽 getter�� �젙�솗�엳 留욎텛�뼱�빞�븿
	int getRcommendNo();
	int getRecommendUserId();
	String getRecommendUser();
	String getRecommendSubject();
	Date getRecommendDate();
	String getRecommendContent();
	float getRecommendAvgrating();
}
