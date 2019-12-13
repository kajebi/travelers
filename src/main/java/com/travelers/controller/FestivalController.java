package com.travelers.controller;

//�옄諛� sdk 湲곕낯 �뙣�궎吏�
import java.util.List;
import java.util.Optional;

//醫낆냽�꽦�쑝濡� 異붽��맂 �뙣�궎吏�
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//�궡媛� 留뚮뱺 �겢�옒�뒪
import com.travelers.entity.FestivalEntity;
import com.travelers.entity.IFestival;
import com.travelers.entity.IFestivalAttachedFile;
import com.travelers.entity.RecommendEntity;
import com.travelers.repository.FestivalRepository;

@RestController
public class FestivalController {
	
	@Autowired
	FestivalRepository festivalRepo;
	
	/*
	// �뵾�뱶 紐⑸줉 議고쉶
	@RequestMapping(value="/feeds", method=RequestMethod.GET)
	public List<FeedEntity> getFeeds() throws Exception{
					    // findAll �뿏�떚�떚 �쟾泥댁“�쉶
		                // new Sort(Sort.Direction.DESC,"id")
		                // -> id �븘�뱶瑜� 湲곗��쑝濡� �뿭�젙�젹 
		return feedRepo.findAll(new Sort(Sort.Direction.DESC,"id"));
	}
	*/
	
	// �뵾�뱶 紐⑸줉 議고쉶(�뙆�씪�젣�쇅)
	@RequestMapping(value="/festivals", method=RequestMethod.GET)
	//public List<Ifestival> getfestivals() throws Exception{
	public List<FestivalEntity> getFestivals() throws Exception{
		//return feedRepo.findAllWithoutFile(new Sort(Sort.Direction.DESC, "id"));
		//List<festivalEntity> list =festivalRepo.findAll();
		//System.out.println();
		return festivalRepo.findAllWithoutFile();
	}	
	
	// �뵾�뱶 ���옣(POST, PUT)
	// 寃쎈줈: /由ъ냼�뒪/�븘�씠�뵒
	// 硫붿냼�뱶: GET, POST, PUT, DELETE, PATCH, OPTIONS.. �벑�벑
	@RequestMapping(value="/festivals", method= {RequestMethod.POST, RequestMethod.PUT})
	public FestivalEntity saveFestival(@RequestBody FestivalEntity f) throws Exception{
		// upsert - id媛� �엳�쑝硫� update, �뾾�쑝硫� insert
		return festivalRepo.save(f); 
	}
	
	//@RequestMapping(value="/festivals/POST", method=RequestMethod.POST)
	//public String setfestival(@RequestBody String e) throws Exception{
	//	System.out.println(e);
	//	return e;
	//}
	
	// �뵾�뱶 �궘�젣
	// ex) /feeds/1
	// 硫붿냼�뱶: DELETE
	// feeds 由ъ냼�뒪�뿉 �븘�씠�뵒 1�씤 �젅肄붾뱶瑜� DELETE �빐�씪
	@RequestMapping(value="/festivals/{festivalNo}", method=RequestMethod.DELETE)
	public void removeFestival(@PathVariable int festivalNo) throws Exception{		
		festivalRepo.deleteById(festivalNo);
	}
	
	// �뵾�뱶 泥⑤��뙆�씪 議고쉶
	@RequestMapping(value="/festivals/{festivalNo}", method=RequestMethod.GET)
	public IFestivalAttachedFile getFestival(@PathVariable int festivalNo) throws Exception{		
		return festivalRepo.findByFestivalNo(festivalNo);
	}
	@RequestMapping(value="/festivals/detail/{festivalNo}", method=RequestMethod.GET)
	public Optional<FestivalEntity> getFestivals(@PathVariable int festivalNo) throws Exception{		
		return festivalRepo.findById(festivalNo);
	}
}
