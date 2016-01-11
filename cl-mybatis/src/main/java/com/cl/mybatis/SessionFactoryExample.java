package com.cl.mybatis;
import java.io.InputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionFactoryExample {
	private static final Logger LOGGER = LoggerFactory.getLogger("rootLogger");

	public SqlSessionFactory build() throws Exception {
		String resource = "com/cl/mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	public void build1() {
		UnpooledDataSourceFactory dataSourceFactory = new UnpooledDataSourceFactory();
		DataSource dataSource = dataSourceFactory.getDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(UserMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	
	}
	
	public void build2() {
		Configuration configuration = new Configuration();
		configuration.addMapper(UserMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	
	}
	
	public void execute(SqlSessionFactory sqlSessionFactory) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
		  User user = (User) session.selectOne("com.cl.mybatis.UserMapper.selectOne", 101);
		  LOGGER.info("dd");
		} finally {
		  session.close();
		}
	}
	
	public void execute1(SqlSessionFactory sqlSessionFactory) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.selectOne(1);
		} finally {
		  session.close();
		}
	}
	
	/**
	 * connection可以来至于外部的连接
	 * @param sqlSessionFactory
	 * @param connection
	 */
	public void execute2(SqlSessionFactory sqlSessionFactory,Connection connection) {
		SqlSession session = sqlSessionFactory.openSession(connection);
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.selectOne(1);
		} finally {
		  session.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		SessionFactoryExample example = new SessionFactoryExample();	
		example.execute(example.build());
	}
}
