/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.school.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.school.exception.NoSuchCourseException;
import com.liferay.school.model.Course;

/**
 * The persistence interface for the course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see com.liferay.school.service.persistence.impl.CoursePersistenceImpl
 * @see CourseUtil
 * @generated
 */
@ProviderType
public interface CoursePersistence extends BasePersistence<Course> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseUtil} to access the course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the courses where department = &#63;.
	*
	* @param department the department
	* @return the matching courses
	*/
	public java.util.List<Course> findByDepartment(java.lang.String department);

	/**
	* Returns a range of all the courses where department = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param department the department
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	*/
	public java.util.List<Course> findByDepartment(
		java.lang.String department, int start, int end);

	/**
	* Returns an ordered range of all the courses where department = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param department the department
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	*/
	public java.util.List<Course> findByDepartment(
		java.lang.String department, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Course> orderByComparator);

	/**
	* Returns an ordered range of all the courses where department = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param department the department
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching courses
	*/
	public java.util.List<Course> findByDepartment(
		java.lang.String department, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Course> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first course in the ordered set where department = &#63;.
	*
	* @param department the department
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public Course findByDepartment_First(java.lang.String department,
		com.liferay.portal.kernel.util.OrderByComparator<Course> orderByComparator)
		throws NoSuchCourseException;

	/**
	* Returns the first course in the ordered set where department = &#63;.
	*
	* @param department the department
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	*/
	public Course fetchByDepartment_First(java.lang.String department,
		com.liferay.portal.kernel.util.OrderByComparator<Course> orderByComparator);

	/**
	* Returns the last course in the ordered set where department = &#63;.
	*
	* @param department the department
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public Course findByDepartment_Last(java.lang.String department,
		com.liferay.portal.kernel.util.OrderByComparator<Course> orderByComparator)
		throws NoSuchCourseException;

	/**
	* Returns the last course in the ordered set where department = &#63;.
	*
	* @param department the department
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	*/
	public Course fetchByDepartment_Last(java.lang.String department,
		com.liferay.portal.kernel.util.OrderByComparator<Course> orderByComparator);

	/**
	* Returns the courses before and after the current course in the ordered set where department = &#63;.
	*
	* @param courseId the primary key of the current course
	* @param department the department
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws NoSuchCourseException if a course with the primary key could not be found
	*/
	public Course[] findByDepartment_PrevAndNext(long courseId,
		java.lang.String department,
		com.liferay.portal.kernel.util.OrderByComparator<Course> orderByComparator)
		throws NoSuchCourseException;

	/**
	* Removes all the courses where department = &#63; from the database.
	*
	* @param department the department
	*/
	public void removeByDepartment(java.lang.String department);

	/**
	* Returns the number of courses where department = &#63;.
	*
	* @param department the department
	* @return the number of matching courses
	*/
	public int countByDepartment(java.lang.String department);

	/**
	* Returns the course where courseCode = &#63; or throws a {@link NoSuchCourseException} if it could not be found.
	*
	* @param courseCode the course code
	* @return the matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public Course findByCourseCode(java.lang.String courseCode)
		throws NoSuchCourseException;

	/**
	* Returns the course where courseCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param courseCode the course code
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public Course fetchByCourseCode(java.lang.String courseCode);

	/**
	* Returns the course where courseCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param courseCode the course code
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public Course fetchByCourseCode(java.lang.String courseCode,
		boolean retrieveFromCache);

	/**
	* Removes the course where courseCode = &#63; from the database.
	*
	* @param courseCode the course code
	* @return the course that was removed
	*/
	public Course removeByCourseCode(java.lang.String courseCode)
		throws NoSuchCourseException;

	/**
	* Returns the number of courses where courseCode = &#63;.
	*
	* @param courseCode the course code
	* @return the number of matching courses
	*/
	public int countByCourseCode(java.lang.String courseCode);

	/**
	* Returns the course where name = &#63; or throws a {@link NoSuchCourseException} if it could not be found.
	*
	* @param name the name
	* @return the matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public Course findByName(java.lang.String name)
		throws NoSuchCourseException;

	/**
	* Returns the course where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public Course fetchByName(java.lang.String name);

	/**
	* Returns the course where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public Course fetchByName(java.lang.String name, boolean retrieveFromCache);

	/**
	* Removes the course where name = &#63; from the database.
	*
	* @param name the name
	* @return the course that was removed
	*/
	public Course removeByName(java.lang.String name)
		throws NoSuchCourseException;

	/**
	* Returns the number of courses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching courses
	*/
	public int countByName(java.lang.String name);

	/**
	* Caches the course in the entity cache if it is enabled.
	*
	* @param course the course
	*/
	public void cacheResult(Course course);

	/**
	* Caches the courses in the entity cache if it is enabled.
	*
	* @param courses the courses
	*/
	public void cacheResult(java.util.List<Course> courses);

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param courseId the primary key for the new course
	* @return the new course
	*/
	public Course create(long courseId);

	/**
	* Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the course
	* @return the course that was removed
	* @throws NoSuchCourseException if a course with the primary key could not be found
	*/
	public Course remove(long courseId) throws NoSuchCourseException;

	public Course updateImpl(Course course);

	/**
	* Returns the course with the primary key or throws a {@link NoSuchCourseException} if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course
	* @throws NoSuchCourseException if a course with the primary key could not be found
	*/
	public Course findByPrimaryKey(long courseId) throws NoSuchCourseException;

	/**
	* Returns the course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course, or <code>null</code> if a course with the primary key could not be found
	*/
	public Course fetchByPrimaryKey(long courseId);

	@Override
	public java.util.Map<java.io.Serializable, Course> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the courses.
	*
	* @return the courses
	*/
	public java.util.List<Course> findAll();

	/**
	* Returns a range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of courses
	*/
	public java.util.List<Course> findAll(int start, int end);

	/**
	* Returns an ordered range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of courses
	*/
	public java.util.List<Course> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Course> orderByComparator);

	/**
	* Returns an ordered range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of courses
	*/
	public java.util.List<Course> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Course> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the courses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of courses.
	*
	* @return the number of courses
	*/
	public int countAll();
}