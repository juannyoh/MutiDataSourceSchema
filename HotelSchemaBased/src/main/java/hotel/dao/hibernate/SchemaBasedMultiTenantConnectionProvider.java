package hotel.dao.hibernate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.hibernate.HibernateException;
//import org.hibernate.service.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
//import org.hibernate.service.jdbc.connections.spi.MultiTenantConnectionProvider;
//import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
//import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.service.jdbc.connections.internal.DatasourceConnectionProviderImpl;
//import org.hibernate.service.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
import org.hibernate.service.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.service.spi.Configurable;
//import org.hibernate.service.spi.ServiceRegistryAwareService;
//import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.hibernate.service.spi.Stoppable;

public class SchemaBasedMultiTenantConnectionProvider implements MultiTenantConnectionProvider, Stoppable,
		Configurable/*, ServiceRegistryAwareService */{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//	private final DriverManagerConnectionProviderImpl connectionProvider = new DriverManagerConnectionProviderImpl();
	 private final DatasourceConnectionProviderImpl connectionProvider = new DatasourceConnectionProviderImpl();
	
	@Override
	public Connection getAnyConnection() throws SQLException {
		return connectionProvider.getConnection();
	}

	@Override
	public void releaseAnyConnection(Connection connection) throws SQLException {
		connectionProvider.closeConnection(connection);
	}

	@Override
	public Connection getConnection(String tenantIdentifier) throws SQLException {
		final Connection connection = getAnyConnection();
		try {
			connection.createStatement().execute("USE " + tenantIdentifier);
		} catch (SQLException e) {
			throw new HibernateException("Could not alter JDBC connection to specified schema [" + tenantIdentifier
					+ "]", e);
		}
		return connection;
	}

	@Override
	public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
		try {
			connection.createStatement().execute("USE egisp_dev");
		} catch (SQLException e) {
			throw new HibernateException("Could not alter JDBC connection to specified schema [" + tenantIdentifier
					+ "]", e);
		}
		connectionProvider.closeConnection(connection);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		return this.connectionProvider.isUnwrappableAs(unwrapType);
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		return this.connectionProvider.unwrap(unwrapType);
	}

	@Override
	public void stop() {
		this.connectionProvider.stop();
	}

	@Override
	public boolean supportsAggressiveRelease() {
		return this.connectionProvider.supportsAggressiveRelease();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void configure(Map configurationValues) {
		this.connectionProvider.configure(configurationValues);
	}

	/*@Override
	public void injectServices(ServiceRegistryImplementor serviceRegistry) {
		this.connectionProvider.injectServices(serviceRegistry);

	}*/
}
