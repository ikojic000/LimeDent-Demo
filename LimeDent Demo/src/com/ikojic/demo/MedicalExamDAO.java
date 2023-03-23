package com.ikojic.demo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.MedicalExam;


/**
 *
 * @author ikojic000
 *
 *         The MedicalExamDAO class provides methods for accessing and
 *         manipulating medical exams stored in the database.
 * 		
 */
public class MedicalExamDAO {
	
	/**
	 *
	 * Constructs a new MedicalExamDAO object.
	 */
	public MedicalExamDAO() {
		
	}
	
	
	/**
	 *
	 * Retrieves all medical exams belonging to a specific patient from the
	 * database.
	 *
	 * @param patient the patient whose medical exams to retrieve
	 * @return an ArrayList of MedicalExam objects representing the patient's
	 *         medical exams
	 */
	public ArrayList<MedicalExam> getAllExamsByPatientID( Patient patient ) {
		
		ArrayList<MedicalExam> allExams = new ArrayList<>();
		
		String sql = "select me.id, me.info, me.idPatient, me.idDoctor, CONCAT(u.ime, ' ', u.prezime) as doctorName, p.imePrezime as patientName, me.date "
				+ "from medicalexam me " + "inner join patients p on p.id = me.idPatient "
				+ "inner join users u on u.id = me.idDoctor " + "where me.idPatient = ? order by me.date desc;";
		
		Connection connection = Database.getDatabase().getConnection();
		
		try {
			
			PreparedStatement pst = connection.prepareStatement( sql );
			pst.setInt( 1 , patient.getId() );
			ResultSet rs = pst.executeQuery();
			
			while ( rs.next() ) {
				
				allExams.add( new MedicalExam( rs.getInt( "id" ) , rs.getString( "info" ) , rs.getInt( "idDoctor" ) ,
						rs.getString( "doctorName" ) , rs.getInt( "idPatient" ) , rs.getString( "patientName" ) ,
						rs.getTimestamp( "date" ).toLocalDateTime() ) );
				
			}
			
			pst.close();
			
		} catch ( SQLException e ) {
			
		}
		
		return allExams;
		
	}
	
	
	/**
	 *
	 * Deletes a medical exam from the database.
	 *
	 * @param exam the MedicalExam object to delete
	 */
	public void deleteExam( MedicalExam exam ) {
		
		String sql = "delete from medicalexam where id = ?;";
		
		Connection connection = Database.getDatabase().getConnection();
		
		try {
			
			PreparedStatement pst = connection.prepareStatement( sql );
			pst.setInt( 1 , exam.getId() );
			pst.executeUpdate();
			pst.close();
			
		} catch ( SQLException e ) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	/**
	 *
	 * Adds a new medical exam to the database.
	 *
	 * @param exam    the MedicalExam object to add
	 * @param patient the patient to whom the medical exam belongs
	 * @return an ArrayList of MedicalExam objects representing the patient's
	 *         updated medical exams
	 */
	public ArrayList<MedicalExam> addExam( MedicalExam exam , Patient patient ) {
		
		String sql = "insert into medicalexam (info, idDoctor, idPatient) values (?, ?, ?);";
		
		Connection connection = Database.getDatabase().getConnection();
		
		try {
			
			PreparedStatement pst = connection.prepareStatement( sql );
			pst.setString( 1 , exam.getInfo() );
			pst.setInt( 2 , exam.getIdDoctor() );
			pst.setInt( 3 , exam.getIdPatient() );
			pst.executeUpdate();
			pst.close();
			
		} catch ( SQLException e ) {
			
			e.printStackTrace();
			
		}
		
		return getAllExamsByPatientID( patient );
		
	}
	
}
