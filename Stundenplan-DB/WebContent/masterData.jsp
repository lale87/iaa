<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- The buttons --%>
	<s:submit key="btn.newLecturer" action="ShowLecturerForm"/>
	<s:submit key="btn.newRoom" action="ShowRoomForm"/>
	<s:submit key="btn.newStudentGroup" action="ShowStudentGroupForm"/>
	<s:submit key="btn.cancel" action="CancelMasterDataMenu"/>

</s:form>
