<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agent to Agent Transfer Inquiry</title>
</head>
<body>
<center>
<h1>Agent to Agent Transfer Inquiry</h1>
<form action="../dynamic" method="POST">
<input type="hidden" value="Wallet" name="service" /> 
<input type="hidden" value="AgentToAgentTransferInquiry" name="txnName" />
<table>
	<tr>
		<td>SourcePhoneNumber</td>
		<td><input type="text" name="sourceMDN" value="" /></td>
	</tr>
	<tr>
		<td>SourcePIN</td>
		<td><input type="text" name="sourcePIN" value="" /></td>
	</tr>
	<tr>
		<td>AgentCode</td>
		<td><input type="text" name="agentCode" value="" /></td>
	</tr>
	<tr>
		<td>Amount</td>
		<td><input type="text" name="amount" value="" /></td>
	</tr>
	<tr>
		<td>channelId</td>
		<td><input type="text" name="channelID" value="" /></td>
	</tr>
	<tr>
		
		<td><input type="hidden" name="bankID" value="" /></td>
	</tr>
	<tr>
		<td>PocketCode</td>
		<td><input type="text" name="sourcePocketCode" />(Emoney-1 ,Bank-2)</td>
	</tr>
	
	<tr>
		<td colspan="2"><input type="submit" value="submit" /></td>
	</tr>
</table>
</form>
</center>
</body>
</html>