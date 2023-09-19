package com.accenture.lkm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unit")
public class UnitEntity {
    @Id
    @Column(name="unit_id")
    private String unitId;
    
    @Column(name="unit_name")
    private String unitName;
    
    
    @Column(name="category_id")
    private String categoryId;

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	
	@Override
	public String toString() {
		return "UnitBean [unitId=" + unitId + ", unitName=" + unitName + ", categoryId="
				+ categoryId + "]";
	}

	public UnitEntity(String unitId, String unitName, String categoryId) {
		super();
		this.unitId = unitId;
		this.unitName = unitName;
		this.categoryId = categoryId;
	}

	public UnitEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
}