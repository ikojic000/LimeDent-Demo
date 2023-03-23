package com.ikojic.demo;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 *
 * @author ikojic000
 *
 *         The Patient class represents a patient in a medical system, including
 *         personal and medical information. The class provides constructors to
 *         create patient objects with various combinations of information, and
 *         getters and setters to access and modify the patient's properties.
 * 		
 */
public class Patient {
	
	private Integer id;
	private String name;
	private Long oib;
	private Long jmbg;
	private String address;
	private String city;
	private String phone;
	private String mail;
	private LocalDateTime lastExam;
	private String medicalHistory;
	private String alergies;
	private ImageIcon profilePhoto;
	
	/**
	 *
	 * Constructs a patient object with the given id.
	 *
	 * @param id the patient's unique identifier
	 */
	public Patient( Integer id ) {
		
		this.id = id;
		
	}
	
	
	/**
	 *
	 * Constructs a patient object with the given id and name.
	 *
	 * @param id   the patient's unique identifier
	 * @param name the patient's name
	 */
	public Patient( Integer id , String name ) {
		
		this.id = id;
		this.name = name;
		
	}
	
	
	/**
	 *
	 * Constructs a patient object with the given id, name, OIB, phone, email, and
	 * date of last exam.
	 *
	 * @param id       the patient's unique identifier
	 * @param name     the patient's name
	 * @param oib      the patient's OIB
	 * @param phone    the patient's phone number
	 * @param mail     the patient's email address
	 * @param lastExam the date and time of the patient's last medical exam
	 */
	public Patient( Integer id , String name , Long oib , String phone , String mail , LocalDateTime lastExam ) {
		
		this.id = id;
		this.name = name;
		this.oib = oib;
		this.phone = phone;
		this.mail = mail;
		this.lastExam = lastExam;
		
	}
	
	
	/**
	 *
	 * Constructs a patient object with the given id, name, OIB, JMBG, email, phone,
	 * address, city, medical history, allergies, and profile photo.
	 *
	 * @param id             the patient's unique identifier
	 * @param name           the patient's name
	 * @param oib            the patient's OIB
	 * @param jmbg           the patient's JMBG
	 * @param mail           the patient's email address
	 * @param phone          the patient's phone number
	 * @param address        the patient's address
	 * @param city           the patient's city of residence
	 * @param medicalHistory the patient's medical history
	 * @param alergies       the patient's allergies
	 * @param profilePhoto   the patient's profile photo
	 */
	public Patient( Integer id , String name , Long oib , Long jmbg , String mail , String phone , String address ,
					String city , String medicalHistory , String alergies , ImageIcon profilePhoto ) {
		
		this.id = id;
		this.name = name;
		this.oib = oib;
		this.jmbg = jmbg;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.mail = mail;
		this.medicalHistory = medicalHistory;
		this.alergies = alergies;
		this.profilePhoto = profilePhoto;
		
	}
	
	
	/**
	 *
	 * Constructs a patient object with the given id, name, OIB, JMBG, email, phone,
	 * address, city, medical history, allergies, and profile photo.
	 *
	 * @param id             the patient's unique identifier
	 * @param name           the patient's name
	 * @param oib            the patient's OIB
	 * @param jmbg           the patient's JMBG
	 * @param mail           the patient's email address
	 * @param phone          the patient's phone number
	 * @param address        the patient's address
	 * @param city           the patient's city of residence
	 * @param lastExam       the date and time of the patient's last medical exam
	 * @param medicalHistory the patient's medical history
	 * @param alergies       the patient's allergies
	 * @param profilePhoto   the patient's profile photo
	 */
	public Patient( Integer id , String name , Long oib , Long jmbg , String mail , String phone , String address ,
					String city , LocalDateTime lastExam , String medicalHistory , String alergies ,
					ImageIcon profilePhoto ) {
		
		this.id = id;
		this.name = name;
		this.oib = oib;
		this.jmbg = jmbg;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.mail = mail;
		this.lastExam = lastExam;
		this.medicalHistory = medicalHistory;
		this.alergies = alergies;
		this.profilePhoto = profilePhoto;
		
	}
	
	
	/**
	 *
	 * This method retrieves the ID of the patient.
	 *
	 * @return the ID of the patient.
	 */
	public Integer getId() {
		
		return id;
		
	}
	
	
	/**
	 *
	 * This method sets the ID of the patient.
	 *
	 * @param id the ID to be set.
	 */
	public void setId( Integer id ) {
		
		this.id = id;
		
	}
	
	
	/**
	 *
	 * This method retrieves the name of the patient.
	 *
	 * @return the name of the patient.
	 */
	public String getName() {
		
		return name;
		
	}
	
	
	/**
	 *
	 * This method sets the name of the patient.
	 *
	 * @param name the name to be set.
	 */
	public void setName( String name ) {
		
		this.name = name;
		
	}
	
	
	/**
	 *
	 * This method retrieves the OIB of the patient.
	 *
	 * @return the OIB of the patient.
	 */
	public Long getOib() {
		
		return oib;
		
	}
	
	
	/**
	 *
	 * This method sets the OIB of the patient.
	 *
	 * @param oib the OIB to be set.
	 */
	public void setOib( Long oib ) {
		
		this.oib = oib;
		
	}
	
	
	/**
	 *
	 * This method retrieves the JMBG of the patient.
	 *
	 * @return the JMBG of the patient.
	 */
	public Long getJmbg() {
		
		return jmbg;
		
	}
	
	
	/**
	 *
	 * This method sets the JMBG of the patient.
	 *
	 * @param jmbg the JMBG to be set.
	 */
	public void setJmbg( Long jmbg ) {
		
		this.jmbg = jmbg;
		
	}
	
	
	/**
	 *
	 * This method retrieves the address of the patient. If the address is null, an
	 * empty string is returned.
	 *
	 * @return the address of the patient.
	 */
	public String getAddress() {
		
		if ( address == null ) {
			
			setAddress( "" );
			
		}
		
		return address;
		
	}
	
	
	/**
	 *
	 * This method sets the address of the patient.
	 *
	 * @param address the address to be set.
	 */
	public void setAddress( String address ) {
		
		this.address = address;
		
	}
	
	
	/**
	 *
	 * This method retrieves the city of the patient. If the city is null, an empty
	 * string is returned.
	 *
	 * @return the city of the patient.
	 */
	public String getCity() {
		
		if ( city == null ) {
			
			setCity( "" );
			
		}
		
		return city;
		
	}
	
	
	/**
	 *
	 * This method sets the city of the patient.
	 *
	 * @param city the city to be set.
	 */
	public void setCity( String city ) {
		
		this.city = city;
		
	}
	
	
	/**
	 *
	 * This method retrieves the phone number of the patient.
	 *
	 * @return the phone number of the patient.
	 */
	public String getPhone() {
		
		return phone;
		
	}
	
	
	/**
	 *
	 * This method sets the phone number of the patient.
	 *
	 * @param phone the phone number to be set.
	 */
	public void setPhone( String phone ) {
		
		this.phone = phone;
		
	}
	
	
	/**
	 *
	 * This method retrieves the email of the patient.
	 *
	 * @return the email of the patient.
	 */
	public String getMail() {
		
		return mail;
		
	}
	
	
	/**
	 *
	 * This method sets the email of the patient.
	 *
	 * @param mail the email to be set.
	 */
	public void setMail( String mail ) {
		
		this.mail = mail;
		
	}
	
	
	/**
	 *
	 * This method retrieves the date and time of the last exam for the patient.
	 *
	 * @return the date and time of the last exam.
	 */
	public LocalDateTime getLastExam() {
		
		return lastExam;
		
	}
	
	
	/**
	 *
	 * This method retrieves the formatted date and time of the last exam for the
	 * patient. If the last exam is null, an empty string is returned.
	 *
	 * @return the formatted date and time of the last exam.
	 */
	public String getLastExamFormatted() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm" );
		
