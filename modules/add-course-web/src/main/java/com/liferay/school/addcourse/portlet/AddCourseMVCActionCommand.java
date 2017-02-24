package com.liferay.school.addcourse.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.school.service.CourseLocalServiceUtil;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=com_liferay_school_addcourse_AddCoursePortlet",
			"mvc.command.name=/add_course"
		},
		service = MVCActionCommand.class
	)
public class AddCourseMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			if (cmd.equals(Constants.ADD)) {
				String courseCode = ParamUtil.getString(actionRequest, "courseCode");
				String name = ParamUtil.getString(actionRequest, "name");
				String description = ParamUtil.getString(actionRequest, "description");
				String department = ParamUtil.getString(actionRequest, "department");
				int level = ParamUtil.getInteger(actionRequest, "level");
				
				CourseLocalServiceUtil.addCourse(courseCode, name, description, level, department, null);
			}

			if (Validator.isNotNull(cmd)) {
				sendRedirect(actionRequest, actionResponse);
			}
	}

}
