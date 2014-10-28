<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:form>
	<%-- Form fields for the seminar's attributes --%>
	<s:hidden name="seminar.id"/>
  	<s:select name="seminar.lecturer" key="lbl.lecturer" list="allLecturers" listKey="id" 
  		listValue="firstName +' ' + lastName + ', ' + abbreviation" requiredLabel="true"/>	
	<s:select name="seminar.rooms" key="lbl.rooms" list="allRooms" listKey="id" 
		listValue="roomNumber + ' ' + building + ', ' + roomType" multiple="true" size="5" requiredLabel="true"/>  	
	<s:textfield name="seminar.name" key="lbl.meetingName" size="40" maxlength="100" requiredLabel="true"/>
	<s:textfield name="numberOfAppointments" key="lbl.numberOfAppointments" size="3" maxlength="3" requiredLabel="true"/>
	
	<sj:head  />	
	<sj:datepicker name="startDate" key="lbl.startDate" timepicker="true" timepickerFormat="HH:mm"
	displayFormat="dd.mm.yy" changeMonth="true" changeYear="true" requiredLabel="true"/>
	<sj:datepicker name="endDate" key="lbl.endDate" timepicker="true" timepickerFormat="HH:mm" 
	displayFormat="dd.mm.yy" changeMonth="true" changeYear="true" requiredLabel="true"/>
		
	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveSeminar"/>
	<s:submit key="btn.cancel" action="CancelNewMeeting"/>
</s:form>
