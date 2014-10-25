<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- The buttons --%>
	<s:submit key="btn.lecturer" action="ShowLecturerForm"/>
	<s:submit key="btn.room" action="ShowRoomForm"/>
	<s:submit key="btn.studentgroup" action="ShowStudentGroupForm"/>
	<s:submit key="btn.cancel" action="CancelMasterDataMenu"/>

</s:form>
