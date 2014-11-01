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
	<s:submit key="btn.return" action="ShowTimetableMenu" />
</s:form>
