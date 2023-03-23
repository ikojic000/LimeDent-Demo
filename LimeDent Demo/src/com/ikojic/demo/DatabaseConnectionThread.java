package com.ikojic.demo;


import java.sql.SQLException;


/**
 *
 * @author ikojic000
 *
 *         The DatabaseConnectionThread class is a thread that runs in the
 *         background and periodically checks the status of the database
 *         connection. If the connection is closed, it attempts to reconnect to
 *         the database. This class extends the Thread class and overrides the
 *         run() method to implement the connection checking functionality.
 * 		
 */
public class DatabaseConnectionThread extends Thread {
	
	private final static int SLEEP_TIME = 15 * 1000;
	private boolean running;
	private Database database;
	
	/**
	 *
	 * Constructor that initializes the instance variables
	 */
	public DatabaseConnectionThread() {
		
		running = true;
		database = Database.getDatabase();
		
	}
	
	
	/**
	 *
	 * Sets the running to false, which will cause the thread to stop running
	 */
	public void stopThread() {
		
		running = false;
		
	}
	
	
	/**
	 *
	 * The run() method is called when the thread is started, and it contains the
	 * logic for checking the database connection status and attempting to reconnect
	 * if necessary.
	 */
	@SuppressWarnings( "static-access" )
	@Override
	public void run() {
		
		Thread.currentThread().setName( "Database Connection Thread" );
		
		while ( running ) {
			
			try {
				
				if ( database.getConnection().isClosed() ) {
					
					System.out.println( "Database disconnected...Trying to connect again" );
					Database.connect();
					
				} else {
					
					System.out.println( "Database connected...Running on thread " + Thread.currentThread().getName() );
					
				}
				
				Thread.sleep( SLEEP_TIME );
				
			} catch ( InterruptedException | SQLException e ) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
}
