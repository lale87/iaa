<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h3><s:text name="hdl.mainMenu"></s:text></h3>
<s:form>
	<%-- The buttons --%>
	<s:submit key="btn.masterdata" action="ShowMasterData"/>
	<s:submit key="btn.meeting" action="ShowMeetingList"/>
	<s:submit key="btn.timetable"/>
</s:form>
