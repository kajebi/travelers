package com.travelers.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.travelers.entity.RecommendEntity;
import com.travelers.entity.RecommendCommentEntity;
import com.travelers.entity.IRecommend;
import com.travelers.entity.IRecommendAttachedFile;

// FeedEntity�쓽 CRUD瑜� �젣�뼱�븯�뒗 ���옣�냼 �씤�꽣�럹�씠�뒪
// �젙�젹�쓣 泥섎━�븯湲� �쐞�빐�꽌 JpaRepository瑜� �궗�슜
													// �뿏�떚�떚���엯, Id ���엯
public interface RecommendRepository extends JpaRepository<RecommendEntity, Integer> {

	// JPQL(Java Persitent Query Lanaguage)
	// Object Query �씪醫�
	// SELECT f <- 媛앹껜瑜� �꽑�깮
	// SELECT f.id, f.content <- 媛앹껜 2媛쒓� �꽑�깮
	@Query("SELECT f FROM RecommendEntity f") 
	List<IRecommend> findAllWithoutFile(Sort s);
	
	//nativeQuery=true
	// value=�쓽 荑쇰━�뒗 �떎�젣 �뜲�씠�꽣踰좎씠�뒪 荑쇰━濡� �옉�룞�맖
	@Query(value = "SELECT recommend_no, recommend_user_id, recommend_user, recommend_subject, recommend_date, recommend_content, recommend_avgrating, ''AS recommend_content_img FROM recommends ORDER BY recommend_avgrating DESC", nativeQuery=true)
	List<RecommendEntity> findAllWithoutFile();
		
	IRecommendAttachedFile findByRecommendNo(int recommendNo);
	
	//@Query(value = "SELECT f FROM RecommendCommentEntity f WHERE recommend_no = :recommend_no",  nativeQuery=true)
	//List<RecommendCommentEntity> findAllCommentNoById(@Param("recommend_no") int recommendNo);
}
