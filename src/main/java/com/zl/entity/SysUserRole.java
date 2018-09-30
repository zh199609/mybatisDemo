package com.zl.entity;
/**
 * 
 * @Description:用户关联表
 * @author i-leizh
 * @date:  2018年9月27日 下午2:57:53
 */
public class SysUserRole {
	
	/**
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 角色ID
	 */
	private Long roleId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
}
