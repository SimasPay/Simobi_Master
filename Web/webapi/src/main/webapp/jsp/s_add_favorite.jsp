<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Favorite</title>
</head>
<body>
<center>
<h1>Add Favorite</h1>
<form action="../sdynamic" method="POST">
<input type="hidden" value="Account" name="service" /> 
<input type="hidden" value="AddFavorite" name="txnName" /> 
<table>
	<tr>
		<td>Institution ID*</td>
		<td><input type="text" name="institutionID" value="" /><em>Required if the request is from an Integration</em></td>
	</tr>
	<tr>
		<td>Integration Authentication Key*</td>
		<td><input type="text" name="authenticationKey" value="" /></td>
	</tr>
	<tr>
		<td>PhoneNumber</td>
		<td><input type="text" name="sourceMDN" value="" /></td>
	</tr>
	<tr>
		<td>Pin</td>
		<td><input type="text" name="sourcePIN" value="" /></td>
	</tr>
	<tr>
		<td>CategoryId</td>
		<td><input type="text" name="favoriteCategoryID" value="" /></td>
	</tr>
	<tr>
		<td>Label</td>
		<td><input type="text" name="favoriteLabel" value="" /></td>
	</tr>
	<tr>
		<td>Value</td>
		<td><input type="text" name="favoriteValue" value="" /></td>
	</tr>
	<tr>
		<td>channelId</td>
		<td><input type="text" name="channelID" value="" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="submit" /></td>
	</tr>
</table>
</form>
</center>
</body>
</html>