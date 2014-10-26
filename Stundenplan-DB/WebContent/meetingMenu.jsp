<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- The buttons --%>
	<s:submit key="btn.newMeeting"/>
	<s:submit key="btn.editMeeting"/>
	<s:submit key="btn.deleteMeeting"/>
	<s:submit key="btn.cancel" action="ShowMainMenu"/>
</s:form>
