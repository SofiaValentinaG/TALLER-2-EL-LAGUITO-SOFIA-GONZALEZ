package co.edu.uptc.clinic.repository;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import co.edu.uptc.clinic.domain.Doctor;

public class DoctorRepository {
	
	private Set<Doctor> doctors;

	public DoctorRepository(Set<Doctor> doctors) {
		super();
		this.doctors = new HashSet<>();
	}
	
	public boolean addDoctor(Doctor doctor) {
		return this.doctors.add(doctor);
				
	}
	public Set <Doctor> findAll(){
		return this.doctors;
	}
	
	public Doctor findDoctorById(int idDoctor) {
		for(Doctor i:this.doctors) {
			if(i.getMedicalId()== idDoctor) {
				return i;
			}
		}
		return null;
		
	    }
	 public boolean updateDoctor(Doctor newDoctor) {
		 
		 Doctor oldDoctor= this.findDoctorById(newDoctor.getMedicalId());
		 if(!Objects.isNull(oldDoctor)) {
			 
				if(Objects.isNull(newDoctor.getFirstName())) {
					newDoctor.setFirstName(oldDoctor.getFirstName());
				}
				if(Objects.isNull(newDoctor.getLastName())) {
					newDoctor.setLastName(oldDoctor.getLastName());
				}
				
				if(Objects.isNull(newDoctor.getSpeciality())) {
					newDoctor.setSpeciality(oldDoctor.getSpeciality());
				}
				if(Objects.isNull(newDoctor.getIdentificationType())) {
					newDoctor.setIdentificationType(oldDoctor.getIdentificationType());
					
				}
				if(Objects.isNull(newDoctor.getYearsOfExperience())) {
					newDoctor.setYearsOfExperience(oldDoctor.getYearsOfExperience());
					
				}
				
				
				this.doctors.add(newDoctor);
				this.doctors.remove(oldDoctor);
				
				return true;
			 
		 }
		 return false;
		 
		 
	 }
	 
	 
	 public boolean delete(int medicalId) {
		    return this.doctors.removeIf(doctor -> 
		        doctor.getMedicalId() == medicalId);
		}
	}
	



