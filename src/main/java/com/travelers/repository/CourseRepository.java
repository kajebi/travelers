package com.travelers.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.travelers.entity.CourseEntity;
import com.travelers.entity.ICourse;
import com.travelers.entity.ICourseAttachedFile;

// FeedEntity�쓽 CRUD瑜� �젣�뼱�븯�뒗 ���옣�냼 �씤�꽣�럹�씠�뒪
// �젙�젹�쓣 泥섎━�븯湲� �쐞�빐�꽌 JpaRepository瑜� �궗�슜
													// �뿏�떚�떚���엯, Id ���엯
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

	// JPQL(Java Persitent Query Lanaguage)
	// Object Query �씪醫�
	// SELECT f <- 媛앹껜瑜� �꽑�깮
	// SELECT f.id, f.content <- 媛앹껜 2媛쒓� �꽑�깮
	@Query("SELECT f FROM CourseEntity f") 
	List<ICourse> findAllWithoutFile(Sort s);
	
	//nativeQuery=true
	// value=�쓽 荑쇰━�뒗 �떎�젣 �뜲�씠�꽣踰좎씠�뒪 荑쇰━濡� �옉�룞�맖
	@Query(value = "SELECT course_no, course_user_id, course_user, course_subject, course_date, course_content, course_avgrating, ''AS course_content_img FROM courses ORDER BY course_avgrating DESC", nativeQuery=true)
	List<CourseEntity> findAllWithoutFile();
	
	//@Query("SELECT f FROM courseEntity f WHERE course_no = :course_no")
	//IcourseAttachedFile findAttachedFileById(@Param("course_no") int recommenNo);
	
	ICourseAttachedFile findByCourseNo(int courseNo);
}
