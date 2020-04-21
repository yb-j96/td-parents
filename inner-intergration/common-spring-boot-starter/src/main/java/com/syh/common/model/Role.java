package com.syh.common.model;

public class Role {
	//角色ID，用UUID
	private String id;
	//角色名称
	private String roleName;
	//备注
	private String remark;
	//是否启用
	private String enable;
	//创建时间
	private long createTime;
	//修改时间
	private long modifyTime;
	//角色所属单位ID,外键单位ID
    private String subordinateUnitID;
	
	/**
	 * 权限用到的ID
	 */
	private String competenceid;

	
	


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getRoleName() {
		return roleName;
	}



	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getEnable() {
		return enable;
	}



	public void setEnable(String enable) {
		this.enable = enable;
	}



	public long getCreateTime() {
		return createTime;
	}



	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}



	public long getModifyTime() {
		return modifyTime;
	}



	public void setModifyTime(long modifyTime) {
		this.modifyTime = modifyTime;
	}



	public String getSubordinateUnitID() {
		return subordinateUnitID;
	}



	public void setSubordinateUnitID(String subordinateUnitID) {
		this.subordinateUnitID = subordinateUnitID;
	}



	public String getCompetenceid() {
		return competenceid;
	}



	public void setCompetenceid(String competenceid) {
		this.competenceid = competenceid;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "@role id:"+id+";name:"+roleName;
	}


}