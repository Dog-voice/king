package orm;

 

import java.io.IOException;

 

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSessionFactory;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;

 

public class DatabaseBuilder {

	private static SqlSessionFactory factory;

	private static final String configLoc = "orm/MybatisConfig.xml";

	

	static {

		try {

			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(configLoc));

		} catch (IOException e) {

			// 마이바티스 설정 오류 시 메시지

			e.printStackTrace();

		}

	}

	

	public static SqlSessionFactory getFactory() {

		return factory;

	}

}