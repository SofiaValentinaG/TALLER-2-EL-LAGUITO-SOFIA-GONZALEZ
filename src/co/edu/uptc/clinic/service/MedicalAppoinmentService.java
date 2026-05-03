package co.edu.uptc.clinic.service;

import java.util.Objects;
import java.util.Set;

import co.edu.uptc.clinic.domain.MedicalAppoinment;

import co.edu.uptc.clinic.repository.MedicalAppoinmentRepository;

public class MedicalAppoinmentService {
	
	private  MedicalAppoinmentRepository  medicalAppoinmentRepository;

	public MedicalAppoinmentService() {
		
		this.medicalAppoinmentRepository = new MedicalAppoinmentRepository();
		
		
	}
	
	public boolean validateMedicalAppoinment(MedicalAppoinment medicalAppoinment) {
		if( medicalAppoinment == null) {
			System.out.println("ingrese una cita valita");
			return false;
		}
		else if(medicalAppoinment.getPatient() == null|| medicalAppoinment.getDoctor()== null|| medicalAppoinment.getPriority()==null) {
			return false;
			
		}
		
		return true;
		
	}
	
	public boolean addMedicalAppoinment(MedicalAppoinment medicalAppoinment) {
		   if(medicalAppoinment.getIdMedicalAppoiment() < 1) {
			 return false;  
		   }
		   else if(this.validateMedicalAppoinment(medicalAppoinment)) {
		return this.medicalAppoinmentRepository.addMedicalAppoinments(medicalAppoinment);
		}
		   return false;
	}
	


   public Set<MedicalAppoinment> findAll(){
	   return this.medicalAppoinmentRepository.findAll();
	   
	   
	   
   }
   
      public MedicalAppoinment findById(int idMedicalAppoiment) {
	   if(idMedicalAppoiment < 1) {
		   return null;
	     }
	   return this.medicalAppoinmentRepository.findById(idMedicalAppoiment);
	   
       }
      
      public boolean updateMedicalAppoinment(MedicalAppoinment newMedicalAppoinment) {
    		if(this.validateMedicalAppoinment(newMedicalAppoinment)) {
    			MedicalAppoinment oldMedicalAppoinment= this.medicalAppoinmentRepository.findById(newMedicalAppoinment.getIdMedicalAppoiment());
    			if(!Objects.isNull(oldMedicalAppoinment)) {
    				this.medicalAppoinmentRepository.updateMedicalAppoinment(newMedicalAppoinment);
    				return true;
    			}
    			return false;
    		}
    		return false;
    	  
      }
      
      public boolean deleteMedicalAppoinment(int idMedicalAppoinment) {
    	  if(idMedicalAppoinment < 1) {
    		  return false;
    	  }
    	 
    	return this.medicalAppoinmentRepository.deleteMedicalAppoinment(idMedicalAppoinment);
    	
    	  
      }
}
     