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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Course service. Represents a row in the &quot;SCH_Course&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnebinger
 * @see CourseModel
 * @see com.liferay.school.model.impl.CourseImpl
 * @see com.liferay.school.model.impl.CourseModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.school.model.impl.CourseImpl")
@ProviderType
public interface Course extends CourseModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.school.model.impl.CourseImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Course, Long> COURSE_ID_ACCESSOR = new Accessor<Course, Long>() {
			@Override
			public Long get(Course course) {
				return course.getCourseId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Course> getTypeClass() {
				return Course.class;
			}
		};
}