<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<h3><s:text name="hdl.newLecture"></s:text></h3>
<s:form>
	<%-- Form fields for the lecture's attributes --%>
	<s:hidden name="lecture.id"/>
  	<s:select name="lecture.lecturer" key="lbl.lecturer" list="allLecturers" listKey="id" listValue="firstName +' ' + lastName + ', ' + abbreviation" requiredLabel="true"/>	
	<s:select name="lecture.rooms" key="lbl.rooms" list="allRooms" listKey="id" listValue="roomNumber + ' ' + building + ', ' + roomType" multiple="true" size="5" requiredLabel="true"/> 
 	<s:select name="lecture.studentGroup" key="lbl.studentGroup" list="allStudentGroups" listKey="id" listValue="fieldOfStudy + ', ' + cohort.yearOfAdmission + groupIdentifier" requiredLabel="true"/>
	<s:textfield name="lecture.name" key="lbl.meetingName" size="40" maxlength="100" requiredLabel="true"/>
	<s:textfield name="numberOfAppointments" key="lbl.numberOfAppointments" size="3" maxlength="3" requiredLabel="true"/>
	
	<sj:head  />	
	<sj:datepicker name="startDate" key="lbl.startDate" timepicker="true" timepickerFormat="HH:mm"
	displayFormat="dd.mm.yy" changeMonth="true" changeYear="true" requiredLabel="true"/>
	<sj:datepicker name="endDate" key="lbl.endDate" timepicker="true" timepickerFormat="HH:mm" 
	displayFormat="dd.mm.yy" changeMonth="true" changeYear="true" requiredLabel="true"/>
		
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveLecture"/>
	<s:submit key="btn.cancel" action="CancelNewMeeting"/>
</s:form>
