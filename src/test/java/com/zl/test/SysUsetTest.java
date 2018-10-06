package com.zl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zl.entity.SysRole;
import com.zl.entity.SysUser;
import com.zl.mapper.UserMapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

public class SysUsetTest extends BaseMapperTest {

	@Test
	public void testSelectAll() {
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			List<SysUser> list = userMapper.selectAll();
			System.err.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testselectRolesByUserId() {
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			List<SysRole> list = userMapper.selectRolesByUserId(1L);
			System.err.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testInsert() {

		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();

			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("zl");
			sysUser.setUserPassword("1120");
			sysUser.setUserEmail("1120@qq.com");
			sysUser.setUserInfo("info");
			sysUser.setHeadImg(new byte[] { 1, 2, 3 });
			sysUser.setCreateTime(new Date());
			int rs = userMapper.insert2(sysUser);
			System.out.println("返回执行sql影响的行数:" + rs);
			System.out.println("返回的主键:" + sysUser.getId());
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectRolesByUserIdAndRoleEnabled() {

		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysRole> list = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectByUser() {
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			// sysUser.setUserName("a");
			// sysUser.setUserEmail("admin@mybatis.tk");
			List<SysUser> list = userMapper.selectByUser(sysUser);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testselectByIdOrUserName() {
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			// sysUser.setUserName("admin");
			// sysUser.setId(1L);
			SysUser user = userMapper.selectByIdOrUserName(sysUser);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	@Test
	public void testselectByMap() {
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			HashMap<Object, Object> map = new HashMap<>();
			map.put("createTime", new Date());
			List<SysUser> list = userMapper.selectByMap(map);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testCommonsMapper() {
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			// 创建一个MaperHelper
			MapperHelper mapperHelper = new MapperHelper();
			// 特殊配置
			Config config = new Config();
			// 主键自增回写方法，默认值MYSQL
			config.setIDENTITY("MYSQL");
			// 支持getter和setter方法上的注解
			config.setEnableMethodAnnotation(true);
			// 设置 insert 和 update 中，是否判断字符串类型!=''
			config.setNotEmpty(true);
			// 校验Example中的类型和最终调用时Mapper的泛型是否一致
			config.setCheckExampleEntityClass(true);
			// 启用简单类型
			config.setUseSimpleType(true);
			// 枚举按简单类型处理
			config.setEnumAsSimpleType(true);
			// 自动处理关键字 - mysql
			config.setWrapKeyword("`{0}`");
			// 设置配置
			mapperHelper.setConfig(config);
			mapperHelper.registerMapper(Mapper.class);
			mapperHelper.processConfiguration(sqlSession.getConfiguration());
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> list = userMapper.selectAll();
			SysUser selectById = userMapper.selectByPrimaryKey(1L);
			System.out.println(selectById);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testSelectByIdList() {
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<Long> list = new ArrayList<>();
			list.add(1L);
			list.add(1001L);
			List<SysUser> userList = userMapper.selectByIdList(list);
			System.out.println("结果" + userList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testInsertList() {
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> list = new ArrayList<>();
			for (int i = 0; i < 2; i++) {
				SysUser sysUser = new SysUser();
				sysUser.setUserName("张磊");
				sysUser.setUserPassword("1120");
				sysUser.setUserEmail("1120@zl.com");
				sysUser.setUserInfo("zl");
				list.add(sysUser);
			}
			int i = userMapper.insertList(list);
			sqlSession.commit();
			System.out.println("结果：" + i);
			System.out.println("id" + list.get(0).getId());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testUpdateByMap() {
		SqlSession sqlSession = null;
		try {
			sqlSession = getSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			Map<String, Object> map = new HashMap<>();
			map.put("id", 1048L);
			map.put("user_name", "张磊");
			int i = userMapper.updateByMap(map);
			SysUser sysUser = userMapper.selectById(1048L);
			System.out.println(sysUser);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}
