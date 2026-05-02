package co.edu.uptc.clinic.repository;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import co.edu.uptc.clinic.domain.Patient;

public class PatientRepository {
	
	private Set<Patient> patients;

	public PatientRepository(Set<Patient> doctors) {
		super();
		this.patients= new HashSet<>();
	}
	
	public boolean addPatient(Patient patient) {
		return this.patients.add(patient);
				
	}
	public Set <Patient> findAll(){
		return this.patients;
	}
	
	public Patient findPatientById(int idPatient) {
		for(Patient i:this.patients) {
			if(i.getIdPatient()==idPatient) {
				return i;
			}
		}
		return null;
		
	    }
	 public boolean updatePatient(Patient newPatient) {
		 
		 Patient oldPatient= this.findPatientById(newPatient.getIdPatient());
		 if(!Objects.isNull(oldPatient)) {
			 
				if(Objects.isNull(newPatient.getFirstName())) {
					newPatient.setFirstName(oldPatient.getFirstName());
				}
				if(Objects.isNull(newPatient.getLastName())) {
					newPatient.setLastName(oldPatient.getLastName());
				}
				
				if(Objects.isNull(newPatient.getEmail())) {
					newPatient.setEmail(oldPatient.getEmail());
				}
				if(Objects.isNull(newPatient.getIdentificationType())) {
					newPatient.setIdentificationType(oldPatient.getIdentificationType());
					
				}
				if(Objects.isNull(newPatient.getMedicationHistory())) {
					newPatient.setMedicationHistory(oldPatient.getMedicationHistory());
					
				}
				
				
				this.patients.add(newPatient);
				this.patients.remove(oldPatient);
				
				return true;
			 
		 }
		 return false;
		 
		 
	 }
	 
	 
	 public boolean delete(int idPatient) {
		    return this.patients.removeIf(patient -> 
		        patient.getIdPatient() == idPatient);
		}
	}
	