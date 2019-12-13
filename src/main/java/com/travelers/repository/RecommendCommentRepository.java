package com.travelers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.travelers.entity.RecommendCommentEntity;
//import com.travelers.entity.IRecommendComment;

public interface RecommendCommentRepository extends JpaRepository<RecommendCommentEntity, Integer> {	
	List<RecommendCommentEntity> findByRecommendNo(int recommendNo);
}
