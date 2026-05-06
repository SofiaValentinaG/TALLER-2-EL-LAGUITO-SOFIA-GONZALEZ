package co.edu.uptc.clinic.domain;

import java.util.Objects;

import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
/** 
 * <b>Descripción: </b> Clase de modelo que representa
 * la información de un doctor dentro del sistema de la clínica <br>
 * 
 * Permite almacenar información personal, profesional y realizar
 * comparaciones entre doctores según su experiencia.
 * 
 * @author Sofia
*/
public class Doctor implements Comparable <Doctor>{
	 /** Atributo que determina el tipo de identificación del doctor es enum */
	private IdentificationTypeEnum identificationType;
	 /** Atributo que determina el identificador del doctor */
	private int medicalId;
	  /** Atributo que determina el nombre del doctor */
	private String firstName;
	  /** Atributo que determina el apellido del doctor */
	private String lastName;
    /** Atributo que determina la especialidad médica */
	private String speciality;
	 /** Atributo que determina los años de experiencia */
	private int yearsOfExperience;
	 /**
     * <b>Description: </b> Constructor de la clase <br>
     * @param identificationType Parámetro que determina el tipo de identificación
     * @param medicalId Parámetro que determina el ID del doctor
     * @param firstName Parámetro que determina el nombre
     * @param lastName Parámetro que determina el apellido
     * @param speciality Parámetro que determina la especialidad
     * @param yearsOfExperience Parámetro que determina los años de experiencia
     */
	public Doctor(IdentificationTypeEnum identificationType, int medicalId, String firstName, String lastName,
			String speciality, int yearsOfExperience) {
		super();
		this.identificationType = identificationType;
		this.medicalId = medicalId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.speciality = speciality;
		this.yearsOfExperience = yearsOfExperience;
	}
	  /**
     * <b>Description: </b> Retorna el tipo de identificación del doctor
     * @return identificationType Tipo de identificación
     */
	public IdentificationTypeEnum getIdentificationType() {
		return identificationType;
	}
    /**
     * <b>Description: </b> Asigna un nuevo tipo de identificación <br>
     * @param identificationType Nuevo tipo de identificación
     */
	public void setIdentificationType(IdentificationTypeEnum identificationType) {
		
		this.identificationType = identificationType;
	}
	 /**
     * <b>Description: </b> Retorna el ID del doctor
     * @return medicalId Identificador del doctor
     */
	public int getMedicalId() {
		return medicalId;
	}
	/**
     * <b>Description: </b> Asigna un nuevo ID <br>
     * @param medicalId Nuevo identificador
     */
	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}
	/**
     * <b>Description: </b> Retorna el nombre del doctor
     * @return firstName Nombre
     */
	public String getFirstName() {
		return firstName;
	}
	 /**
     * <b>Description: </b> Asigna un nuevo nombre <br>
     * @param firstName Nuevo nombre
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
     * <b>Description: </b> Retorna el apellido del doctor
     * @return lastName Apellido
     */
	public String getLastName() {
		return lastName;
	}
	  /**
     * <b>Description: </b> Asigna un nuevo apellido <br>
     * @param lastName Nuevo apellido
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	 /**
     * <b>Description: </b> Retorna la especialidad del doctor
     * @return speciality Especialidad
     */
	public String getSpeciality() {
		return speciality;
	}
	/**
     * <b>Description: </b> Asigna una nueva especialidad <br>
     * @param speciality Nueva especialidad
     */
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	 /**
     * <b>Description: </b> Retorna los años de experiencia
     * @return yearsOfExperience Años de experiencia
     */
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
    /**
     * <b>Description: </b> Asigna nuevos años de experiencia <br>
     * @param yearsOfExperience Nuevos años de experiencia
     */
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	  /**
     * <b>Description: </b> Calcula el hash del objeto
     * @return valor hash basado en ID y tipo de identificación
     */
	
	@Override
	public int hashCode() {
		
		return Objects.hash(this.identificationType,this.medicalId);
	}
	 /**
     * <b>Description: </b> Compara si dos doctores son iguales <br>
     * @param obj Objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		Doctor auxDoctor = (Doctor) obj;
		return auxDoctor.getIdentificationType().equals(this.identificationType) && auxDoctor.getMedicalId()== this.medicalId;  
			
	
	}
    /**
     * <b>Description: </b> Compara doctores por experiencia y nombre <br>
     * @param other Doctor a comparar
     * @return valor negativo, positivo o cero según el orden
     */

	@Override
	public int compareTo(Doctor other) {
		  int compareExp = this.yearsOfExperience - other.yearsOfExperience;

		    if (compareExp != 0) {
		        return compareExp;
		    }

		    return this.getFirstName().compareTo(other.getFirstName());
	}

    /**
     * <b>Description: </b> Retorna una representación en texto del doctor
     * @return Información del doctor en formato legible
     */
	@Override
	public String toString() {
	    return "\n=== DOCTOR ===\n" +
	           "• ID: " + medicalId + "\n" +
	           "• Tipo ID: " + identificationType + "\n" +
	           "• Nombre: " + firstName + " " + lastName + "\n" +
	           "• Especialidad: " + speciality + "\n" +
	           "• Años de experiencia: " + yearsOfExperience + "\n" +
	           "====================";
	}


}
