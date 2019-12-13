package com.travelers.entity;

import java.util.Date;
//projection�쓣 �씠�슜�븯�뿬 �듅�젙而щ읆留� 議고쉶�븯寃좊떎.
//�씤�꽣�럹�씠�뒪 �깮�꽦
public interface IFestival {
	
	// �븘�뱶�쓽 getter�� �젙�솗�엳 留욎텛�뼱�빞�븿
	int getFestivalNo();
	int getFestivalUserId();
	String getFestivalUser();
	String getFestivalSubject();
	Date getFestivalDate();
	String getFestivalContent();
	float getFestivalAvgrating();
}
