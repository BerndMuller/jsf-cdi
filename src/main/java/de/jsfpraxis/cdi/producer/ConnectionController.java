package de.jsfpraxis.cdi.producer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ConnectionController {
	
	private String selectStatement;
	private Long resultSetFirstRowFirstColumnAsLong; 
	
    @Inject
    Connection connection;

    @Inject @Secure
    Connection securedConnection;

	public ConnectionController() {

	}
	
	public void run() throws Exception {
		Statement stmt = connection.createStatement();
	    ResultSet rs = stmt.executeQuery(selectStatement);
	    System.out.println("rs: "  + rs);
	    rs.next();
	    resultSetFirstRowFirstColumnAsLong = rs.getLong(1);
	}

	
	// Getter and Setter
	public String getSelectStatement() {
		return selectStatement;
	}
	public void setSelectStatement(String selectStatement) {
		this.selectStatement = selectStatement;
	}

	public Long getResultSetFirstRowFirstColumnAsLong() {
		return resultSetFirstRowFirstColumnAsLong;
	}
	
}
