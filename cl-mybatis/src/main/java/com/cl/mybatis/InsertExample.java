package com.cl.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class InsertExample {

	public void insert() throws Exception {
		SessionFactoryExample example = new SessionFactoryExample();		
		
		User user = new User();
		user.setUserName("cl");
		user.setUserAge(1);
		SqlSessionFactory sqlSessionFactory = example.build();
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
		 session.insert("com.cl.mybatis.UserMapper.insertOne", user);
		 session.commit();
		} finally {
		  session.close();
		}
		System.out.println(user.getId());
	}
	
	/**
	 * mybatis 在单条插入的时候 可以使用 useGeneratedKeys keyProperty 两个属性获取插入后的key， 或者使用<selectKey>获取。但是批量插入时，就获取不到插入的自增长的主键了，查阅发现似乎是JDBC就不支持这种情况。
	 * @throws Exception
	 */
	public void insertList() throws Exception {
		List<User> list = new ArrayList<User>();
		
		SessionFactoryExample example = new SessionFactoryExample();		
		
		User user = new User();
		user.setUserName("cl3");
		user.setUserAge(3);
		list.add(user);
		user = new User();
		user.setUserName("cl2");
		user.setUserAge(2);
		list.add(user);
		
		SqlSessionFactory sqlSessionFactory = example.build();
		SqlSession session = sqlSessionFactory.openSession();
		try {
		 session.insert("com.cl.mybatis.UserMapper.insertList", list);
		} finally {
		  session.close();
		}
		System.out.println(list.get(0).getId());
	}
	
	public static void main(String[] args) throws Exception{
		InsertExample insert = new InsertExample();
		insert.insert();
	}
}
