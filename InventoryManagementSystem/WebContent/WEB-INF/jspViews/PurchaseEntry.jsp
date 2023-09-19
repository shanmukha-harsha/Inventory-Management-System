<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datetimepicker.js"></script>
<title>Purchase Entry</title>
<script type="text/javascript">
function displayPageElements(){
	if(document.getElementById("category").value == ""){
		
	document.getElementById("belowTables").style.display = "none";
	}else{
		
		document.getElementById("belowTables").style.display = "block";
	}
}
</script>
</head>
<body>
<div align="center" class="container">
<jsp:include page="include.jsp" />
<h2 align="center">Material Purchase Entry</h2>
${materialTypeList }
<!-- Add tables and form tags to get purchase details here -->
	<f:form action="getUnitAndTypeList.html" method="POST" 
			modelAttribute="purchaseBean"> 
			<table border="2"> 
				<tr> 
					<td>Vendor Name</td> 
					<td>
						<f:select path="vendorName"> 
							<f:option value="--Select--" /> 
							<%-- <f:options items="${vendorList }" />  --%>
							<c:forEach var="prof" items="${vendorList}">
	     						<f:option value="${prof.vendorName}" label="${prof.vendorName}" />
	   						</c:forEach>
						</f:select>
					</td> 
					<td><f:errors path="vendorName"></f:errors> </td>
				</tr> 
				<tr> 
					<td>Material Category</td> 
					<td><f:select path="materialCategoryId" onchange="submit()"> 
							<f:option value="--Select--" /> 
						<%-- <f:options items="${categoryList}" /> --%> 
							<c:forEach var="prof" items="${categoryList}">
	     						<f:option value="${prof.categoryId}" label="${prof.categoryName}" />
	   						</c:forEach>
						</f:select></td> 
					<td><f:errors path="materialCategoryId"></f:errors></td> 
				</tr> 
				
			</table>
		</f:form>
		<f:form action="addPurchaseDetail.html" method="POST" 
			modelAttribute="purchaseBean">
			<table border="2">
				<tr> 
					<td>Material Type</td> 
					<td><f:select path="materialTypeId"> 
							<f:option value="--Select--"></f:option> 
							<c:forEach var="prof" items="${materialTypeList}">
	     						<f:option value="${prof.typeId}" label="${prof.typeName}" />
	   						</c:forEach>
 						</f:select> 
 					</td>
 					<td><f:errors path="materialTypeId"></f:errors></td> 
				</tr> 
				<tr> 
					<td>Unit</td> 
					<td><f:select path="unitId"> 
							<f:option value="--Select--"></f:option> 
							<c:forEach var="prof" items="${unitList}">
	     						<f:option value="${prof.unitId}" label="${prof.unitName}" />
	   						</c:forEach>
 						</f:select> 
 					</td>
 					<td><f:errors path="unitId"></f:errors></td> 
				</tr> 
				<tr> 
					<td>Brand Name</td> 
					<td><f:input path="brandName"/></td>
					<td><f:errors path="brandName"></f:errors></td>
				</tr> 
				<tr> 
					<td>Quantity</td> 
					<td><f:input path="quantity"/></td>
					<td><f:errors path="quantity"></f:errors></td>
				</tr> 
				<tr> 
					<td>Purchase Amount</td>
					<td><f:input path="purchaseAmount"/> </td>
					<td><f:errors path="purchaseAmount"></f:errors></td>
				</tr> 
				<tr> 
					<td>Purchase Date</td> 
					<td><f:input path="purchaseDate" cssClass="form-control" />
					<td><f:errors path="purchaseDate"></f:errors></td>
				</tr> 
				<tr> 
					<td colspan="2"><input type="submit" value="Submit" /></td> 
				</tr> 
			</table> 
		</f:form> 
</div>
${message }
<div class="terms2">
  <p align="center" style="font-family: calibri;color: #6666CC;">Copyright © 2018 Accenture All Rights Reserved.</p>
</div>
</body>
</html>