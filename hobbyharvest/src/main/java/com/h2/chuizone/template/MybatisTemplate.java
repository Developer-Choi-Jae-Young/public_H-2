package com.h2.chuizone.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTemplate {
	
	/**
	 * Mybatis의 SqlSession객체 생성을 위한 함수
	 * @return SqlSession 객체
	 */
	public static SqlSession getSqlSession() {
		
		SqlSession sqlSession = null;
		
		String resource = "/mybatis-config.xml";
		
		try {
			
			InputStream stream = Resources.getResourceAsStream(resource);
			
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(stream);
			
			sqlSession = ssf.openSession(false);
		
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sqlSession;
		
	}

}
