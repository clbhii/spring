package com.cl.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SelectExample {

	public void select() throws Exception {
		SessionFactoryExample example = new SessionFactoryExample();		

		SqlSessionFactory sqlSessionFactory = example.build();
		SqlSession session = sqlSessionFactory.openSession();
		try {
		 List<Map<String, Object>> list = session.selectList("com.cl.mybatis.UserMapper.selectByCriterial");
		 System.out.println(list.size());
		} finally {
		  session.close();
		}
		System.out.println("success");
	}
	
	public static void main(String[] args) throws Exception {
		SelectExample select = new SelectExample();
		select.select();
	}
	
	
}
