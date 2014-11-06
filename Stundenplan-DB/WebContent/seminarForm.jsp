<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%-- 
  - Author: Arne Roever
  - Description: Form for saving new seminars.
 --%>

<h3>
	<s:text name="hdl.newSeminar"></s:text>
</h3>
<s:actionerror key="msg.error.collision"/>
<s:form>
	<%-- Form fields for the seminar's attributes --%>
	<s:hidden name="seminar.id" />
	<s:select name="lecturerId" key="lbl.lecturer" list="allLecturers"
		listKey="id" listValue="displayName" value="lecturerId"
		requiredLabel="true" />
	<s:select name="roomIds" key="lbl.rooms" list="allRooms" listKey="id"
		listValue="displayName" value="roomIds" multiple="true"
		size="5" requiredLabel="true" />
	<s:textfield name="meetingName" key="lbl.meetingName"
		value="%{meetingName}" size="40" maxlength="100" requiredLabel="true" />
	<s:textfield name="numberOfAppointments" key="lbl.numberOfAppointments"
		value="%{numberOfAppointments}" size="3" maxlength="3"
		requiredLabel="true" />

	<%-- Jquery datepicker for choosing start- and enddate of seminar --%>
	<sj:head />
	<sj:datepicker name="startDate" key="lbl.startDate"
		value="%{startDate}" timepicker="true"
		timepickerFormat="HH:mm" displayFormat="dd.mm.yy" changeMonth="true"
		changeYear="true" requiredLabel="true" showOn="button"/>
	<sj:datepicker name="endDate" key="lbl.endDate"
		value="%{endDate}" timepicker="true"
		timepickerFormat="HH:mm" displayFormat="dd.mm.yy" changeMonth="true"
		changeYear="true" requiredLabel="true" showOn="button"/>

	<%-- The buttons --%>
	<s:if test="collided">
		<s:submit key="btn.saveCollision" action="SaveSeminarWithCollision" />
		<s:submit key="btn.cancel" action="CancelSeminarCollision" />
	</s:if>
	<s:else>
		<s:submit key="btn.save" action="SaveSeminar" />
		<s:submit key="btn.cancel" action="CancelNewMeeting" />
	</s:else>
</s:form>
