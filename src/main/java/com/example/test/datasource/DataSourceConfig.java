package com.example.test.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration// 注册到springboot容器中
@MapperScan(basePackages = {"com.example.test.mapper","com.example.mapper"}, sqlSessionFactoryRef = "testSqlSessionFactory")
public class DataSourceConfig {

	/**
	 * 
	 * @methodDesc: 功能描述:(配置test1数据库)
	 * @author: 
	 * @param: @return
	 * @createTime:2017年9月17日下午3:16:44
	 * @returnType:@return DataSource
	 * @copyright:
	 * @QQ:644064779
	 */
	@Bean(name = "testDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.test")
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(test1 sql会话工厂)
	 * @author: 
	 * @param: @param
	 *             dataSource
	 * @param: @return
	 * @param: @throws
	 *             Exception
	 * @createTime:2017年9月17日下午3:17:08
	 * @returnType:@paramdataSource
	 * @returnType:@return
	 * @returnType:@throws Exception SqlSessionFactory
	 * @copyright:
	 * @QQ:644064779
	 */
	@Bean(name = "testSqlSessionFactory")
	@Primary
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
//		bean.setMapperLocations(
//				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
		return bean.getObject();
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(test1 事物管理)
	 * @author: 
	 * @param: @param
	 *             dataSource
	 * @param: @return
	 * @param: @throws
	 *             Exception
	 * @createTime:2017年9月17日下午3:17:08
	 * @returnType:@paramdataSource
	 * @returnType:@return
	 * @returnType:@throws Exception SqlSessionFactory
	 * @copyright:
	 * @QQ:644064779
	 */
	@Bean(name = "testTransactionManager")
	@Primary
	public DataSourceTransactionManager testTransactionManager(@Qualifier("testDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "testSqlSessionTemplate")
	public SqlSessionTemplate testSqlSessionTemplate(
			@Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
