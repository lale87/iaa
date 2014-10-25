<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form>
	<%-- Form fields for the room attributes --%>
	<s:hidden name="room.id"/>
	<s:textfield name="room.changingTime" key="lbl.changingTime" size="5" maxlength="5" requiredLabel="true"/>
	<s:textfield name="room.seats" key="lbl.seats" size="5" maxlength="5" requiredLabel="true"/>
	<s:textfield name="room.roomType" key="lbl.roomType" size="40" maxlength="100" requiredLabel="true"/>
	<s:textfield name="room.building" key="lbl.building" size="1" maxlength="1" requiredLabel="true"/>
	<s:textfield name="room.roomNumber" key="lbl.roomNumber" size="4" maxlength="4" requiredLabel="true"/>

	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveRoom"/>
	<s:submit key="btn.cancel" action="CancelMasterData"/>
</s:form>
