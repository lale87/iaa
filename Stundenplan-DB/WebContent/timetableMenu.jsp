<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%-- 
  - Author: Arne Roever
  - Description: Menu for choosing which timetable to show.
--%>

<h3>
	<s:text name="hdl.timetableMenu"></s:text>
</h3>
<s:form cssClass="strutsTable">
	<s:doubleselect name="selectedType" list="{'Dozent','Zenturie','Raum'}"
		doubleName="selectedId"
		doubleList="top == 'Dozent' ? lecturerList : (top == 'Zenturie' ?  studentGroupList : roomList )"
		doubleListKey="id" doubleListValue="displayName" />
	<s:textfield name="year" key="lbl.year" size="4" maxlength="4"
		value="%{year}" requiredLabel="true" />	
	<s:textfield name="calendarWeek" key="lbl.calenderWeek" size="2" maxlength="2"
		value="%{calendarWeek}" requiredLabel="true" />


	<s:submit key="btn.showTimetable" action="ShowTimetableList" />
	<s:submit key="btn.return" action="ShowMainMenu" />
</s:form>
