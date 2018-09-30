package com.zl.test;
/**
 * 
 * @Description:基础测试类
 * @author i-leizh
 * @date:  2018年9月27日 下午3:21:48
 */

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

public class BaseMapperTest {

	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void inti() {
		try {

			Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
			resourceAsReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
	@Test
	public void test() {
		System.out.println(getSqlSession());
	}
	

}
