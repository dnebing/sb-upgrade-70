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

package com.liferay.school.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import com.liferay.school.exception.NoSuchCourseException;
import com.liferay.school.model.Course;
import com.liferay.school.model.impl.CourseImpl;
import com.liferay.school.model.impl.CourseModelImpl;
import com.liferay.school.service.persistence.CoursePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnebinger
 * @see CoursePersistence
 * @see com.liferay.school.service.persistence.CourseUtil
 * @generated
 */
@ProviderType
public class CoursePersistenceImpl extends BasePersistenceImpl<Course>
	implements CoursePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseUtil} to access the course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENT =
		new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartment",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT =
		new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDepartment",
			new String[] { String.class.getName() },
			CourseModelImpl.DEPARTMENT_COLUMN_BITMASK |
			CourseModelImpl.COURSECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENT = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartment",
			new String[] { String.class.getName() });

	/**
	 * Returns all the courses where department = &#63;.
	 *
	 * @param department the department
	 * @return the matching courses
	 */
	@Override
	public List<Course> findByDepartment(String department) {
		return findByDepartment(department, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Course> findByDepartment(String department, int start, int end) {
		return findByDepartment(department, start, end, null);
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
	@Override
	public List<Course> findByDepartment(String department, int start, int end,
		OrderByComparator<Course> orderByComparator) {
		return findByDepartment(department, start, end, orderByComparator, true);
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
	@Override
	public List<Course> findByDepartment(String department, int start, int end,
		OrderByComparator<Course> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT;
			finderArgs = new Object[] { department };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENT;
			finderArgs = new Object[] { department, start, end, orderByComparator };
		}

		List<Course> list = null;

		if (retrieveFromCache) {
			list = (List<Course>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Course course : list) {
					if (!Objects.equals(department, course.getDepartment())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COURSE_WHERE);

			boolean bindDepartment = false;

			if (department == null) {
				query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_1);
			}
			else if (department.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_3);
			}
			else {
				bindDepartment = true;

				query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDepartment) {
					qPos.add(department);
				}

				if (!pagination) {
					list = (List<Course>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Course>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first course in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course
	 * @throws NoSuchCourseException if a matching course could not be found
	 */
	@Override
	public Course findByDepartment_First(String department,
		OrderByComparator<Course> orderByComparator)
		throws NoSuchCourseException {
		Course course = fetchByDepartment_First(department, orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("department=");
		msg.append(department);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseException(msg.toString());
	}

	/**
	 * Returns the first course in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course, or <code>null</code> if a matching course could not be found
	 */
	@Override
	public Course fetchByDepartment_First(String department,
		OrderByComparator<Course> orderByComparator) {
		List<Course> list = findByDepartment(department, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course
	 * @throws NoSuchCourseException if a matching course could not be found
	 */
	@Override
	public Course findByDepartment_Last(String department,
		OrderByComparator<Course> orderByComparator)
		throws NoSuchCourseException {
		Course course = fetchByDepartment_Last(department, orderByComparator);

		if (course != null) {
			return course;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("department=");
		msg.append(department);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseException(msg.toString());
	}

	/**
	 * Returns the last course in the ordered set where department = &#63;.
	 *
	 * @param department the department
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course, or <code>null</code> if a matching course could not be found
	 */
	@Override
	public Course fetchByDepartment_Last(String department,
		OrderByComparator<Course> orderByComparator) {
		int count = countByDepartment(department);

		if (count == 0) {
			return null;
		}

		List<Course> list = findByDepartment(department, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Course[] findByDepartment_PrevAndNext(long courseId,
		String department, OrderByComparator<Course> orderByComparator)
		throws NoSuchCourseException {
		Course course = findByPrimaryKey(courseId);

		Session session = null;

		try {
			session = openSession();

			Course[] array = new CourseImpl[3];

			array[0] = getByDepartment_PrevAndNext(session, course, department,
					orderByComparator, true);

			array[1] = course;

			array[2] = getByDepartment_PrevAndNext(session, course, department,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Course getByDepartment_PrevAndNext(Session session,
		Course course, String department,
		OrderByComparator<Course> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSE_WHERE);

		boolean bindDepartment = false;

		if (department == null) {
			query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_1);
		}
		else if (department.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_3);
		}
		else {
			bindDepartment = true;

			query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CourseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDepartment) {
			qPos.add(department);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(course);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Course> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the courses where department = &#63; from the database.
	 *
	 * @param department the department
	 */
	@Override
	public void removeByDepartment(String department) {
		for (Course course : findByDepartment(department, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(course);
		}
	}

	/**
	 * Returns the number of courses where department = &#63;.
	 *
	 * @param department the department
	 * @return the number of matching courses
	 */
	@Override
	public int countByDepartment(String department) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEPARTMENT;

		Object[] finderArgs = new Object[] { department };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSE_WHERE);

			boolean bindDepartment = false;

			if (department == null) {
				query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_1);
			}
			else if (department.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_3);
			}
			else {
				bindDepartment = true;

				query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDepartment) {
					qPos.add(department);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DEPARTMENT_DEPARTMENT_1 = "course.department IS NULL";
	private static final String _FINDER_COLUMN_DEPARTMENT_DEPARTMENT_2 = "course.department = ?";
	private static final String _FINDER_COLUMN_DEPARTMENT_DEPARTMENT_3 = "(course.department IS NULL OR course.department = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_COURSECODE = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCourseCode",
			new String[] { String.class.getName() },
			CourseModelImpl.COURSECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSECODE = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the course where courseCode = &#63; or throws a {@link NoSuchCourseException} if it could not be found.
	 *
	 * @param courseCode the course code
	 * @return the matching course
	 * @throws NoSuchCourseException if a matching course could not be found
	 */
	@Override
	public Course findByCourseCode(String courseCode)
		throws NoSuchCourseException {
		Course course = fetchByCourseCode(courseCode);

		if (course == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("courseCode=");
			msg.append(courseCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCourseException(msg.toString());
		}

		return course;
	}

	/**
	 * Returns the course where courseCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param courseCode the course code
	 * @return the matching course, or <code>null</code> if a matching course could not be found
	 */
	@Override
	public Course fetchByCourseCode(String courseCode) {
		return fetchByCourseCode(courseCode, true);
	}

	/**
	 * Returns the course where courseCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param courseCode the course code
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching course, or <code>null</code> if a matching course could not be found
	 */
	@Override
	public Course fetchByCourseCode(String courseCode, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { courseCode };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_COURSECODE,
					finderArgs, this);
		}

		if (result instanceof Course) {
			Course course = (Course)result;

			if (!Objects.equals(courseCode, course.getCourseCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COURSE_WHERE);

			boolean bindCourseCode = false;

			if (courseCode == null) {
				query.append(_FINDER_COLUMN_COURSECODE_COURSECODE_1);
			}
			else if (courseCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSECODE_COURSECODE_3);
			}
			else {
				bindCourseCode = true;

				query.append(_FINDER_COLUMN_COURSECODE_COURSECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCourseCode) {
					qPos.add(courseCode);
				}

				List<Course> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_COURSECODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CoursePersistenceImpl.fetchByCourseCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Course course = list.get(0);

					result = course;

					cacheResult(course);

					if ((course.getCourseCode() == null) ||
							!course.getCourseCode().equals(courseCode)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_COURSECODE,
							finderArgs, course);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_COURSECODE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Course)result;
		}
	}

	/**
	 * Removes the course where courseCode = &#63; from the database.
	 *
	 * @param courseCode the course code
	 * @return the course that was removed
	 */
	@Override
	public Course removeByCourseCode(String courseCode)
		throws NoSuchCourseException {
		Course course = findByCourseCode(courseCode);

		return remove(course);
	}

	/**
	 * Returns the number of courses where courseCode = &#63;.
	 *
	 * @param courseCode the course code
	 * @return the number of matching courses
	 */
	@Override
	public int countByCourseCode(String courseCode) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSECODE;

		Object[] finderArgs = new Object[] { courseCode };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSE_WHERE);

			boolean bindCourseCode = false;

			if (courseCode == null) {
				query.append(_FINDER_COLUMN_COURSECODE_COURSECODE_1);
			}
			else if (courseCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COURSECODE_COURSECODE_3);
			}
			else {
				bindCourseCode = true;

				query.append(_FINDER_COLUMN_COURSECODE_COURSECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCourseCode) {
					qPos.add(courseCode);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COURSECODE_COURSECODE_1 = "course.courseCode IS NULL";
	private static final String _FINDER_COLUMN_COURSECODE_COURSECODE_2 = "course.courseCode = ?";
	private static final String _FINDER_COLUMN_COURSECODE_COURSECODE_3 = "(course.courseCode IS NULL OR course.courseCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, CourseImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			CourseModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the course where name = &#63; or throws a {@link NoSuchCourseException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching course
	 * @throws NoSuchCourseException if a matching course could not be found
	 */
	@Override
	public Course findByName(String name) throws NoSuchCourseException {
		Course course = fetchByName(name);

		if (course == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCourseException(msg.toString());
		}

		return course;
	}

	/**
	 * Returns the course where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching course, or <code>null</code> if a matching course could not be found
	 */
	@Override
	public Course fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the course where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching course, or <code>null</code> if a matching course could not be found
	 */
	@Override
	public Course fetchByName(String name, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Course) {
			Course course = (Course)result;

			if (!Objects.equals(name, course.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COURSE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<Course> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CoursePersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Course course = list.get(0);

					result = course;

					cacheResult(course);

					if ((course.getName() == null) ||
							!course.getName().equals(name)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, course);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Course)result;
		}
	}

	/**
	 * Removes the course where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the course that was removed
	 */
	@Override
	public Course removeByName(String name) throws NoSuchCourseException {
		Course course = findByName(name);

		return remove(course);
	}

	/**
	 * Returns the number of courses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching courses
	 */
	@Override
	public int countByName(String name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "course.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "course.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(course.name IS NULL OR course.name = '')";

	public CoursePersistenceImpl() {
		setModelClass(Course.class);
	}

	/**
	 * Caches the course in the entity cache if it is enabled.
	 *
	 * @param course the course
	 */
	@Override
	public void cacheResult(Course course) {
		entityCache.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey(), course);

		finderCache.putResult(FINDER_PATH_FETCH_BY_COURSECODE,
			new Object[] { course.getCourseCode() }, course);

		finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { course.getName() }, course);

		course.resetOriginalValues();
	}

	/**
	 * Caches the courses in the entity cache if it is enabled.
	 *
	 * @param courses the courses
	 */
	@Override
	public void cacheResult(List<Course> courses) {
		for (Course course : courses) {
			if (entityCache.getResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
						CourseImpl.class, course.getPrimaryKey()) == null) {
				cacheResult(course);
			}
			else {
				course.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all courses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CourseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Course course) {
		entityCache.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CourseModelImpl)course);
	}

	@Override
	public void clearCache(List<Course> courses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Course course : courses) {
			entityCache.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
				CourseImpl.class, course.getPrimaryKey());

			clearUniqueFindersCache((CourseModelImpl)course);
		}
	}

	protected void cacheUniqueFindersCache(CourseModelImpl courseModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { courseModelImpl.getCourseCode() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_COURSECODE, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_COURSECODE, args,
				courseModelImpl);

			args = new Object[] { courseModelImpl.getName() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_NAME, args,
				courseModelImpl);
		}
		else {
			if ((courseModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COURSECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { courseModelImpl.getCourseCode() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_COURSECODE, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_COURSECODE, args,
					courseModelImpl);
			}

			if ((courseModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { courseModelImpl.getName() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					courseModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(CourseModelImpl courseModelImpl) {
		Object[] args = new Object[] { courseModelImpl.getCourseCode() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_COURSECODE, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_COURSECODE, args);

		if ((courseModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COURSECODE.getColumnBitmask()) != 0) {
			args = new Object[] { courseModelImpl.getOriginalCourseCode() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COURSECODE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_COURSECODE, args);
		}

		args = new Object[] { courseModelImpl.getName() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((courseModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { courseModelImpl.getOriginalName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new course with the primary key. Does not add the course to the database.
	 *
	 * @param courseId the primary key for the new course
	 * @return the new course
	 */
	@Override
	public Course create(long courseId) {
		Course course = new CourseImpl();

		course.setNew(true);
		course.setPrimaryKey(courseId);

		course.setCompanyId(companyProvider.getCompanyId());

		return course;
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseId the primary key of the course
	 * @return the course that was removed
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	@Override
	public Course remove(long courseId) throws NoSuchCourseException {
		return remove((Serializable)courseId);
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course that was removed
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	@Override
	public Course remove(Serializable primaryKey) throws NoSuchCourseException {
		Session session = null;

		try {
			session = openSession();

			Course course = (Course)session.get(CourseImpl.class, primaryKey);

			if (course == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(course);
		}
		catch (NoSuchCourseException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Course removeImpl(Course course) {
		course = toUnwrappedModel(course);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(course)) {
				course = (Course)session.get(CourseImpl.class,
						course.getPrimaryKeyObj());
			}

			if (course != null) {
				session.delete(course);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (course != null) {
			clearCache(course);
		}

		return course;
	}

	@Override
	public Course updateImpl(Course course) {
		course = toUnwrappedModel(course);

		boolean isNew = course.isNew();

		CourseModelImpl courseModelImpl = (CourseModelImpl)course;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (course.getCreateDate() == null)) {
			if (serviceContext == null) {
				course.setCreateDate(now);
			}
			else {
				course.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!courseModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				course.setModifiedDate(now);
			}
			else {
				course.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (course.isNew()) {
				session.save(course);

				course.setNew(false);
			}
			else {
				course = (Course)session.merge(course);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((courseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseModelImpl.getOriginalDepartment()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT,
					args);

				args = new Object[] { courseModelImpl.getDepartment() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT,
					args);
			}
		}

		entityCache.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey(), course, false);

		clearUniqueFindersCache(courseModelImpl);
		cacheUniqueFindersCache(courseModelImpl, isNew);

		course.resetOriginalValues();

		return course;
	}

	protected Course toUnwrappedModel(Course course) {
		if (course instanceof CourseImpl) {
			return course;
		}

		CourseImpl courseImpl = new CourseImpl();

		courseImpl.setNew(course.isNew());
		courseImpl.setPrimaryKey(course.getPrimaryKey());

		courseImpl.setCourseId(course.getCourseId());
		courseImpl.setGroupId(course.getGroupId());
		courseImpl.setCompanyId(course.getCompanyId());
		courseImpl.setUserId(course.getUserId());
		courseImpl.setUserName(course.getUserName());
		courseImpl.setCreateDate(course.getCreateDate());
		courseImpl.setModifiedDate(course.getModifiedDate());
		courseImpl.setCourseCode(course.getCourseCode());
		courseImpl.setName(course.getName());
		courseImpl.setDescription(course.getDescription());
		courseImpl.setLevel(course.getLevel());
		courseImpl.setDepartment(course.getDepartment());
		courseImpl.setPrereqs(course.getPrereqs());

		return courseImpl;
	}

	/**
	 * Returns the course with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	@Override
	public Course findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseException {
		Course course = fetchByPrimaryKey(primaryKey);

		if (course == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return course;
	}

	/**
	 * Returns the course with the primary key or throws a {@link NoSuchCourseException} if it could not be found.
	 *
	 * @param courseId the primary key of the course
	 * @return the course
	 * @throws NoSuchCourseException if a course with the primary key could not be found
	 */
	@Override
	public Course findByPrimaryKey(long courseId) throws NoSuchCourseException {
		return findByPrimaryKey((Serializable)courseId);
	}

	/**
	 * Returns the course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course
	 * @return the course, or <code>null</code> if a course with the primary key could not be found
	 */
	@Override
	public Course fetchByPrimaryKey(Serializable primaryKey) {
		Course course = (Course)entityCache.getResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
				CourseImpl.class, primaryKey);

		if (course == _nullCourse) {
			return null;
		}

		if (course == null) {
			Session session = null;

			try {
				session = openSession();

				course = (Course)session.get(CourseImpl.class, primaryKey);

				if (course != null) {
					cacheResult(course);
				}
				else {
					entityCache.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
						CourseImpl.class, primaryKey, _nullCourse);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
					CourseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return course;
	}

	/**
	 * Returns the course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseId the primary key of the course
	 * @return the course, or <code>null</code> if a course with the primary key could not be found
	 */
	@Override
	public Course fetchByPrimaryKey(long courseId) {
		return fetchByPrimaryKey((Serializable)courseId);
	}

	@Override
	public Map<Serializable, Course> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Course> map = new HashMap<Serializable, Course>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Course course = fetchByPrimaryKey(primaryKey);

			if (course != null) {
				map.put(primaryKey, course);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Course course = (Course)entityCache.getResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
					CourseImpl.class, primaryKey);

			if (course == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, course);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_COURSE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Course course : (List<Course>)q.list()) {
				map.put(course.getPrimaryKeyObj(), course);

				cacheResult(course);

				uncachedPrimaryKeys.remove(course.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
					CourseImpl.class, primaryKey, _nullCourse);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the courses.
	 *
	 * @return the courses
	 */
	@Override
	public List<Course> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Course> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Course> findAll(int start, int end,
		OrderByComparator<Course> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Course> findAll(int start, int end,
		OrderByComparator<Course> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Course> list = null;

		if (retrieveFromCache) {
			list = (List<Course>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COURSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSE;

				if (pagination) {
					sql = sql.concat(CourseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Course>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Course>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the courses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Course course : findAll()) {
			remove(course);
		}
	}

	/**
	 * Returns the number of courses.
	 *
	 * @return the number of courses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COURSE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CourseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the course persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CourseImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_COURSE = "SELECT course FROM Course course";
	private static final String _SQL_SELECT_COURSE_WHERE_PKS_IN = "SELECT course FROM Course course WHERE courseId IN (";
	private static final String _SQL_SELECT_COURSE_WHERE = "SELECT course FROM Course course WHERE ";
	private static final String _SQL_COUNT_COURSE = "SELECT COUNT(course) FROM Course course";
	private static final String _SQL_COUNT_COURSE_WHERE = "SELECT COUNT(course) FROM Course course WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "course.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Course exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Course exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CoursePersistenceImpl.class);
	private static final Course _nullCourse = new CourseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Course> toCacheModel() {
				return _nullCourseCacheModel;
			}
		};

	private static final CacheModel<Course> _nullCourseCacheModel = new CacheModel<Course>() {
			@Override
			public Course toEntityModel() {
				return _nullCourse;
			}
		};
}