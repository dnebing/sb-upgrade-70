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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import com.liferay.school.model.Course;

import java.util.List;

/**
 * The persistence utility for the course service. This utility wraps {@link com.liferay.school.service.persistence.impl.CoursePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see CoursePersistence
 * @see com.liferay.school.service.persistence.impl.CoursePersistenceImpl
 * @generated
 */
@ProviderType
public class CourseUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Course course) {
		getPersistence().clearCache(course);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Course> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Course update(Course course) {
		return getPersistence().update(course);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Course update(Course course, ServiceContext serviceContext) {
		return getPersistence().update(course, serviceContext);
	}

	/**
	* Returns all the courses where department = &#63;.
	*
	* @param department the department
	* @return the matching courses
	*/
	public static List<Course> findByDepartment(java.lang.String department) {
		return getPersistence().findByDepartment(department);
	}

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
	public static List<Course> findByDepartment(java.lang.String department,
		int start, int end) {
		return getPersistence().findByDepartment(department, start, end);
	}

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
	public static List<Course> findByDepartment(java.lang.String department,
		int start, int end, OrderByComparator<Course> orderByComparator) {
		return getPersistence()
				   .findByDepartment(department, start, end, orderByComparator);
	}

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
	public static List<Course> findByDepartment(java.lang.String department,
		int start, int end, OrderByComparator<Course> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDepartment(department, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first course in the ordered set where department = &#63;.
	*
	* @param department the department
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public static Course findByDepartment_First(java.lang.String department,
		OrderByComparator<Course> orderByComparator)
		throws com.liferay.school.exception.NoSuchCourseException {
		return getPersistence()
				   .findByDepartment_First(department, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where department = &#63;.
	*
	* @param department the department
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	*/
	public static Course fetchByDepartment_First(java.lang.String department,
		OrderByComparator<Course> orderByComparator) {
		return getPersistence()
				   .fetchByDepartment_First(department, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where department = &#63;.
	*
	* @param department the department
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public static Course findByDepartment_Last(java.lang.String department,
		OrderByComparator<Course> orderByComparator)
		throws com.liferay.school.exception.NoSuchCourseException {
		return getPersistence()
				   .findByDepartment_Last(department, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where department = &#63;.
	*
	* @param department the department
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	*/
	public static Course fetchByDepartment_Last(java.lang.String department,
		OrderByComparator<Course> orderByComparator) {
		return getPersistence()
				   .fetchByDepartment_Last(department, orderByComparator);
	}

	/**
	* Returns the courses before and after the current course in the ordered set where department = &#63;.
	*
	* @param courseId the primary key of the current course
	* @param department the department
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws NoSuchCourseException if a course with the primary key could not be found
	*/
	public static Course[] findByDepartment_PrevAndNext(long courseId,
		java.lang.String department, OrderByComparator<Course> orderByComparator)
		throws com.liferay.school.exception.NoSuchCourseException {
		return getPersistence()
				   .findByDepartment_PrevAndNext(courseId, department,
			orderByComparator);
	}

	/**
	* Removes all the courses where department = &#63; from the database.
	*
	* @param department the department
	*/
	public static void removeByDepartment(java.lang.String department) {
		getPersistence().removeByDepartment(department);
	}

	/**
	* Returns the number of courses where department = &#63;.
	*
	* @param department the department
	* @return the number of matching courses
	*/
	public static int countByDepartment(java.lang.String department) {
		return getPersistence().countByDepartment(department);
	}

	/**
	* Returns the course where courseCode = &#63; or throws a {@link NoSuchCourseException} if it could not be found.
	*
	* @param courseCode the course code
	* @return the matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public static Course findByCourseCode(java.lang.String courseCode)
		throws com.liferay.school.exception.NoSuchCourseException {
		return getPersistence().findByCourseCode(courseCode);
	}

	/**
	* Returns the course where courseCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param courseCode the course code
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public static Course fetchByCourseCode(java.lang.String courseCode) {
		return getPersistence().fetchByCourseCode(courseCode);
	}

	/**
	* Returns the course where courseCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param courseCode the course code
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public static Course fetchByCourseCode(java.lang.String courseCode,
		boolean retrieveFromCache) {
		return getPersistence().fetchByCourseCode(courseCode, retrieveFromCache);
	}

	/**
	* Removes the course where courseCode = &#63; from the database.
	*
	* @param courseCode the course code
	* @return the course that was removed
	*/
	public static Course removeByCourseCode(java.lang.String courseCode)
		throws com.liferay.school.exception.NoSuchCourseException {
		return getPersistence().removeByCourseCode(courseCode);
	}

	/**
	* Returns the number of courses where courseCode = &#63;.
	*
	* @param courseCode the course code
	* @return the number of matching courses
	*/
	public static int countByCourseCode(java.lang.String courseCode) {
		return getPersistence().countByCourseCode(courseCode);
	}

	/**
	* Returns the course where name = &#63; or throws a {@link NoSuchCourseException} if it could not be found.
	*
	* @param name the name
	* @return the matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public static Course findByName(java.lang.String name)
		throws com.liferay.school.exception.NoSuchCourseException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the course where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public static Course fetchByName(java.lang.String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the course where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public static Course fetchByName(java.lang.String name,
		boolean retrieveFromCache) {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the course where name = &#63; from the database.
	*
	* @param name the name
	* @return the course that was removed
	*/
	public static Course removeByName(java.lang.String name)
		throws com.liferay.school.exception.NoSuchCourseException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of courses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching courses
	*/
	public static int countByName(java.lang.String name) {
		return getPersistence().countByName(name);
	}

	/**
	* Caches the course in the entity cache if it is enabled.
	*
	* @param course the course
	*/
	public static void cacheResult(Course course) {
		getPersistence().cacheResult(course);
	}

	/**
	* Caches the courses in the entity cache if it is enabled.
	*
	* @param courses the courses
	*/
	public static void cacheResult(List<Course> courses) {
		getPersistence().cacheResult(courses);
	}

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param courseId the primary key for the new course
	* @return the new course
	*/
	public static Course create(long courseId) {
		return getPersistence().create(courseId);
	}

	/**
	* Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the course
	* @return the course that was removed
	* @throws NoSuchCourseException if a course with the primary key could not be found
	*/
	public static Course remove(long courseId)
		throws com.liferay.school.exception.NoSuchCourseException {
		return getPersistence().remove(courseId);
	}

	public static Course updateImpl(Course course) {
		return getPersistence().updateImpl(course);
	}

	/**
	* Returns the course with the primary key or throws a {@link NoSuchCourseException} if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course
	* @throws NoSuchCourseException if a course with the primary key could not be found
	*/
	public static Course findByPrimaryKey(long courseId)
		throws com.liferay.school.exception.NoSuchCourseException {
		return getPersistence().findByPrimaryKey(courseId);
	}

	/**
	* Returns the course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course, or <code>null</code> if a course with the primary key could not be found
	*/
	public static Course fetchByPrimaryKey(long courseId) {
		return getPersistence().fetchByPrimaryKey(courseId);
	}

	public static java.util.Map<java.io.Serializable, Course> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the courses.
	*
	* @return the courses
	*/
	public static List<Course> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Course> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Course> findAll(int start, int end,
		OrderByComparator<Course> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Course> findAll(int start, int end,
		OrderByComparator<Course> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the courses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of courses.
	*
	* @return the number of courses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CoursePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CoursePersistence)PortletBeanLocatorUtil.locate(com.liferay.school.service.ClpSerializer.getServletContextName(),
					CoursePersistence.class.getName());

			ReferenceRegistry.registerReference(CourseUtil.class, "_persistence");
		}

		return _persistence;
	}

	private static CoursePersistence _persistence;
}