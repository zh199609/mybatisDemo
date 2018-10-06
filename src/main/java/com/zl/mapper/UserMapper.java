package com.zl.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zl.entity.SysRole;
import com.zl.entity.SysUser;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<SysUser> {

	/**
	 * 
	 * @Title: selectById
	 * @Description: 通过id查询用户
	 * @param id
	 * @return
	 */
	SysUser selectById(Long id);

	List<SysUser> selectAll();

	/**
	 * 
	 * @Title: selectRolesByUserId
	 * @Description: 根据用户id获取角色信息
	 * @param userId
	 * @return
	 */
	List<SysRole> selectRolesByUserId(Long userId);

	/**
	 * 
	 * @Title: insert
	 * @Description: 新增用户
	 * @param sysUser
	 * @return
	 */
	int insert(SysUser sysUser);

	int insert2(SysUser sysUser);

	List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId, @Param("enabled") Integer emabled);

	List<SysUser> selectByUser(SysUser sysUser);

	/**
	 * 
	 * @Title: selectByIdOrUserName
	 * @Description: 根据id或者用户名查询
	 * @param sysUser
	 * @return
	 */
	SysUser selectByIdOrUserName(SysUser sysUser);

	/**
	 * Map參數測試
	 * @param map
	 * @return
	 */
	List<SysUser> selectByMap(Map<Object, Object> map);
	
	
	/**
	 * @Description: 根据用户id集合查询
	 * @param map
	 * @return
	 */
	List<SysUser> selectByIdList(@Param("idList")List<Long> idList);
	
	
	/**
	 *  批量插入用户信息
	 * @param userList
	 * @return
	 */
	int insertList(List<SysUser> userList);
	
	
	int updateByMap(Map<String, Object> map);

}
