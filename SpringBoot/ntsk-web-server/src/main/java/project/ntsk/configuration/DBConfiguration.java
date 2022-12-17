package project.ntsk.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DBConfiguration {

	private static final String DB_URL = "jdbc:postgresql://localhost:5432/ntskdb";
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_USER = "ntsk";
	private static final String DB_PASSWORD = "NTSK";
	private static final String DB_NAME = "ntskdb";

	private static final String ENDPOINT = "db-identifier.cluster-XYZ.us-east-2.rds.amazonaws.com";

	@Bean
	public DataSource dataSource() {

//		HikariConfig config = new HikariConfig();
//
//		config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
//		config.addDataSourceProperty("serverName", "localhost");
//		config.addDataSourceProperty("port", "3306");
//		config.addDataSourceProperty("databaseName", "test");
//
//		config.addDataSourceProperty("user", "root");
//		config.addDataSourceProperty("password", "test");
//
//		config.addDataSourceProperty("zeroDateTimeBehavior", "convertToNull");
//		config.addDataSourceProperty("useUnicode", "true");
//		config.addDataSourceProperty("characterEncoding", "utf8");
//		config.addDataSourceProperty("autoReconnect", "true");
//
//		config.addDataSourceProperty("cachePrepStmts", "true");
//		config.addDataSourceProperty("prepStmtCacheSize", "250");
//		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//		config.addDataSourceProperty("useServerPrepStmts", "true");
//
//		config.setMinimumIdle(20);
//		config.setMaximumPoolSize(20);
//
//		HikariDataSource dataSource = new HikariDataSource(config);

		final HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(DB_DRIVER);
		ds.setJdbcUrl(DB_URL);
		ds.setUsername(DB_USER);
		ds.setPassword(DB_PASSWORD);
		return ds;
	}

}
