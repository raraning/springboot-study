package web.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration //해당 클래스를 Bean 구성 Class임을 알려주는 기능
@PropertySource("classpath:/application.properties") //application.properties를 사용할 수 있도록 설정 파일의 위치를 지정 
public class DatabaseConfiguration {
	
	@Autowired //의존성 주입
	private ApplicationContext applicationContext;
	
	@Bean //개발자가 직접 제어가 불가능한 외부 라이브러리등을 객체(Bean)로 만들때 사용 
	//@ConfigurationProperties 에노테이션에 prefix="spring.datasource.hikari" 설정되어 있기 때문에 [히카리CP]의 설정 파일 생성된다.
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}

	@Bean //데이터베이스 연걸하는 데이터 소스를 생성한다.
	public DataSource dataSource() throws Exception {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println("==디비연결==:"+dataSource.toString()); //콘솔 출력
		return dataSource;
	}
	
	@Bean //스프링-마이바티스에서는 sqlSessionFactory﻿를 생성하기 위해서 SqlSessionFactoryBean﻿을 사용한다.
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml")); //classpath -> resources폴더를 의미
		sqlSessionFactoryBean.setConfiguration(mybatisConfig());
		
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean
	@ConfigurationProperties(prefix="mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfig() {
		return new org.apache.ibatis.session.Configuration();
	}
}
