<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%-- 
  - Author: Arne Roever
  - Description: Form for saving new student groups.
 --%>

<h3><s:text name="hdl.newStudentGroup"></s:text></h3>
<s:actionerror/>
<s:form cssClass="strutsTable">
	<%-- Form fields for the student group attributes --%>
	<s:select name="studentGroup.fieldOfStudy" key="lbl.fieldOfStudy" list="allFieldsOfStudy" listValue="longTitle" requiredLabel="true"/>
	<s:textfield name="studentGroup.cohort.yearOfAdmission" key="lbl.yearOfAdmission" size="4" maxlength="4" requiredLabel="true"/>
	<s:textfield name="studentGroup.groupIdentifier" key="lbl.groupIdentifier" size="1" maxlength="1" requiredLabel="true"/>
	<s:textfield name="studentGroup.studentCount" key="lbl.studentCount" size="4" maxlength="4" requiredLabel="true"/>
	<s:textfield name="studentGroup.minBreak" key="lbl.minBreak" size="3" maxlength="3" requiredLabel="true"/>	

	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveStudentGroup"/>
	<s:submit key="btn.cancel" action="CancelNewStudentGroup"/>
</s:form>


<%-- The table of existing studentGroups --%>
<h3>
	<s:text name="hdl.existingStudentGroups"></s:text>
</h3>
<table class="strutsTable">
	<tr>		
		<th><s:text name="lbl.fieldOfStudy" /></th>
		<th><s:text name="lbl.yearOfAdmission" /></th>
		<th><s:text name="lbl.groupIdentifier" /></th>
		<th><s:text name="lbl.studentCount" /></th>
		<th><s:text name="lbl.minBreak" /></th>
	</tr>
	<s:iterator value="allStudentGroups">
		<tr>
			<td><s:property value="fieldOfStudy.longTitle" /></td>
			<td><s:property value="cohort.yearOfAdmission" /></td>
			<td><s:property value="groupIdentifier" /></td>
			<td><s:property value="studentCount" /></td>
			<td><s:property value="minBreak" /></td>
		</tr>
	</s:iterator>
</table>
