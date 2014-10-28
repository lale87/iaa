<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<h3>
	<s:text name="hdl.newLecturer"></s:text>
</h3>
<s:form>
	<%-- Form fields for the lecturer's attributes --%>
	<s:hidden name="lecturer.id" />
	<s:select name="lecturer.title" key="lbl.academicTitle"
		list="allAcademicTitles" listValue="shortTitle" requiredLabel="true" />
	<s:textfield name="lecturer.firstName" key="lbl.firstName" size="30"
		maxlength="30" requiredLabel="true" />
	<s:textfield name="lecturer.lastName" key="lbl.lastName" size="30"
		maxlength="50" requiredLabel="true" />
	<s:textfield name="lecturer.abbreviation" key="lbl.abbreviation"
		size="5" maxlength="5" requiredLabel="true" />
	<s:textfield name="lecturer.minBreak" key="lbl.minBreak" size="3"
		maxlength="3" requiredLabel="true" />

	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveLecturer" />
	<s:submit key="btn.cancel" action="CancelMasterData" />
</s:form>


<%-- The table of existing lectures --%>
<h3>
	<s:text name="hdl.existingLecturers"></s:text>
</h3>
<table style="border-collapse: collapse; border: #CCC;" border="1">
	<tr>		
		<th><s:text name="lbl.academicTitle" /></th>
		<th><s:text name="lbl.firstName" /></th>
		<th><s:text name="lbl.lastName" /></th>
		<th><s:text name="lbl.abbreviation" /></th>
		<th><s:text name="lbl.minBreak" /></th>
	</tr>
	<s:iterator value="allLecturers">
		<tr>
			<td><s:property value="title.shortTitle" /></td>
			<td><s:property value="firstName" /></td>
			<td><s:property value="lastName" /></td>
			<td><s:property value="abbreviation" /></td>
			<td><s:property value="minBreak" /></td>
		</tr>
	</s:iterator>
</table>
