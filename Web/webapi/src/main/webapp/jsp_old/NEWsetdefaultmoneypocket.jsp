<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SetDefault MOney Pocket</title>
</head>
<body>
<center>
<h1>SetDefault MOney Pocket</h1>
<form action="../dynamic" method="POST">
<input type="hidden" value="3" name="mode" /> 
<input type="hidden" value="setdefaultmoneyaccount"	name="serviceName" />
<table>
	<tr>
		<td>SourceMDN</td>
		<td><input type="text" name="sourceMDN" /></td>
	</tr>
	<tr>
		<td>SourcePIN</td>
		<td><input type="text" name="sourcePIN" /></td>
	</tr>
	<tr>
		<td>Card PAN Suffix</td>
		<td><input type="text" name="cardPANSuffix" /></td>
	</tr>
	<tr>
		<td>channelId</td>
		<td><input type="text" name="channelId" /></td>
	</tr>
	<tr>
		<td>sourcePocketCode</td>
		<td><input type="text" name="sourcePocketCode" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" /></td>
	</tr>
</table>
</form>
</center>
</body>
</html>