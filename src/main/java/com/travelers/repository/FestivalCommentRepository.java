package com.travelers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.travelers.entity.FestivalCommentEntity;

public interface FestivalCommentRepository extends JpaRepository<FestivalCommentEntity, Integer> {	
	List<FestivalCommentEntity> findByFestivalNo(int FestivalNo);
}
