package co.edu.uptc.clinic.service;


import java.util.Objects;
import java.util.Set;


import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.repository.PatientRepository;

public class PatientService {
	private PatientRepository patientRepository;

	public PatientService() {
		
		this.patientRepository = new PatientRepository();
	}
	
	public boolean validatePatient(Patient patient) {
		if( patient == null) {
			System.out.println("Ingrese un paciente valido");
			return false;
		}
		else if(patient.getFirstName() == null|| patient.getLastName()== null) {
			return false;
			
		}
		
		return true;
		
	}
	
	
	public boolean addDoctor(Patient patient) {
		if(this.validatePatient(patient)) {
			return this.patientRepository.addPatient(patient);
		}
		return false;
		
	}
	
	
	public Set<Patient> findAll(){
		
		
		return this.patientRepository.findAll();
	}
	
	public Patient findById(int patientId) {
		if(patientId < 1) {
			return null;
			}
	
		return this.patientRepository.findPatientById(patientId);
	}
	
	public boolean updatePatient(Patient newPatient) {
		if(this.validatePatient(newPatient)) {
			Patient oldPatient= this.patientRepository.findPatientById(newPatient.getIdPatient());
			if(!Objects.isNull(oldPatient)) {
				this.patientRepository.updatePatient(newPatient);
				return true;
			}
			return false;
		}
		return false;
	}

	
	public boolean deletePatient(int patientId) {
		if(patientId < 1) {
			return false;
			}
		return this.patientRepository.delete(patientId);
	      
	}
	
}
