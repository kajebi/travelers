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
import com.travelers.entity.CourseEntity;
import com.travelers.entity.ICourse;
import com.travelers.entity.ICourseAttachedFile;
import com.travelers.entity.RecommendEntity;
import com.travelers.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	CourseRepository courseRepo;
	
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
	@RequestMapping(value="/courses", method=RequestMethod.GET)
	//public List<Icourse> getcourses() throws Exception{
	public List<CourseEntity> getCourses() throws Exception{
		//return feedRepo.findAllWithoutFile(new Sort(Sort.Direction.DESC, "id"));
		//List<courseEntity> list =courseRepo.findAll();
		//System.out.println();
		return courseRepo.findAllWithoutFile();
	}	
	
	// �뵾�뱶 ���옣(POST, PUT)
	// 寃쎈줈: /由ъ냼�뒪/�븘�씠�뵒
	// 硫붿냼�뱶: GET, POST, PUT, DELETE, PATCH, OPTIONS.. �벑�벑
	@RequestMapping(value="/courses", method= {RequestMethod.POST, RequestMethod.PUT})
	public CourseEntity saveCourse(@RequestBody CourseEntity f) throws Exception{
		// upsert - id媛� �엳�쑝硫� update, �뾾�쑝硫� insert
		return courseRepo.save(f); 
	}
	
	//@RequestMapping(value="/courses/POST", method=RequestMethod.POST)
	//public String setcourse(@RequestBody String e) throws Exception{
	//	System.out.println(e);
	//	return e;
	//}
	
	// �뵾�뱶 �궘�젣
	// ex) /feeds/1
	// 硫붿냼�뱶: DELETE
	// feeds 由ъ냼�뒪�뿉 �븘�씠�뵒 1�씤 �젅肄붾뱶瑜� DELETE �빐�씪
	@RequestMapping(value="/courses/{courseNo}", method=RequestMethod.DELETE)
	public void removeCourse(@PathVariable int courseNo) throws Exception{		
		courseRepo.deleteById(courseNo);
	}
	
	// �뵾�뱶 泥⑤��뙆�씪 議고쉶
	@RequestMapping(value="/courses/{courseNo}", method=RequestMethod.GET)
	public ICourseAttachedFile getCourse(@PathVariable int courseNo) throws Exception{		
		return courseRepo.findByCourseNo(courseNo);
	}
	@RequestMapping(value="/courses/detail/{courseNo}", method=RequestMethod.GET)
	public Optional<CourseEntity> getCourses(@PathVariable int courseNo) throws Exception{		
		return courseRepo.findById(courseNo);
	}
}
