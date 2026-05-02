package co.edu.uptc.clinic.service;

import java.util.Objects;
import java.util.Set;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.repository.DoctorRepository;

public class DoctorService {
	
	private DoctorRepository doctorRepository;

	public DoctorService() {
		
		this.doctorRepository = new DoctorRepository();
		
	}
	
	public boolean validateDoctor(Doctor doctor) {
		
		if( doctor == null) {
			System.out.println("Ingrese un doctor valido");
			return false;
		}
		else if(doctor.getFirstName() == null|| doctor.getLastName()== null) {
			return false;
			
		}
		
		return true;
		
	}
	public boolean addDoctor(Doctor doctor) {
		if(this.validateDoctor(doctor)) {
			return this.doctorRepository.addDoctor(doctor);
		}
		return false;
		
	}
	
	public Set<Doctor> findAll(){
		
		
		return this.doctorRepository.findAll();
	}
	
	public Doctor findById(int medicalId) {
		if(medicalId < 1) {
			return null;
			}
	
		return this.doctorRepository.findDoctorById(medicalId);
	}
	
	public boolean updateDoctor(Doctor newDoctor) {
		if(this.validateDoctor(newDoctor)) {
			Doctor oldDoctor= this.doctorRepository.findDoctorById(newDoctor.getMedicalId());
			if(!Objects.isNull(oldDoctor)) {
				this.doctorRepository.updateDoctor(newDoctor);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean deleteDoctor(int medicalId) {
		if(medicalId < 1) {
			return false;
			}
		return this.doctorRepository.delete(medicalId);
	      
	}
	
	
	
	

	}
