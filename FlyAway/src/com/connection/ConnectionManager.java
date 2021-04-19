package com.connection;

import java.sql.Connection;

public interface ConnectionManager {
	public void loadDriver(String dbDriver);
	public Connection getconnection();

}