		if ( getLastExam() != null ) {
			
			return getLastExam().format( formatter );
			
		}
		
		return "";
		
	}
	
	
	/**
	 *
	 * Sets the last examination date for this patient.
	 *
	 * @param lastExam The LocalDateTime object representing the date of the last
	 *                 examination.
	 */
	public void setLastExam( LocalDateTime lastExam ) {
		
		this.lastExam = lastExam;
		
	}
	
	
	/**
	 *
	 * Gets the medical history of this patient. If the medical history is null,
	 * sets it to an empty string before returning it.
	 *
	 * @return The medical history of this patient.
	 */
	public String getMedicalHistory() {
		
		if ( medicalHistory == null ) {
			
			setMedicalHistory( "" );
			
		}
		
		return medicalHistory;
		
	}
	
	
	/**
	 *
	 * Sets the medical history of this patient.
	 *
	 * @param medicalHistory The medical history to set for this patient.
	 */
	public void setMedicalHistory( String medicalHistory ) {
		
		this.medicalHistory = medicalHistory;
		
	}
	
	
	/**
	 *
	 * Gets the allergies of this patient. If the allergies are null, sets them to
	 * an empty string before returning them.
	 *
	 * @return The allergies of this patient.
	 */
	public String getAlergies() {
		
		if ( alergies == null ) {
			
			setAlergies( "" );
			
		}
		
		return alergies;
		
	}
	
	
	/**
	 *
	 * Sets the allergies of this patient.
	 *
	 * @param alergies The allergies to set for this patient.
	 */
	public void setAlergies( String alergies ) {
		
		this.alergies = alergies;
		
	}
	
	
	/**
	 *
	 * Gets the profile photo of this patient.
	 *
	 * @return The ImageIcon object representing the profile photo of this patient.
	 */
	public ImageIcon getProfilePhoto() {
		
		return profilePhoto;
		
	}
	
	
	/**
	 *
	 * Sets the profile photo of this patient.
	 *
	 * @param profilePhoto The ImageIcon object representing the profile photo to
	 *                     set for this patient.
	 */
	public void setProfilePhoto( ImageIcon profilePhoto ) {
		
		this.profilePhoto = profilePhoto;
		
	}
	
	
	/**
	 *
	 * Indicates whether some other object is "equal to" this one. Two objects are
	 * considered equal if they are both instances of the {@code Patient} class, and
	 * all of their corresponding properties have equal values (including the
	 * profile photo, which is compared byte by byte).
	 *
	 * @param obj the reference object with which to compare
	 * @return {@code true} if this object is equal to the obj argument or
	 *         {@code false} otherwise
	 */
	@Override
	public boolean equals( Object obj ) {
		
		if ( this == obj )
			return true;
		if ( obj == null || getClass() != obj.getClass() )
			return false;
		
		Patient other = (Patient) obj;
		
		return Objects.equals( name , other.name ) && Objects.equals( oib , other.oib )
				&& Objects.equals( jmbg , other.jmbg ) && Objects.equals( address , other.address )
				&& Objects.equals( city , other.city ) && Objects.equals( phone , other.phone )
				&& Objects.equals( mail , other.mail ) && Objects.equals( medicalHistory , other.medicalHistory )
				&& Objects.equals( lastExam , other.lastExam ) && compareImageByte( profilePhoto , other.profilePhoto );
		
	}
	
	
	/**
	 *
	 * Compares two image icons byte by byte to determine whether they have the same
	 * content.
	 *
	 * @param img  the first image icon to compare
	 * @param img2 the second image icon to compare
	 * @return {@code true} if the image icons have the same byte content;
	 *         {@code false} otherwise
	 */
	private boolean compareImageByte( ImageIcon img , ImageIcon img2 ) {
		
		byte[] imageBytes1 = getPhotoBytes( img );
		byte[] imageBytes2 = getPhotoBytes( img2 );
		
		return Arrays.equals( imageBytes1 , imageBytes2 );
		
	}
	
	
	/**
	 *
	 * Converts a profile photo to a byte array.
	 *
	 * @param profile - the profile photo to convert
	 *
	 * @return a byte array containing the profile photo data
	 */
	private byte[] getPhotoBytes( ImageIcon img ) {
		
		if ( img == null ) {
			
			return null;
			
		}
		
		try {
			
			BufferedImage image = new BufferedImage( img.getIconWidth() , img.getIconHeight() ,
					BufferedImage.TYPE_INT_RGB );
			Graphics g = image.createGraphics();
			img.paintIcon( null , g , 0 , 0 );
			g.dispose();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( image , "jpg" , baos );
			baos.flush();
			byte[] profilePhotoBytes = baos.toByteArray();
			baos.close();
			return profilePhotoBytes;
			
		} catch ( IOException e ) {
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
	
	/**
	 *
	 * Returns a String representation of this patient object.
	 *
	 * @return The String representation of this patient object.
	 */
	@Override
	public String toString() {
		
		return "Patient [id=" + id + ", name=" + name + ", oib=" + oib + ", jmbg=" + jmbg + ", address=" + address
				+ ", city=" + city + ", phone=" + phone + ", mail=" + mail + ", zadnji pregled=" + lastExam
				+ ", medicalHistory=" + medicalHistory + ", alergies=" + alergies + ", profilePhoto=" + profilePhoto
				+ "]";
		
	}
	
}
