<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%-- 
  - Author: Arne Roever
  - Description: Shows selected timetable as list
--%>

<h3>
	<s:text name="hdl.timetableList" />
</h3>
<s:form>
	<%-- Displays result timetable if appointments have been found --%>
	<s:if test="!appointmentList.isEmpty()">

		<%-- The timetable for selected id and type--%>
		<table class="strutsTable">
			<tr>
				<th></th>
				<th><s:text name="lbl.startDate" /></th>
				<th><s:text name="lbl.endDate" /></th>
				<th><s:text name="lbl.meetingName" /></th>
				<th><s:text name="lbl.lecturer" /></th>
				<th><s:text name="lbl.rooms" /></th>
				<th><s:text name="lbl.studentGroup" /></th>
				<th><s:text name="lbl.cohort" /></th>
			</tr>
			<s:iterator value="appointmentList">
				<tr>
					<td><s:property value="meeting.meetingType" /></td>
					<td><s:property value="getText('format.date', {start})" /></td>
					<td><s:property value="getText('format.date', {end})" /></td>
					<td><s:property value="meeting.name" /></td>
					<td><s:property value="meeting.lecturer.displayName" /></td>
					<td><s:iterator value="meeting.rooms">
							<s:property value="displayName" />
						</s:iterator></td>
					<td><s:property value="meeting.studentGroup.displayName" /> <s:iterator
							value="meeting.studentGroups">
							<s:property value="displayName" />
						</s:iterator></td>
					<td><s:property value="meeting.cohort.yearOfAdmission" /></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
	<s:else>
		<s:text name="msg.error.noMeetingsFound"></s:text>
		<br />
	</s:else>
	<br />
	<s:submit key="btn.return" action="ShowTimetableMenu" theme="simple" />
</s:form>
