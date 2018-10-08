package com.zl.test;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import com.zl.entity.SysUser;

public class CollectionsTest {
	public static void main(String[] args) {
		SysUser sysUser1 = new SysUser();
		sysUser1.setId(1L);
		sysUser1.setUserName("user1");

		SysUser sysUser2 = new SysUser();
		sysUser2.setId(7L);
		sysUser2.setUserName("user2");

		ArrayList<SysUser> list = new ArrayList<>();
		list.add(sysUser1);
		list.add(sysUser2);

		Map<Long, SysUser> collect = list.stream().collect(Collectors.toMap(SysUser::getId, sysUser -> sysUser));
		//System.out.println(collect);
		
		String str="zhanglei";
		System.out.println(str.substring(0,6));
	}
	
	
	
	public void test() {
		int a = 8<<1;
		//1000000000
		String reg = "^[1-9]\\d{16}[0-9Xx]$";

		//新增
		System.out.println(a);
	}
	
	
}
