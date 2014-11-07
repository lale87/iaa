<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%-- 
  - Author: Arne Roever
  - Description: Header of stundenplan-db.
 --%>

<%-- 
	- CSS style for table layout
	- Source: http://www.textfixer.com/tutorials/css-tables.php 
	- basic css styled table
  --%>
<style type="text/css">
table.strutsTable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.strutsTable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.strutsTable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>

<h1>
	<s:text name="txt.welcome" />
</h1>