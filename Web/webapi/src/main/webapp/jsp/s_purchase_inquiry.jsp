<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Buy Inquiry</title>
</head>
<body>
<center>
<h1>Shopping Buy Inquiry</h1>
<form action="../sdynamic" method="POST">
<input type="hidden" value="Shopping" name="service" /> 
<input type="hidden" value="PurchaseInquiry" name="txnName" />
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
		<td>SourcePIN</td>
		<td><input type="text" name="sourcePIN" value="" /></td>
	</tr>
	<tr>
		<td>MerchantCode</td>
		<td><input type="text" name="partnerCode" value="" /></td>
	</tr>
	 <tr> 
 			<td>PaymentMode(optional)</td> 
 			<td><input type="text" name="paymentMode" value="" /></td> 
 	</tr>
	<tr>
		<td>Amount</td>
		<td><input type="text" name="amount" value="" /></td>
	</tr>
	<tr>
		<td>Invoice No</td>
		<td><input type="text" name="billNo" value="" /></td>
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
		<td>Description</td>
		<td><input type="text" name="description" /></td>
	</tr>
	
	<tr>
		<td colspan="2"><input type="submit" value="submit" /></td>
	</tr>
</table>
</form>
</center>
</body>
</html>