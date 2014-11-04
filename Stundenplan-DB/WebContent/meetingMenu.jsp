<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%-- 
  - Author: Arne Roever
  - Description: Shows list of existing meetings for every meeting type and
  - offers buttons for creating, deleting and changing meetings.
--%>

<%-- Button for returning to main menu --%>
<s:form>
<s:submit key="btn.return" action="ShowMainMenu" theme="simple"/>	
</s:form>

<h3><s:text name="hdl.lecture"></s:text></h3>
<s:form>	
	<%-- The table of existing lectures--%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>			
			<th></th>			
			<th><s:text name="lbl.meetingName"/></th>
			<th><s:text name="lbl.lecturer"/></th>
			<th><s:text name="lbl.studentGroup"/></th>	
			<th><s:text name="lbl.rooms"/></th>	
			<th><s:text name="lbl.startDate"/></th>		
			<th><s:text name="lbl.endDate"/></th>				
			<th><s:text name="lbl.numberOfAppointments"/></th>		
		</tr>
		<s:iterator value="lectureList">
			<tr>				
				<td><s:radio name="lectureId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="lecturer.displayName"/></td>
				<td><s:property value="studentGroup.displayName"/></td>
								<td>
					<s:iterator value="rooms">
						<s:property value="displayName"/>						
					</s:iterator>
				</td>
				<td><s:property value="appointments[0].start"/></td>
				<td><s:property value="appointments[0].end"/></td>
				<td><s:property value="numberOfAppointments"/></td>
			</tr>
		</s:iterator>
	</table>	
	<%-- Buttons for creating or editing lectures --%>
	<s:submit key="btn.newLecture" action="ShowLectureForm" theme="simple"/>
	<s:submit key="btn.editLecture" theme="simple"/>
	<s:submit key="btn.deleteLecture" theme="simple"/>			
</s:form>

<h3><s:text name="hdl.exam"></s:text></h3>
<s:form>	
	<%-- The table of existing exams--%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>			
			<th></th>				
			<th><s:text name="lbl.meetingName"/></th>
			<th><s:text name="lbl.lecturer"/></th>
			<th><s:text name="lbl.studentGroup"/></th>	
			<th><s:text name="lbl.rooms"/></th>	
			<th><s:text name="lbl.startDate"/></th>		
			<th><s:text name="lbl.endDate"/></th>				
			<th><s:text name="lbl.numberOfAppointments"/></th>			
		</tr>
		<s:iterator value="examList">
			<tr>				
				<td><s:radio name="examId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="lecturer.displayName"/></td>
				<td>
					<s:iterator value="studentGroups">
						<s:property value="displayName"/>						
					</s:iterator>
				</td>
				<td>
					<s:iterator value="rooms">
						<s:property value="displayName"/>						
					</s:iterator>
				</td>
				<td><s:property value="appointments[0].start"/></td>
				<td><s:property value="appointments[0].end"/></td>
				<td><s:property value="numberOfAppointments"/></td>
			</tr>
		</s:iterator>
	</table>	
	<%-- Buttons for creating or editing lectures --%>
	<s:submit key="btn.newExam" action="ShowExamForm" theme="simple"/>
	<s:submit key="btn.editExam" theme="simple"/>
	<s:submit key="btn.deleteExam" theme="simple"/>			
</s:form>

<h3><s:text name="hdl.elective"></s:text></h3>
<s:form>	
	<%-- The table of existing electives--%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>			
			<th></th>			
			<th><s:text name="lbl.meetingName"/></th>
			<th><s:text name="lbl.lecturer"/></th>
			<th><s:text name="lbl.cohort"/></th>	
			<th><s:text name="lbl.rooms"/></th>	
			<th><s:text name="lbl.startDate"/></th>		
			<th><s:text name="lbl.endDate"/></th>				
			<th><s:text name="lbl.numberOfAppointments"/></th>			
		</tr>
		<s:iterator value="electiveList">
			<tr>				
				<td><s:radio name="electiveId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="lecturer.displayName"/></td>
				<td><s:property value="cohort.yearOfAdmission"/></td>
				<td>
					<s:iterator value="rooms">
						<s:property value="displayName"/>						
					</s:iterator>
				</td>
				<td><s:property value="appointments[0].start"/></td>
				<td><s:property value="appointments[0].end"/></td>
				<td><s:property value="numberOfAppointments"/></td>
			</tr>
		</s:iterator>
	</table>	
	<%-- Buttons for creating or editing electives --%>
	<s:submit key="btn.newElective" action="ShowElectiveForm" theme="simple"/>
	<s:submit key="btn.editElective" theme="simple"/>
	<s:submit key="btn.deleteElective" theme="simple"/>			
</s:form>

<h3><s:text name="hdl.seminar"></s:text></h3>
<s:form>	
	<%-- The table of existing seminars--%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>			
			<th></th>			
			<th><s:text name="lbl.meetingName"/></th>
			<th><s:text name="lbl.lecturer"/></th>
			<th><s:text name="lbl.rooms"/></th>	
			<th><s:text name="lbl.startDate"/></th>		
			<th><s:text name="lbl.endDate"/></th>				
			<th><s:text name="lbl.numberOfAppointments"/></th>				
		</tr>
		<s:iterator value="seminarList">
			<tr>				
				<td><s:radio name="seminarId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="lecturer.displayName"/></td>
				<td>
					<s:iterator value="rooms">
						<s:property value="displayName"/>						
					</s:iterator>
				</td>
				<td><s:property value="appointments[0].start"/></td>
				<td><s:property value="appointments[0].end"/></td>
				<td><s:property value="numberOfAppointments"/></td>
			</tr>
		</s:iterator>
	</table>	
	<%-- Buttons for creating or editing seminar --%>
	<s:submit key="btn.newSeminar" action="ShowSeminarForm" theme="simple"/>
	<s:submit key="btn.editSeminar" theme="simple"/>
	<s:submit key="btn.deleteSeminar" theme="simple"/>			
</s:form>

<%-- Button for returning to main menu --%>
<s:form>
<s:submit key="btn.return" action="ShowMainMenu" theme="simple"/>	
</s:form>



