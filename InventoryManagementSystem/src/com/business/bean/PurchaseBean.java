package com.accenture.lkm.business.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/* 

*Declare fields to set or get purchaseid, transactionId, vendor name,material category id,material type id, 

*brand name, unit id,quantity,purchase amount, balance, purchase date,material category name, 

  material type name,material unit name and status. 

  Validate the fields using spring validation annotations. 

*Generate toString method. Add default and parameterized constructors. 

*/

public class PurchaseBean {

	private Integer purchaseId;

	private String transactionId;

	@NotBlank
	private String vendorName;

	@NotBlank
	private String materialCategoryId;

	@NotBlank
	private String materialTypeId;

	@NotBlank
	private String brandName;

	@NotBlank
	private String unitId;

	@NotNull
	private Integer quantity;

	@NotNull
	private double purchaseAmount;

	private double balance;

	@NotNull
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date purchaseDate;

	private String materialCategoryName;

	private String materialTypeName;

	private String materialUnitName;

	private String status;

	public PurchaseBean() {

		super();

		// TODO Auto-generated constructor stub

	}

	public PurchaseBean(Integer purchaseId, String transactionId, String vendorName, String materialCategoryId,

			String materialTypeId, String brandName, String unitId, Integer quantity, double purchaseAmount, double balance,

			Date purchaseDate, String materialCategoryName, String materialTypeName, String materialUnitName,

			String status) {

		super();

		this.purchaseId = purchaseId;

		this.transactionId = transactionId;

		this.vendorName = vendorName;

		this.materialCategoryId = materialCategoryId;

		this.materialTypeId = materialTypeId;

		this.brandName = brandName;

		this.unitId = unitId;

		this.quantity = quantity;

		this.purchaseAmount = purchaseAmount;

		this.balance = balance;

		this.purchaseDate = purchaseDate;

		this.materialCategoryName = materialCategoryName;

		this.materialTypeName = materialTypeName;

		this.materialUnitName = materialUnitName;

		this.setStatus(status);

	}

	public Integer getPurchaseId() {

		return purchaseId;

	}

	public void setPurchaseId(Integer purchaseId) {

		this.purchaseId = purchaseId;

	}

	public String getTransactionId() {

		return transactionId;

	}

	public void setTransactionId(String transactionId) {

		this.transactionId = transactionId;

	}

	public String getVendorName() {

		return vendorName;

	}

	public void setVendorName(String vendorName) {

		this.vendorName = vendorName;

	}

	public String getMaterialCategoryId() {

		return materialCategoryId;

	}

	public void setMaterialCategoryId(String materialCategoryId) {

		this.materialCategoryId = materialCategoryId;

	}

	public String getMaterialTypeId() {

		return materialTypeId;

	}

	public void setMaterialTypeId(String materialTypeId) {

		this.materialTypeId = materialTypeId;

	}

	public String getBrandName() {

		return brandName;

	}

	public void setBrandName(String brandName) {

		this.brandName = brandName;

	}

	public String getUnitId() {

		return unitId;

	}

	public void setUnitId(String unitId) {

		this.unitId = unitId;

	}

	public Integer getQuantity() {

		return quantity;

	}

	public void setQuantity(Integer quantity) {

		this.quantity = quantity;

	}

	public double getPurchaseAmount() {

		return purchaseAmount;

	}

	public void setPurchaseAmount(double purchaseAmount) {

		this.purchaseAmount = purchaseAmount;

	}

	public double getBalance() {

		return balance;

	}

	public void setBalance(double balance) {

		this.balance = balance;

	}

	public Date getPurchaseDate() {

		return purchaseDate;

	}

	public void setPurchaseDate(Date purchaseDate) {

		this.purchaseDate = purchaseDate;

	}

	public String getMaterialCategoryName() {

		return materialCategoryName;

	}

	public void setMaterialCategoryName(String materialCategoryName) {

		this.materialCategoryName = materialCategoryName;

	}

	public String getMaterialTypeName() {

		return materialTypeName;

	}

	public void setMaterialTypeName(String materialTypeName) {

		this.materialTypeName = materialTypeName;

	}

	public String getMaterialUnitName() {

		return materialUnitName;

	}

	public void setMaterialUnitName(String materialUnitName) {

		this.materialUnitName = materialUnitName;

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}