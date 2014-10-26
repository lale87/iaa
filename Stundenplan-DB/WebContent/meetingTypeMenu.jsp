<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- The buttons --%>
	<s:submit key="btn.newLecture" action="ShowLectureForm"/>
	<s:submit key="btn.newExam"/>
	<s:submit key="btn.newElective"/>
	<s:submit key="btn.newSeminar"/>
	<s:submit key="btn.cancel" action="CancelMeetingTypeMenu"/>
</s:form>
