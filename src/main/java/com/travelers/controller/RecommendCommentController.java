package com.travelers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travelers.entity.RecommendCommentEntity;
import com.travelers.repository.RecommendCommentRepository;

@RestController
public class RecommendCommentController {
	@Autowired
	RecommendCommentRepository commentRepo;
	
	@RequestMapping(value="/recommends/comment/{recommendNo}", method=RequestMethod.GET)
	public List<RecommendCommentEntity> getComments(@PathVariable int recommendNo) throws Exception{
		return commentRepo.findByRecommendNo(recommendNo);
	}
}
