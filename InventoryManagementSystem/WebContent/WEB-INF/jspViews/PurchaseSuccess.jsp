<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 

<head> 
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/> 

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Success</title> 
</head> 

<body> 
<div align="center" class="container"> 
<jsp:include page="include.jsp" /> 
<h2 align="center">Material Purchase Details</h2> 

<!-- Display purchase details in table along with purchase id. --> 
	<table border="2"> 
		<tr> 
		<td>Vendor Name</td> 
		<td>${purchaseBean.vendorName }</td> 
		</tr> 

		<tr> 
		<td>Material Category</td> 
		<td>${purchaseBean.materialCategoryName }</td> 
		</tr> 
		<tr> 

		<td>Material Type</td> 
		<td>${purchaseBean.materialTypeName }</td> 
		</tr> 

		<tr> 
		<td>Unit</td> 
		<td>${purchaseBean.materialUnitName }</td> 
		</tr> 

		<tr> 
		<td>Brand Name</td> 
		<td>${purchaseBean.brandName }</td> 
		</tr> 

		<tr> 
		<td>Quantity</td> 
		<td>${purchaseBean.quantity }</td> 
		</tr> 

		<tr> 
		<td>Purchase Amount</td> 
		<td>${purchaseBean.purchaseAmount }</td> 
		</tr> 

		<tr> 
		<td>Purchase Date</td> 
		<td>${purchaseBean.purchaseDate }</td> 
		</tr> 
	</table> 
</div>
	<div class="terms1"> 
  		<p align="center" style="font-family: calibri;color: #6666CC;">Copyright © 2018 Accenture All Rights Reserved.</p> 
	</div> 
</body> 
</html> 