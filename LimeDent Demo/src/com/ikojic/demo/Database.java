package com.ikojic.demo;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author ikojic000
 *
 *         The Database class provides methods for connecting and disconnecting
 *         from a MySQL database, as well as accessing the database connection
 *         and configuration properties. The class is a singleton, meaning that
 *         only one instance of the class can be created and accessed throughout
 *         the entire application, and the constructor is private to prevent
 *         instantiation of the class outside of the class definition. The class
 *         uses the JDBC API to establish a connection with a MySQL database,
 *         and reads the necessary configuration properties from a
 *         config.properties file.
 *
 */
public class Database {
	
	private static Connection connection;
	private static Database database = new Database();
	
	/**
	 *
	 * Constructs a new Database object, which automatically calls the connect()
	 * method to establish a connection with the database upon instantiation.
	 */
	public Database() {
		
		connect();
		
	}
	
	
	/**
	 *
	 * Establishes a connection to the database by using the JDBC API, and the
	 * necessary configuration properties read from a config.properties file. Upon
	 * successful connection, the method outputs "DB Connected" to the console,
	 * otherwise it outputs the error message to the console.
	 */
	public static void connect() {
		
		try {
			
			connection = DriverManager.getConnection( getDatabaseURL() , getDatabaseUsername() ,
					getDatabasePassword() );
			System.out.println( "DB Connected" );
			
		} catch ( SQLException e ) {
			
			System.out.println( e.getMessage() );
			
		} finally {
			
			try {
				
				if ( connection == null ) {
					
					connection.close();
					
				}
				
			} catch ( SQLException e2 ) {
				
				System.out.println( e2.getMessage() );
				
			}
			
		}
		
	}
	
	
	/**
	 *
	 * Closes the database connection. Upon successful closure, the method outputs
	 * "DB Disconnected" to the console, otherwise it outputs the error message to
	 * the console.
	 */
	public void closeConnection() {
		
		if ( connection != null ) {
			
			try {
				
				connection.close();
				System.out.println( "DB Disconnected" );
				
			} catch ( SQLException e ) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	
	/**
	 *
	 * Retrieves Database URL from the config.properties file.
	 *
	 * @return URL- URL to access the database.
	 */
	private static String getDatabaseURL() {
		
		String url = null;
		Properties prop = new Properties();
		ClassLoader loader = Database.class.getClassLoader();
		
		try {
			
			InputStream stream = loader.getResourceAsStream( "config.properties" );
			prop.load( stream );
			url = prop.getProperty( "DatabaseURL" );
			
		} catch ( IOException ex ) {
			
			ex.printStackTrace();
			
		}
		
		return url;
		
	}
	
	
	/**
	 *
	 * Retrieves the username from the config.properties file.
	 *
	 * @return username - The username to access the database.
	 */
	private static String getDatabaseUsername() {
		
		String username = null;
		Properties prop = new Properties();
		ClassLoader loader = Database.class.getClassLoader();
		
		try {
			
			InputStream stream = loader.getResourceAsStream( "config.properties" );
			prop.load( stream );
			username = prop.getProperty( "DatabaseUsername" );
			
		} catch ( IOException ex ) {
			
			ex.printStackTrace();
			
		}
		
		return username;
		
	}
	
	
	/**
	 *
	 * Retrieves the password from the config.properties file.
	 *
	 * @return password - The password to access the database.
	 */
	private static String getDatabasePassword() {
		
		String password = null;
		Properties prop = new Properties();
		ClassLoader loader = Database.class.getClassLoader();
		
		try {
			
			InputStream stream = loader.getResourceAsStream( "config.properties" );
			prop.load( stream );
			password = prop.getProperty( "DatabasePassword" );
			
		} catch ( IOException ex ) {
			
			ex.printStackTrace();
			
		}
		
		return password;
		
	}
	
	
	/**
	 *
	 * Retrieves the current database connection.
	 *
	 * @return connection - The current database connection.
	 */
	public Connection getConnection() {
		
		return connection;
		
	}
	
	
	/**
	 *
	 * Returns the single instance of the Database class. If the instance is null,
	 * it creates a new instance of the Database class in a thread-safe manner using
	 * double-checked locking. This method ensures that only one instance of the
	 * Database class is created while the application is running.
	 *
	 * @return the single instance of the Database class.
	 */
	public static Database getDatabase() {
		
		if ( database == null ) {
			
			synchronized ( Database.class ) {
				
				if ( database == null ) {
					
					database = new Database();
					
				}
				
			}
			
		}
		
		return database;
		
	}
	
}
