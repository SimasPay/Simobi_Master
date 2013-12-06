<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NFC Card Balance</title>
</head>
<body>
<center>
<h1>NFC Card Balance</h1>
<form action="../sdynamic" method="POST">
<input type="hidden" value="NFCService" name="service" /> 
<input type="hidden" value="NFCCardBalance" name="txnName" />
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
		<td>SourcePhoneNumber</td>
		<td><input type="text" name="sourceMDN" value="" /></td>
	</tr>
	<tr>
		<td>PIN</td>
		<td><input type="text" name="sourcePIN"/></td>
	</tr>
	<tr>
		<td>Enter either of the below fields if you need details of a particular card.</td>
		<td>Leave it blank to fetch details of all the cards.</td>
	</tr>
	<tr>
		<td>Card PAN</td>
		<td><input type="text" name="cardPan" value="" /></td>
	
		<td>Card Alias </td>
		<td><input type="text" name="cardAlias" value="" /></td>
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
