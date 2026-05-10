package co.edu.uptc.clinic.service;

import java.util.Objects;
import java.util.Set;

import co.edu.uptc.clinic.domain.MedicalAppoinment;

import co.edu.uptc.clinic.repository.MedicalAppoinmentRepository;

/**
 * <b>Descripción:</b> Clase de servicio encargada de gestionar
 * las operaciones relacionadas con las citas médicas. <br>
 * Esta clase valida la información antes de interactuar
 * con el repositorio de citas médicas.
 * 
 * @author SofiaValentinaG
 */
public class MedicalAppoinmentService {
	
	/**
	 * Repositorio encargado de almacenar las citas médicas.
	 */
	private  MedicalAppoinmentRepository  medicalAppoinmentRepository;

	/**
	 * <b>Descripción:</b> Constructor de la clase
	 * MedicalAppoinmentService. <br>
	 * Inicializa el repositorio de citas médicas.
	 */
	public MedicalAppoinmentService() {
		
		this.medicalAppoinmentRepository = new MedicalAppoinmentRepository();
		
		
	}
	
	/**
	 * <b>Descripción:</b> Valida la información de una cita médica. <br>
	 * Verifica que la cita no sea nula y que tenga
	 * paciente, doctor y prioridad registrados.
	 * 
	 * @param medicalAppoinment Representa la cita médica a validar.
	 * @return true si la cita es válida.
	 * @return false si la cita es inválida.
	 */
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
	
	/**
	 * <b>Descripción:</b> Agrega una nueva cita médica al repositorio. <br>
	 * Primero valida que el ID sea correcto y que la cita
	 * tenga información válida.
	 * 
	 * @param medicalAppoinment Representa la cita médica a agregar.
	 * @return true si la cita fue agregada correctamente.
	 * @return false si no pudo agregarse.
	 */
	public boolean addMedicalAppoinment(MedicalAppoinment medicalAppoinment) {
		   if(medicalAppoinment.getIdMedicalAppoiment() < 1) {
			 return false;  
		   }
		   else if(this.validateMedicalAppoinment(medicalAppoinment)) {
		return this.medicalAppoinmentRepository.addMedicalAppoinments(medicalAppoinment);
		}
		   return false;
	}
	

	/**
	 * <b>Descripción:</b> Obtiene todas las citas médicas registradas.
	 * 
	 * @return Conjunto con todas las citas médicas almacenadas.
	 */
   public Set<MedicalAppoinment> findAll(){
	   return this.medicalAppoinmentRepository.findAll();
	   
	   
	   
   }
   
   /**
    * <b>Descripción:</b> Busca una cita médica utilizando su ID.
    * 
    * @param idMedicalAppoiment Representa el ID de la cita médica.
    * @return La cita médica encontrada.
    * @return null si no existe una cita con ese ID.
    */
      public MedicalAppoinment findById(int idMedicalAppoiment) {
	   if(idMedicalAppoiment < 1) {
		   return null;
	     }
	   return this.medicalAppoinmentRepository.findById(idMedicalAppoiment);
	   
       }
      
      /**
       * <b>Descripción:</b> Actualiza la información de una cita médica. <br>
       * Primero valida la nueva cita y verifica que exista
       * previamente en el repositorio.
       * 
       * @param newMedicalAppoinment Representa la nueva información
       * de la cita médica.
       * @return true si la actualización fue exitosa.
       * @return false si no pudo realizarse.
       */
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
      
      /**
       * <b>Descripción:</b> Elimina una cita médica utilizando su ID.
       * 
       * @param idMedicalAppoinment Representa el ID de la cita médica.
       * @return true si la cita fue eliminada correctamente.
       * @return false si no pudo eliminarse.
       */
      public boolean deleteMedicalAppoinment(int idMedicalAppoinment) {
    	  if(idMedicalAppoinment < 1) {
    		  return false;
    	  }
    	 
    	return this.medicalAppoinmentRepository.deleteMedicalAppoinment(idMedicalAppoinment);
    	
    	  
      }
}