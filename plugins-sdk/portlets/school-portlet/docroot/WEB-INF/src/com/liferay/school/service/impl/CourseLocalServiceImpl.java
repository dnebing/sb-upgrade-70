/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.school.model.Course;
import com.liferay.school.service.base.CourseLocalServiceBaseImpl;

/**
 * The implementation of the course local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.school.service.CourseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author dnebinger
 * @see com.liferay.school.service.base.CourseLocalServiceBaseImpl
 * @see com.liferay.school.service.CourseLocalServiceUtil
 */
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.school.service.CourseLocalServiceUtil} to access the course local service.
	 */
	
	public List<Course> listAllCourses() {
		List<Course> courses = null;
		
		try {
			courses = coursePersistence.findAll();
		} catch (SystemException e) {
			// error during fetch.
		}
		
		if ((courses == null) || (courses.isEmpty())) {
			List<String> calc = new ArrayList<String>(), bio = new ArrayList<String>();
			
			calc.add("MATH110");
			bio.add("SCI100");
			bio.add("SCI200");
			
			// add some courses...
			courses = new ArrayList<Course>();
			
			courses.add(addCourse("CS101","Intro To Programming", "An introduction to programming.", 100, "CS", null));
			courses.add(addCourse("ENG120","English Grammar and Syntax","Working through english grammar and syntax rules.", 100, "ENG", null));
			courses.add(addCourse("MATH210","Calculus II", "Calculus continued", 200, "MATH", calc));
			courses.add(addCourse("SCI300","Organic Chemistry","Organic chemistry of molecules", 300,"SCI", bio));
		}
		
		return courses;
	}
	
	public Course addCourse(final String courseCode, final String name, final String description, final int level, final String department, final List<String> preqs) {
		Course course = null;
		
		String prereqs = null;
		
		if ((preqs != null) && (! preqs.isEmpty())) {
			boolean first = true;
			StringBuilder sb = new StringBuilder();
			
			for (String preq : preqs) {
				if (!first) sb.append(',');
				sb.append(preq);
				first = false;
			}
			
			prereqs = sb.toString();
		}
		
		try {
			course = createCourse(counterLocalService.increment(Course.class.getName()));
			
			course.setDepartment(department);
			course.setDescription(description);
			course.setCourseCode(courseCode);
			course.setLevel(level);
			course.setName(name);
			course.setPrereqs(prereqs);
			
			course = addCourse(course);
		} catch (SystemException e) {
			// error adding course
		}
		
		return course;
	}
}