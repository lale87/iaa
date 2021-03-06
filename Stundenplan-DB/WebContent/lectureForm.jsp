<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%-- 
  - Author: Arne Roever
  - Description: Form for saving new lectures.
--%>

<h3>
	<s:text name="hdl.newLecture"></s:text>	
</h3>
<s:actionerror/>
<s:form cssClass="strutsTable">
	<%-- Form fields for the lecture's attributes --%>
	<s:hidden name="lecture.id" />
	<s:select name="lecturerId" key="lbl.lecturer" list="allLecturers"
		listKey="id" listValue="displayName" value="lecturerId"
		requiredLabel="true" />
	<s:select name="studentGroupId" key="lbl.studentGroup"
		list="allStudentGroups" listKey="id" value="studentGroupId"
		listValue="displayName" requiredLabel="true" />
	<s:textfield name="meetingName" key="lbl.meetingName"
		value="%{meetingName}" size="40" maxlength="100" requiredLabel="true" />
	<s:textfield name="numberOfAppointments" key="lbl.numberOfAppointments"
		value="%{numberOfAppointments}" size="3" maxlength="3"
		requiredLabel="true" />

	<%-- jquery datepicker for choosing start and end date of lecture --%>
	<sj:head />
	<sj:datepicker name="startDate" key="lbl.startDate"
		value="%{startDate}" timepicker="true"
		timepickerFormat="HH:mm" displayFormat="dd.mm.yy" changeMonth="true"
		changeYear="true" requiredLabel="true" showOn="button" />
	<sj:datepicker name="endDate" key="lbl.endDate"
		value="%{endDate}" timepicker="true"
		timepickerFormat="HH:mm" displayFormat="dd.mm.yy" changeMonth="true"
		changeYear="true" requiredLabel="true" showOn="button" />
	
	<%-- Dropdown select for available rooms, can be updated using button  --%>
	<s:select name="roomIds" key="lbl.rooms" list="allRooms" listKey="id"
		listValue="displayName" value="roomIds" multiple="true"
		size="5" requiredLabel="true" />
		
	<s:if test="!isShowOnlyFreeRooms()">
		<s:submit key="btn.showAvailableRooms" action="ShowAvailableRoomsForLecture"/>	
	</s:if>
	<s:else>
		<s:submit key="btn.CancelShowAvailableRooms" action="CancelShowAvailableRoomsForLecture"/>
	</s:else>
	
	
	<%-- The buttons - normal and for collision mode--%>
	<s:if test="!isCollided()">		
		<s:submit key="btn.save" action="SaveLecture" />
		<s:submit key="btn.return" action="CancelNewMeeting" />
	</s:if>
	<s:else>
		<s:submit key="btn.saveCollision" action="SaveLectureWithCollision" />
		<s:submit key="btn.cancel" action="CancelLectureCollision" />
	</s:else>
	
	
</s:form>
