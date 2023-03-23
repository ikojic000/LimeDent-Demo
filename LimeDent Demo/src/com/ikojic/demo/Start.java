package com.ikojic.demo;


import java.io.File;


/**
 * @author ikojic000
 * 
 *         Class for testing and demo purpose. All classes are similar to the
 *         original classes used in developing the app, but are changed for demo
 *         purpose.
 *
 */
public class Start {
	
	public static void main( String[] args ) {
		
		System.out.println( "App Start" );
		Patient patient = new Patient( 1 , "Test Test" );
		
		ImageCompressionThread compressionThread = new ImageCompressionThread(
				new File( "C:/Users/ikojic000/Pictures/Zagreb_Advent_2022/Finished/_MG_2161.jpg" ) , patient );
		
		compressionThread.start();
		
		try {
			
			compressionThread.join();
			
		} catch ( InterruptedException e ) {
			
			e.printStackTrace();
			
		}
		
		System.out.println( "Patient Name - " + patient.getName() );
		System.out.println( "Patient Photo - " + patient.getProfilePhoto() );
		
	}
	
}
