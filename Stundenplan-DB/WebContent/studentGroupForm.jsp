<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- Form fields for the car's attributes --%>
	<s:select name="studentGroup.fieldOfStudy" key="lbl.fieldOfStudy" list="allFieldsOfStudy" requiredLabel="true"/>
	<s:textfield name="studentGroup.cohort.yearOfAdmission" key="lbl.yearOfAdmission" size="4" maxlength="4" requiredLabel="true"/>
	<s:textfield name="studentGroup.groupIdentifier" key="lbl.groupIdentifier" size="1" maxlength="1" requiredLabel="true"/>
	<s:textfield name="studentGroup.studentCount" key="lbl.studentCount" size="4" maxlength="4" requiredLabel="true"/>
	<s:textfield name="studentGroup.minBreak" key="lbl.minBreak" size="3" maxlength="3" requiredLabel="true"/>	

	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveStudentGroup"/>
	<s:submit key="btn.cancel" action="CancelMasterData"/>
</s:form>
