<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%-- 
  - Author: Arne Roever
  - Description: Form for saving new room.
--%>

<h3><s:text name="hdl.newRoom"></s:text></h3>
<s:form cssClass="strutsTable">
	<%-- Form fields for the room attributes --%>
	<s:hidden name="room.id"/>
	<s:textfield name="room.building" key="lbl.building" size="1" maxlength="1" requiredLabel="true"/>
	<s:textfield name="room.roomNumber" key="lbl.roomNumber" size="4" maxlength="4" requiredLabel="true"/>	
	<s:textfield name="room.seats" key="lbl.seats" size="5" maxlength="5" requiredLabel="true"/>
	<s:select name="room.roomType" key="lbl.roomType" list="allRoomTypes" requiredLabel="true"/>
	<s:textfield name="room.changingTime" key="lbl.changingTime" size="5" maxlength="5" requiredLabel="true"/>	

	<%-- The buttons --%>
	<s:submit key="btn.save" action="SaveRoom"/>
	<s:submit key="btn.cancel" action="CancelNewRoom"/>
</s:form>

<%-- Table for displaying existing rooms --%>
<h3><s:text name="hdl.existingRooms"></s:text></h3>
<table class="strutsTable">
	<tr>		
		<th><s:text name="lbl.building" /></th>
		<th><s:text name="lbl.roomNumber" /></th>
		<th><s:text name="lbl.seats" /></th>
		<th><s:text name="lbl.roomType" /></th>
		<th><s:text name="lbl.changingTime" /></th>
	</tr>
	<s:iterator value="allRooms">
		<tr>
			<td><s:property value="building" /></td>
			<td><s:property value="roomNumber" /></td>
			<td><s:property value="seats" /></td>
			<td><s:property value="roomType" /></td>
			<td><s:property value="changingTime" /></td>
		</tr>
	</s:iterator>
</table>
