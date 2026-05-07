package co.edu.uptc.clinic.repository;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import co.edu.uptc.clinic.domain.MedicalAppoinment;

/**
 * <b>Descripción:</b> Repositorio encargado de almacenar y gestionar
 * las citas médicas del sistema de la clínica.
 * <br><br>
 * Esta clase permite realizar operaciones CRUD sobre las citas médicas:
 * <ul>
 *   <li>Agregar citas</li>
 *   <li>Buscar citas</li>
 *   <li>Actualizar citas</li>
 *   <li>Eliminar citas</li>
 * </ul>
 * 
 * Las citas son almacenadas en un {@link TreeSet},
 * lo que permite mantenerlas ordenadas automáticamente
 * según el método compareTo implementado en la clase
 * MedicalAppoinment.
 */
public class MedicalAppoinmentRepository {
	
	/**
	 * Conjunto que almacena las citas médicas registradas.
	 * Se utiliza TreeSet para mantener el orden automático.
	 */
	private Set <MedicalAppoinment> medicalAppoinments;

	/**
	 * <b>Descripción:</b> Constructor del repositorio.
	 * Inicializa la colección de citas médicas.
	 */
	public MedicalAppoinmentRepository() {
		
		this.medicalAppoinments = new TreeSet <>() ;
	}
	
	/**
	 * <b>Descripción:</b> Agrega una nueva cita médica al repositorio.
	 * 
	 * @param medicalAppoinment Cita médica que se desea agregar
	 * @return true si la cita fue agregada correctamente,
	 * false en caso contrario
	 */
	public boolean addMedicalAppoinments(MedicalAppoinment medicalAppoinment) {
		return this.medicalAppoinments.add(medicalAppoinment);
	}
	
	/**
	 * <b>Descripción:</b> Retorna todas las citas médicas registradas.
	 * 
	 * @return conjunto de citas médicas almacenadas
	 */
	public Set <MedicalAppoinment> findAll(){
		return this.medicalAppoinments;
	}
	
	/**
	 * <b>Descripción:</b> Busca una cita médica utilizando su ID.
	 * 
	 * @param idMedicalAppoinment ID de la cita médica
	 * @return cita médica encontrada o null si no existe
	 */
	public MedicalAppoinment findById(int idMedicalAppoinment) {
		for(MedicalAppoinment i: this.medicalAppoinments) {
			if(i.getIdMedicalAppoiment()== idMedicalAppoinment) {
				return i;
				
			}
			
		}
		return null;
		
	}
	
	/**
	 * <b>Descripción:</b> Actualiza la información de una cita médica existente.
	 * <br><br>
	 * Si alguno de los atributos del nuevo objeto es null,
	 * se conserva el valor anterior.
	 * 
	 * @param newMedicalAppoinment Nueva información de la cita médica
	 * @return true si la actualización fue exitosa,
	 * false en caso contrario
	 */
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
    
    /**
     * <b>Descripción:</b> Elimina una cita médica utilizando su ID.
     * 
     * @param idMedicalAppoinment ID de la cita médica a eliminar
     * @return true si la cita fue eliminada correctamente,
     * false en caso contrario
     */
    public boolean deleteMedicalAppoinment(int idMedicalAppoinment) {
    	for(MedicalAppoinment i: this.medicalAppoinments) {
    		if(i.getIdMedicalAppoiment()== idMedicalAppoinment) {
    			return this.medicalAppoinments.remove(i);
    		}
    	}
    	return false;
    	
    }
}