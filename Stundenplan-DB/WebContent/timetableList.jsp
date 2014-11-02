<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%-- 
  - Author: Arne Roever
  - Description: Shows selected timetable as list
--%>

<h3>
	<s:text name="hdl.timetableList"></s:text>
</h3>
<s:form>
	<s:property value="selectedId"/>
	<s:property value="selectedType"/>	
	
	<%-- The timetable for selected id and type--%>
	<table style="border-collapse: collapse; border: #CCC;" border="1">
		<tr>			
			<th></th>			
			<th><s:text name="lbl.meetingName"/></th>
			<th><s:text name="lbl.lecturer"/></th>
			<th><s:text name="lbl.rooms"/></th>			
		</tr>
		<s:iterator value="meetingList">
			<tr>				
				<td><s:radio name="meetingId" list="#{id:''}" theme="simple"/></td>
				<td><s:property value="name"/></td>
				<td><s:property value="lecturer.displayName"/></td>
				<td>
					<s:iterator value="rooms">
						<s:property value="displayName"/>						
					</s:iterator>
				</td>
			</tr>
		</s:iterator>
	</table>
	<s:submit key="btn.return" action="ShowTimetableMenu" />
</s:form>
