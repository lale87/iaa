<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- The buttons --%>
	<s:submit key="btn.masterdata" action="ShowMasterData"/>
	<s:submit key="btn.meeting" action="ShowMeetingList"/>
	<s:submit key="btn.timetable"/>
</s:form>
