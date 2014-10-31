<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%-- 
  - Author: Arne Roever
  - Description: Menu for choosing which master data type to create.
--%>

<h3><s:text name="hdl.masterData"></s:text></h3>
<s:form>
	<%-- The buttons --%>
	<s:submit key="btn.newLecturer" action="ShowLecturerForm"/>
	<s:submit key="btn.newRoom" action="ShowRoomForm"/>
	<s:submit key="btn.newStudentGroup" action="ShowStudentGroupForm"/>
	<s:submit key="btn.return" action="ShowMainMenu"/>
</s:form>
