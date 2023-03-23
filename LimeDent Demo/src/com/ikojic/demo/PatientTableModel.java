package com.ikojic.demo;


import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


/**
 *
 * @author ikojic000
 *
 *         This class extends the AbstractTableModel class to implement a table
 *         model for patient data. The PatientTableModel class is used to
 *         display patient information in a JTable component. The table model
 *         contains a list of patients, and each row represents a single
 *         patient. The columns of the table represent different attributes of a
 *         patient, such as their ID, name, phone number, and the date of their
 *         last examination. The table is designed to be read-only, so the
 *         isCellEditable method always returns false. The PatientTableModel
 *         class provides methods for getting and setting the list of patients,
 *         and updating the table when the data changes.
 * 		
 */
public class PatientTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 6428592596661339727L;
	ArrayList<Patient> patientList;
	private String[] columnNames = { "ID" , "Ime i prezime" , "OIB" , "Mobitel" , "Mail" , "Zadnji pregled" };
	boolean[] canEdit = new boolean[] { false , false , false , false , false , false };
	
	/**
	 *
	 * Constructs a new PatientTableModel with the given list of patients.
	 *
	 * @param patientList the list of patients to be displayed in the table
	 */
	public PatientTableModel( ArrayList<Patient> patientList ) {
		
		this.patientList = patientList;
		
	}
	
	
	/**
	 *
	 * Returns the number of rows in the table, which is equal to the size of the
	 * patient list.
	 *
	 * @return the number of rows in the table
	 */
	@Override
	public int getRowCount() {
		
		return patientList.size();
		
	}
	
	
	/**
	 *
	 * Returns the number of columns in the table.
	 *
	 * @return the number of columns in the table
	 */
	@Override
	public int getColumnCount() {
		
		return columnNames.length;
		
	}
	
	
	/**
	 *
	 * Returns the name of the specified column in the table.
	 *
	 * @param column the index of the column
	 * @return the name of the column
	 */
	@Override
	public String getColumnName( int column ) {
		
		return columnNames[column];
		
	}
	
	
	/**
	 *
	 * Returns a boolean value indicating whether a cell is editable or not.
	 *
	 * @param rowIndex    the row index of the cell
	 * @param columnIndex the column index of the cell
	 * @return a boolean value indicating whether a cell is editable or not
	 */
	@Override
	public boolean isCellEditable( int rowIndex , int columnIndex ) {
		
		return canEdit[columnIndex];
		
	}
	
	
	/**
	 *
	 * Returns the value at the specified row and column in the table.
	 *
	 * @param rowIndex    the row index of the cell
	 * @param columnIndex the column index of the cell
	 * @return the value at the specified row and column in the table
	 */
	@Override
	public Object getValueAt( int rowIndex , int columnIndex ) {
		
		Patient patient = patientList.get( rowIndex );
		
		switch (columnIndex) {
			
			case 0:
				return patient.getId();
			
			case 1:
				return patient.getName();
			
			case 2:
				return patient.getOib();
			
			case 3:
				return patient.getPhone();
			
			case 4:
				return patient.getMail();
			
			case 5:
				return patient.getLastExamFormatted();
			
			default:
				return null;
			
		}
		
	}
	
	
	/**
	 *
	 * Returns the list of Patient objects stored in the table model.
	 *
	 * @return the list of Patient objects stored in the table model
	 */
	public ArrayList<Patient> getPatientList() {
		
		return patientList;
		
	}
	
	
	/**
	 *
	 * Sets the list of Patient objects stored in the table model and fires a table
	 * data change event.
	 *
	 * @param patientList - the list of Patient objects to be set
	 */
	public void setPatientList( ArrayList<Patient> patientList ) {
		
		this.patientList = patientList;
		fireTableDataChanged();
		
	}
	
}
