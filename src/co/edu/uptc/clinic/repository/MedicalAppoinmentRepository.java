package co.edu.uptc.clinic.repository;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;


import co.edu.uptc.clinic.domain.MedicalAppoinment;


public class MedicalAppoinmentRepository {
	
	private Set <MedicalAppoinment> medicalAppoinments;

	public MedicalAppoinmentRepository() {
		
		this.medicalAppoinments = new TreeSet <>() ;
	}
	
	
	public boolean addMedicalAppoinments(MedicalAppoinment medicalAppoinment) {
		return this.medicalAppoinments.add(medicalAppoinment);
	}
	
	
	public Set <MedicalAppoinment> findAll(){
		return this.medicalAppoinments;
	}
	
	public MedicalAppoinment findById(int idMedicalAppoinment) {
		for(MedicalAppoinment i: this.medicalAppoinments) {
			if(i.getIdMedicalAppoiment()== idMedicalAppoinment) {
				return i;
				
			}
			
		}
		return null;
		
	}
	
	
    public boolean updateMedicalAppoinment(MedicalAppoinment newMedicalAppoinment) {
		 
		 MedicalAppoinment oldMedicalAppoinment= this.findById(newMedicalAppoinment.getIdMedicalAppoiment());
		 if(!Objects.isNull(oldMedicalAppoinment)) {
			 
				if(Objects.isNull(newMedicalAppoinment.getDoctor())) {
					newMedicalAppoinment.setDoctor(oldMedicalAppoinment.getDoctor());
				}
				if(Objects.isNull(newMedicalAppoinment.getPatient())) {
					newMedicalAppoinment.setPatient(oldMedicalAppoinment.getPatient());
				}
				
				if(Objects.isNull(newMedicalAppoinment.getPriority())) {
					newMedicalAppoinment.setPriority(oldMedicalAppoinment.getPriority());
				}
				if(Objects.isNull(newMedicalAppoinment.getTimeAppoinmet())) {
					newMedicalAppoinment.setTimeAppoinmet(oldMedicalAppoinment.getTimeAppoinmet());
					
				}
				
				
				
				this.medicalAppoinments.remove(oldMedicalAppoinment);
				this.medicalAppoinments.add(newMedicalAppoinment);
				
				return true;
			 
		 }
		 return false;
		 
		 
	 }
    
    public boolean deleteMedicalAppoinment(int idMedicalAppoinment) {
    	for(MedicalAppoinment i: this.medicalAppoinments) {
    		if(i.getIdMedicalAppoiment()== idMedicalAppoinment) {
    			return this.medicalAppoinments.remove(i);
    		}
    	}
    	return false;
    	
    }
	
	

}
