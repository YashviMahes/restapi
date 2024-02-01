package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	//List<Course> list;
	public CourseServiceImpl() {
		/*
		 * list = new ArrayList<Course>(); list.add(new
		 * Course(145,"Java Core Course","This course is very helpful")); list.add(new
		 * Course(146,"Spring Boot Course","This course is very helpful"));
		 */
	}

	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}

	public Course getCourse(long courseId) {
		/*
		 * Course c= null; for(Course course:list) { if(course.getId()==courseId) {
		 * c=course; break; } } return c;
		 */
		return courseDao.getOne(courseId);
	}
	
	public Course addCourse(Course course) {
		//list.add(course);
		courseDao.save(course);
		return course;
	}

	public Course updateCourse(Course course) {
		 courseDao.save(course);
		 return course;
	}

	public void deleteCourse(long parseLong) {
	//list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());	
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
		
	}

	

	

}
