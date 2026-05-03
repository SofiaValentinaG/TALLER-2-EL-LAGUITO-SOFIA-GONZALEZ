package co.edu.uptc.clinic.domain;

import java.util.Objects;

import co.edu.uptc.clinic.enums.IdentificationTypeEnum;

public class Doctor implements Comparable <Doctor>{
	private IdentificationTypeEnum identificationType;
	private int medicalId;
	private String firstName;
	private String lastName;
	private String speciality;
	private int yearsOfExperience;
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
	public IdentificationTypeEnum getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(IdentificationTypeEnum identificationType) {
		this.identificationType = identificationType;
	}
	public int getMedicalId() {
		return medicalId;
	}
	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	
	@Override
	public int hashCode() {
		
		return Objects.hash(this.identificationType,this.medicalId);
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		Doctor auxDoctor = (Doctor) obj;
		return auxDoctor.getIdentificationType().equals(this.identificationType) && auxDoctor.getMedicalId()== this.medicalId;  
			
	
	}
	@Override
	public int compareTo(Doctor other) {
		  int compareExp = this.yearsOfExperience - other.yearsOfExperience;

		    if (compareExp != 0) {
		        return compareExp;
		    }

		    return this.getFirstName().compareTo(other.getFirstName());
	}



}
