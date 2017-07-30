package test.app.dao;


import test.app.AppConstants;
import test.app.model.ApplicationProperties;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;


/**
 * Created by belstrel on 28.07.17.
 */
public class DataSourceFactory {

    /**
     * Return Datasource for database from initial params
     * @return BasicDataSource
     */
    public static DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();

        String driverClassName = AppConstants.JDBC_DRIVERS.get(ApplicationProperties.PROPS.getDataBase());
        if(driverClassName == null){
            return null;
        }
        String databaseUrl = AppConstants.JDBC_URLS_PREFIX.get(ApplicationProperties.PROPS.getDataBase())+ApplicationProperties.PROPS.getDataBaseUrl();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(ApplicationProperties.PROPS.getUserName());
        dataSource.setPassword(ApplicationProperties.PROPS.getUserPassword());
        dataSource.setPoolPreparedStatements( true );
        dataSource.setMaxOpenPreparedStatements(AppConstants.POOL_SIZE);

        return dataSource;


    }

}
