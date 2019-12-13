package com.travelers.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.travelers.entity.FestivalEntity;
import com.travelers.entity.IFestival;
import com.travelers.entity.IFestivalAttachedFile;

// FeedEntity�쓽 CRUD瑜� �젣�뼱�븯�뒗 ���옣�냼 �씤�꽣�럹�씠�뒪
// �젙�젹�쓣 泥섎━�븯湲� �쐞�빐�꽌 JpaRepository瑜� �궗�슜
													// �뿏�떚�떚���엯, Id ���엯
public interface FestivalRepository extends JpaRepository<FestivalEntity, Integer> {

	// JPQL(Java Persitent Query Lanaguage)
	// Object Query �씪醫�
	// SELECT f <- 媛앹껜瑜� �꽑�깮
	// SELECT f.id, f.content <- 媛앹껜 2媛쒓� �꽑�깮
	@Query("SELECT f FROM FestivalEntity f") 
	List<IFestival> findAllWithoutFile(Sort s);
	
	//nativeQuery=true
	// value=�쓽 荑쇰━�뒗 �떎�젣 �뜲�씠�꽣踰좎씠�뒪 荑쇰━濡� �옉�룞�맖
	@Query(value = "SELECT festival_no, festival_user_id, festival_user, festival_subject, festival_date, festival_content, festival_avgrating, ''AS festival_content_img FROM festivals ORDER BY festival_avgrating DESC", nativeQuery=true)
	List<FestivalEntity> findAllWithoutFile();
	
	//@Query("SELECT f FROM festivalEntity f WHERE festival_no = :festival_no")
	//IfestivalAttachedFile findAttachedFileById(@Param("festival_no") int recommenNo);
	
	IFestivalAttachedFile findByFestivalNo(int festivalNo);
}
