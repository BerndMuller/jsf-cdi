package de.jsfpraxis.cdi.producer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.sql.DataSource;

public class DatabaseConnectionProvider {

	// anderer Name führt zu Deployment-Exception
	@Resource(lookup = "java:comp/DefaultDataSource")
	DataSource dataSource;

	@Inject
	Logger logger;

	public DatabaseConnectionProvider() {
	}
	
	@Produces
	public Connection createConnection() throws SQLException {
		logger.info("Producer für 'Connection' aufgerufen " + dataSource);
		return dataSource.getConnection("sa", "");
	}
	
	@Secure
	@Produces 
	public Connection createSecureConnection() throws SQLException {
		logger.info("Producer für 'Secure Connection' aufgerufen");
		return dataSource.getConnection("sa", "");
	}
	

	@SuppressWarnings("unused")
	private void disposeConnection(@Disposes Connection connection) throws SQLException {
		logger.info("Disposer für 'Connection' aufgerufen");
		if (!connection.isClosed()) {
			connection.close();
		}
	}

	@SuppressWarnings("unused")
	private void disposeSecureConnection(@Disposes @Secure Connection connection) throws SQLException {
		logger.info("Disposer für 'Secure Connection' aufgerufen");
		if (!connection.isClosed()) {
			connection.close();
		}
	}

}
