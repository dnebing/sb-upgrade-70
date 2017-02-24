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

package com.liferay.school.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Course}.
 * </p>
 *
 * @author dnebinger
 * @see Course
 * @generated
 */
@ProviderType
public class CourseWrapper implements Course, ModelWrapper<Course> {
	public CourseWrapper(Course course) {
		_course = course;
	}

	@Override
	public Class<?> getModelClass() {
		return Course.class;
	}

	@Override
	public String getModelClassName() {
		return Course.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("courseId", getCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("courseCode", getCourseCode());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("level", getLevel());
		attributes.put("department", getDepartment());
		attributes.put("prereqs", getPrereqs());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String courseCode = (String)attributes.get("courseCode");

		if (courseCode != null) {
			setCourseCode(courseCode);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String prereqs = (String)attributes.get("prereqs");

		if (prereqs != null) {
			setPrereqs(prereqs);
		}
	}

	@Override
	public Course toEscapedModel() {
		return new CourseWrapper(_course.toEscapedModel());
	}

	@Override
	public Course toUnescapedModel() {
		return new CourseWrapper(_course.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _course.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _course.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _course.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _course.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Course> toCacheModel() {
		return _course.toCacheModel();
	}

	@Override
	public int compareTo(Course course) {
		return _course.compareTo(course);
	}

	/**
	* Returns the level of this course.
	*
	* @return the level of this course
	*/
	@Override
	public int getLevel() {
		return _course.getLevel();
	}

	@Override
	public int hashCode() {
		return _course.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _course.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CourseWrapper((Course)_course.clone());
	}

	/**
	* Returns the course code of this course.
	*
	* @return the course code of this course
	*/
	@Override
	public java.lang.String getCourseCode() {
		return _course.getCourseCode();
	}

	/**
	* Returns the department of this course.
	*
	* @return the department of this course
	*/
	@Override
	public java.lang.String getDepartment() {
		return _course.getDepartment();
	}

	/**
	* Returns the description of this course.
	*
	* @return the description of this course
	*/
	@Override
	public java.lang.String getDescription() {
		return _course.getDescription();
	}

	/**
	* Returns the name of this course.
	*
	* @return the name of this course
	*/
	@Override
	public java.lang.String getName() {
		return _course.getName();
	}

	/**
	* Returns the prereqs of this course.
	*
	* @return the prereqs of this course
	*/
	@Override
	public java.lang.String getPrereqs() {
		return _course.getPrereqs();
	}

	/**
	* Returns the user name of this course.
	*
	* @return the user name of this course
	*/
	@Override
	public java.lang.String getUserName() {
		return _course.getUserName();
	}

	/**
	* Returns the user uuid of this course.
	*
	* @return the user uuid of this course
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _course.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _course.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _course.toXmlString();
	}

	/**
	* Returns the create date of this course.
	*
	* @return the create date of this course
	*/
	@Override
	public Date getCreateDate() {
		return _course.getCreateDate();
	}

	/**
	* Returns the modified date of this course.
	*
	* @return the modified date of this course
	*/
	@Override
	public Date getModifiedDate() {
		return _course.getModifiedDate();
	}

	/**
	* Returns the company ID of this course.
	*
	* @return the company ID of this course
	*/
	@Override
	public long getCompanyId() {
		return _course.getCompanyId();
	}

	/**
	* Returns the course ID of this course.
	*
	* @return the course ID of this course
	*/
	@Override
	public long getCourseId() {
		return _course.getCourseId();
	}

	/**
	* Returns the group ID of this course.
	*
	* @return the group ID of this course
	*/
	@Override
	public long getGroupId() {
		return _course.getGroupId();
	}

	/**
	* Returns the primary key of this course.
	*
	* @return the primary key of this course
	*/
	@Override
	public long getPrimaryKey() {
		return _course.getPrimaryKey();
	}

	/**
	* Returns the user ID of this course.
	*
	* @return the user ID of this course
	*/
	@Override
	public long getUserId() {
		return _course.getUserId();
	}

	@Override
	public void persist() {
		_course.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_course.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this course.
	*
	* @param companyId the company ID of this course
	*/
	@Override
	public void setCompanyId(long companyId) {
		_course.setCompanyId(companyId);
	}

	/**
	* Sets the course code of this course.
	*
	* @param courseCode the course code of this course
	*/
	@Override
	public void setCourseCode(java.lang.String courseCode) {
		_course.setCourseCode(courseCode);
	}

	/**
	* Sets the course ID of this course.
	*
	* @param courseId the course ID of this course
	*/
	@Override
	public void setCourseId(long courseId) {
		_course.setCourseId(courseId);
	}

	/**
	* Sets the create date of this course.
	*
	* @param createDate the create date of this course
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_course.setCreateDate(createDate);
	}

	/**
	* Sets the department of this course.
	*
	* @param department the department of this course
	*/
	@Override
	public void setDepartment(java.lang.String department) {
		_course.setDepartment(department);
	}

	/**
	* Sets the description of this course.
	*
	* @param description the description of this course
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_course.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_course.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_course.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_course.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this course.
	*
	* @param groupId the group ID of this course
	*/
	@Override
	public void setGroupId(long groupId) {
		_course.setGroupId(groupId);
	}

	/**
	* Sets the level of this course.
	*
	* @param level the level of this course
	*/
	@Override
	public void setLevel(int level) {
		_course.setLevel(level);
	}

	/**
	* Sets the modified date of this course.
	*
	* @param modifiedDate the modified date of this course
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_course.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this course.
	*
	* @param name the name of this course
	*/
	@Override
	public void setName(java.lang.String name) {
		_course.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_course.setNew(n);
	}

	/**
	* Sets the prereqs of this course.
	*
	* @param prereqs the prereqs of this course
	*/
	@Override
	public void setPrereqs(java.lang.String prereqs) {
		_course.setPrereqs(prereqs);
	}

	/**
	* Sets the primary key of this course.
	*
	* @param primaryKey the primary key of this course
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_course.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_course.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this course.
	*
	* @param userId the user ID of this course
	*/
	@Override
	public void setUserId(long userId) {
		_course.setUserId(userId);
	}

	/**
	* Sets the user name of this course.
	*
	* @param userName the user name of this course
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_course.setUserName(userName);
	}

	/**
	* Sets the user uuid of this course.
	*
	* @param userUuid the user uuid of this course
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_course.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseWrapper)) {
			return false;
		}

		CourseWrapper courseWrapper = (CourseWrapper)obj;

		if (Objects.equals(_course, courseWrapper._course)) {
			return true;
		}

		return false;
	}

	@Override
	public Course getWrappedModel() {
		return _course;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _course.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _course.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_course.resetOriginalValues();
	}

	private final Course _course;
}