package co.edu.uptc.clinic.domain;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import co.edu.uptc.clinic.enums.*;

public class Patient {
	private IdentificationType identificationType;
	private int idPatient;
	private String firstName;
	private String LastName;
	private String email;
	private Set<String> medicationHistory;
	private Priority priority;
	
	public Patient(IdentificationType identificationType, int idPatient, String firstName, String lastName,String email,
		Priority priority) {
		super();
		this.identificationType = identificationType;
		this.idPatient = idPatient;
		this.firstName = firstName;
		this.LastName = lastName;
		this.email=email;
		this.medicationHistory = new LinkedHashSet<>();
		this.priority = priority;
	}

	public IdentificationType getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(IdentificationType identificationType) {
		this.identificationType = identificationType;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Set<String> getMedicationHistory() {
		return medicationHistory;
	}

	public void setMedicationHistory(Set<String> medicationHistory) {
		this.medicationHistory = medicationHistory;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(this.identificationType,this.idPatient);
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		Patient auxPatient = (Patient) obj;
		if(auxPatient.getIdentificationType().equals(this.identificationType) && auxPatient.getIdPatient()== this.idPatient && auxPatient.getEmail().equals(this.email)) {
			return true;
			
		}
		else {
		   return false;
		}
	}

	@Override
	public String toString() {
		
		    return "=== PATIENT ===" +
		           "• ID: " + identificationType + " - " + idPatient + "\n" +
		           "• Name: " + firstName + " " + LastName + "\n" +
		           "• Email: " + email + "\n" +
		           "• Priority: " + priority + "\n" +
		           "• Medication History: " + (medicationHistory.isEmpty() ? "None" : medicationHistory) + "\n" +
		           "====================";
		
	}
	 
	
	
	

}
