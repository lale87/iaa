<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<h3><s:text name="hdl.newMeeting"></s:text></h3>
<s:form>
	<%-- Buttons for creating new meetings --%>	
	<s:submit key="btn.newLecture" action="ShowLectureForm"/>
	<s:submit key="btn.newExam" action="ShowExamForm"/>
	<s:submit key="btn.newElective" action="ShowElectiveForm"/>
	<s:submit key="btn.newSeminar" action="ShowSeminarForm"/>
</s:form>	

<h3><s:text name="hdl.editMeeting"></s:text></h3>
<s:form>
	<%-- Buttons for changing or editing meetings --%>
	<s:submit key="btn.editMeeting"/>
	<s:submit key="btn.deleteMeeting"/>	
	<s:submit key="btn.cancel" action="CancelMeetingMenu"/>
</s:form>


