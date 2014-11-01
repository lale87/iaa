<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%-- 
  - Author: Arne Roever
  - Description: Form for saving new lectures.
--%>

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
	<%-- The table of existing meetings--%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>			
			<th></th>			
			<th><s:text name="lbl.meetingName"/></th>
			<th><s:text name="lbl.lecturer"/></th>			
		</tr>
		<s:iterator value="meetingList">
			<tr>				
				<td><s:radio name="meetingId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="lecturer.displayName"/></td>
			</tr>
		</s:iterator>
	</table>	
	<%-- Buttons for changing or editing meetings --%>
		<s:submit key="btn.editMeeting"/>
		<s:submit key="btn.deleteMeeting"/>	
		<s:submit key="btn.return" action="ShowMainMenu"/>	
</s:form>


