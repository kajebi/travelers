package com.travelers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travelers.entity.FestivalCommentEntity;
import com.travelers.repository.FestivalCommentRepository;

@RestController
public class FestivalCommentController {
	@Autowired
	FestivalCommentRepository commentRepo;
	
	@RequestMapping(value="/festivals/comment/{FestivalNo}", method=RequestMethod.GET)
	public List<FestivalCommentEntity> getComments(@PathVariable int FestivalNo) throws Exception{
		return commentRepo.findByFestivalNo(FestivalNo);
	}
}
