<%
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
%>

<%@ page import="java.util.*" %>
<%@ page import="com.liferay.school.model.*" %>
<%@ page import="com.liferay.school.service.*" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	// get the list of courses using the school service.
	
	List<Course> courses = CourseLocalServiceUtil.listAllCourses();

	if (courses == null) {
		courses = new ArrayList<Course>();
	}
	
	int courseCount = courses.size();
%>
<h3>Courses</h3>
<p>Count: <%= courseCount %></p>

<table class="table table-striped">
	<thead><tr>
		<th>Course</th>
		<th>Name</th>
	</tr></thead>
	<tbody>
	<%
		for (Course course : courses) {
	%>
	<tr><td ><%= course.getCourseCode() %></td>
		<td ><%= course.getName() %></td></tr>
	<%
		}
	%>
	</tbody>
</table>
