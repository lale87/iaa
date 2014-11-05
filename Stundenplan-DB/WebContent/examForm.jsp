<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%-- 
  - Author: Arne Roever
  - Description: Form for saving new exams.
 --%>

<h3>
	<s:text name="hdl.newExam"></s:text>
</h3>
<s:form>
	<%-- Form fields for the exam's attributes --%>
	<s:hidden name="exam.id" />
	<s:select name="lecturerId" key="lbl.lecturer" list="allLecturers"
		listKey="id" listValue="displayName" value="lecturerId"
		requiredLabel="true" />
	<s:select name="roomIds" key="lbl.rooms" list="allRooms" listKey="id"
		listValue="displayName" value="roomIds" multiple="true"
		size="5" requiredLabel="true" />
	<s:select name="studentGroupIds" key="lbl.studentGroup"
		list="allStudentGroups" listKey="id" listValue="displayName"
		value="studentGroupIds" multiple="true"
		requiredLabel="true" />
	<s:textfield name="meetingName" key="lbl.meetingName"
		value="%{meetingName}" size="40" maxlength="100" requiredLabel="true" />
	<s:textfield name="numberOfAppointments" key="lbl.numberOfAppointments"
		value="%{numberOfAppointments}" size="3" maxlength="3"
		requiredLabel="true" />

	<%-- jquery datepicker for choosing start and end date of exam --%>
	<sj:head />
	<sj:datepicker name="startDate" key="lbl.startDate"
		value="%{startDate}" timepicker="true"
		timepickerFormat="HH:mm" displayFormat="dd.mm.yy" changeMonth="true"
		changeYear="true" requiredLabel="true" />
	<sj:datepicker name="endDate" key="lbl.endDate"
		value="%{endDate}" timepicker="true"
		timepickerFormat="HH:mm" displayFormat="dd.mm.yy" changeMonth="true"
		changeYear="true" requiredLabel="true" />

	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveExam" />
	<s:submit key="btn.cancel" action="CancelNewMeeting" />
</s:form>
