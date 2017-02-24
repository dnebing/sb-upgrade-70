<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<portlet:renderURL var="viewURL" >
	<portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="/add_course" var="addCourseURL">
	<portlet:param name="mvcActionCommand" value="/add_course" />
</portlet:actionURL>

<h2>Add Course</h2>

<aui:form action="<%= addCourseURL %>" method="post" name="fm" >
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input label="Course Code" name="courseCode" />
			<aui:input label="Course Name" name="name" />
			<aui:input label="Description" name="description" />
			<aui:input label="Level" name="level" />
			<aui:input label="Department" name="department" />
			
			<aui:button-row>
				<aui:button type="submit" value="addCourse" />
				<aui:button href="<%= viewURL %>" type="cancel" value="cancel" />
			</aui:button-row>
		</aui:fieldset>
	</aui:fieldset-group>
</aui:form>


