package com.travelers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travelers.entity.CourseCommentEntity;
import com.travelers.repository.CourseCommentRepository;

@RestController
public class CourseCommentController {
	@Autowired
	CourseCommentRepository commentRepo;
	
	@RequestMapping(value="/courses/comment/{courseNo}", method=RequestMethod.GET)
	public List<CourseCommentEntity> getComments(@PathVariable int courseNo) throws Exception{
		return commentRepo.findByCourseNo(courseNo);
	}
}
