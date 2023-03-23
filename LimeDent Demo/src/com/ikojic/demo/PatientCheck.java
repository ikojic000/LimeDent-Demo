package com.ikojic.demo;


import java.util.ArrayList;


/**
 *
 * @author ikojic000
 *
 *         A class representing a thread that periodically checks if there are
 *         any changes in the list of patients stored in the application
 *         database compared to the list of patients displayed in the GUI, and
 *         updates the GUI accordingly.
 * 		
 */
public class PatientCheck extends Thread {
	
	private boolean running;
	private final static int SLEEP_TIME = 30 * 1000; // sleep time in milliseconds
	private HomeController homeController; // the controller for the home view of the application
	private ArrayList<Patient> databasePatients; // a list of patients stored in the application database
	
	/**
	 *
	 * Constructs a new instance of PatientCheck with the specified HomeController.
	 *
	 * @param homeController - the controller for the home view of the application
	 */
	public PatientCheck( HomeController homeController ) {
		
		running = true;
		this.homeController = homeController;
		
	}
	
	
	/**
	 *
	 * The main logic of the thread. It periodically checks if there are any changes
	 * in the list of patients stored in the application database compared to the
	 * list of patients displayed in the GUI, and updates the GUI accordingly.
	 */
	@Override
	public void run() {
		
		Thread.currentThread().setName( "PatientCheckThread" );
		System.out.println( "*** PatientCheckThread started on " + Thread.currentThread().getName() + "***" );
		
		try {
			
			System.out.println( "Patient Check Thread Sleeping" );
			Thread.sleep( SLEEP_TIME );
			
		} catch ( InterruptedException e ) {
			
			e.printStackTrace();
			
		}
		
		while ( running ) {
			
			try {
				
				System.out.println( "Thread " + Thread.currentThread().getName() + " checking the Patient list..." );
				
				isSameData( homeController.getPatientList() );
				
				Thread.sleep( SLEEP_TIME );
				
			} catch ( Exception e ) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	
	/**
	 *
	 * Checks if the list of patients stored in the application database is the same
	 * size as the list of patients displayed in the GUI. If the sizes are
	 * different, updates the GUI by calling the updatePatientList() method of the
	 * homeController. Otherwise, compares the individual patients in both lists and
	 * updates the GUI for each patient that has changed.
	 *
	 * @param controllerPatients - the list of patients displayed in the GUI
	 */
	private void isSameData( ArrayList<Patient> controllerPatients ) {
		
		databasePatients = homeController.getPatients();
		
		if ( controllerPatients.size() != databasePatients.size() ) {
			
			System.out.println( "Patients - Not same size" );
			homeController.updatePatientList();
			
		} else {
			
			System.out.println( "Patients - Same size" );
			System.out.println( "Checking individual patients" );
			
			for ( int i = 0; i < controllerPatients.size(); i++ ) {
				
				if ( controllerPatients.get( i ).equals( databasePatients.get( i ) ) ) {
					
				} else {
					
					System.out.println( "Patient to update - " + controllerPatients.get( i ).getName() );
					setNewPatientData( controllerPatients.get( i ) , databasePatients.get( i ) );
					
					homeController.setTableData();
					
				}
				
			}
			
		}
		
	}
	
	
	/**
	 *
	 * Updates the data of a patient displayed in the GUI with the data of the same
	 * patient stored in the application database.
	 *
	 * @param controllerPatient - the patient to update in the GUI
	 *
	 * @param databasePatient   - the patient to get data from in the application
	 *                          database
	 */
	private void setNewPatientData( Patient controllerPatient , Patient databasePatient ) {
		
		controllerPatient.setName( databasePatient.getName() );
		controllerPatient.setOib( databasePatient.getOib() );
		controllerPatient.setJmbg( databasePatient.getJmbg() );
		controllerPatient.setAddress( databasePatient.getAddress() );
		controllerPatient.setCity( databasePatient.getCity() );
		controllerPatient.setPhone( databasePatient.getPhone() );
		controllerPatient.setMail( databasePatient.getMail() );
		controllerPatient.setLastExam( databasePatient.getLastExam() );
		controllerPatient.setProfilePhoto( databasePatient.getProfilePhoto() );
		System.out.println( "Patient updated" );
		
	}
	
}
