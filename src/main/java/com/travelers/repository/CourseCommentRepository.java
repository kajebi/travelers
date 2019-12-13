package com.travelers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelers.entity.CourseCommentEntity;

public interface CourseCommentRepository extends JpaRepository<CourseCommentEntity, Integer> {	
	List<CourseCommentEntity> findByCourseNo(int courseNo);
}
