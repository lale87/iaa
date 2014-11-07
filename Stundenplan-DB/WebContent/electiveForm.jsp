<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%-- 
  - Author: Arne Roever
  - Description: Form for saving new electives.
 --%>

<h3>
	<s:text name="hdl.newElective"></s:text>
</h3>
<s:actionerror key="msg.error.collision"/>
<s:form cssClass="strutsTable">
	<s:hidden name="elective.id" />
	<s:select name="lecturerId" key="lbl.lecturer" list="allLecturers"
		listKey="id" listValue="displayName" value="lecturerId"
		requiredLabel="true" />	
	<s:textfield name="meetingName" key="lbl.meetingName"
		value="%{meetingName}" size="40" maxlength="100"
		requiredLabel="true" />		
	<s:select name="cohortId" key="lbl.cohort" list="allCohorts"
		listKey="id" listValue="yearOfAdmission" value="cohortId"
		requiredLabel="true" />	
	<s:textfield name="numberOfAppointments" key="lbl.numberOfAppointments"
		value="%{numberOfAppointments}" size="3" maxlength="3"
		requiredLabel="true" />

	<%-- Jquery datepicker for choosing start- and end date of elective --%>
	<sj:head />
	<sj:datepicker name="startDate" key="lbl.startDate"
		value="%{startDate}" timepicker="true"
		timepickerFormat="HH:mm" displayFormat="dd.mm.yy" changeMonth="true"
		changeYear="true" requiredLabel="true" showOn="button"/>
	<sj:datepicker name="endDate" key="lbl.endDate"
		value="%{endDate}" timepicker="true"
		timepickerFormat="HH:mm" displayFormat="dd.mm.yy" changeMonth="true"
		changeYear="true" requiredLabel="true" showOn="button"/>
			
	<s:select name="roomIds" key="lbl.rooms" list="allRooms" listKey="id"
		listValue="displayName" value="roomIds" multiple="true"
		size="5" requiredLabel="true" />
	<s:submit key="btn.showAvailableRooms"/>

	<%-- The buttons - normal and for collision mode--%>
	<s:if test="!isCollided()">
		<s:submit key="btn.save" action="SaveElective" />
		<s:submit key="btn.return" action="CancelNewMeeting" />
	</s:if>
	<s:else>
		<s:submit key="btn.saveCollision" action="SaveElectiveWithCollision" />
		<s:submit key="btn.cancel" action="CancelElectiveCollision" />		
	</s:else>
</s:form>
