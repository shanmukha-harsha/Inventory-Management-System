package com.accenture.lkm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="material_type")
public class MaterialTypeEntity {
	@Id
	@Column(name="type_id")
	private String typeId;
	@Column(name="type_name")
	private String typeName;
	
	@Column(name="category_id")
	private String categoryId ;
	
	
	
	
	public MaterialTypeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
		
	@Override
	public String toString() {
		return "MaterialTypeBean [typeId=" + typeId + ", typeName=" + typeName + ", categoryId="
				+ categoryId + "]";
	}
	
	
}
