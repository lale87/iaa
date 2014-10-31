<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%-- 
  - Author: Arne Roever
  - Description: Main menu of stundenplan db.
--%>

<h3><s:text name="hdl.mainMenu"></s:text></h3>
<s:form>
	<%-- The buttons --%>
	<s:submit key="btn.masterdata" action="ShowMasterData"/>
	<s:submit key="btn.meeting" action="ShowMeetingMenu"/>
	<s:submit key="btn.timetable" action="ShowTimetableMenu"/>	
</s:form>
