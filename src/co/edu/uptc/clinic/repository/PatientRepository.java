package co.edu.uptc.clinic.repository;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import co.edu.uptc.clinic.domain.Patient;

/**
 * <b>Descripción:</b> Repositorio encargado de almacenar y gestionar
 * la información de los pacientes dentro del sistema de la clínica.
 * <br><br>
 * Esta clase permite realizar operaciones CRUD:
 * <ul>
 *   <li>Agregar pacientes</li>
 *   <li>Buscar pacientes</li>
 *   <li>Actualizar información</li>
 *   <li>Eliminar pacientes</li>
 * </ul>
 * 
 * Los pacientes son almacenados en un {@link HashSet},
 * evitando registros duplicados según el método equals
 * implementado en la clase Patient.
 */
public class PatientRepository {
	
	/**
	 * Conjunto que almacena los pacientes registrados.
	 */
	private Set<Patient> patients;

	/**
	 * <b>Descripción:</b> Constructor del repositorio.
	 * Inicializa la colección de pacientes.
	 */
	public PatientRepository() {
		
		this.patients= new HashSet<>();
	}
	
	/**
	 * <b>Descripción:</b> Agrega un nuevo paciente al repositorio.
	 * 
	 * @param patient Paciente que se desea agregar
	 * @return true si el paciente fue agregado correctamente,
	 * false en caso contrario
	 */
	public boolean addPatient(Patient patient) {
		return this.patients.add(patient);
				
	}
	
	/**
	 * <b>Descripción:</b> Retorna todos los pacientes registrados.
	 * 
	 * @return conjunto de pacientes almacenados
	 */
	public Set <Patient> findAll(){
		return this.patients;
	}
	
	/**
	 * <b>Descripción:</b> Busca un paciente utilizando su ID.
	 * 
	 * @param idPatient ID del paciente a buscar
	 * @return paciente encontrado o null si no existe
	 */
	public Patient findPatientById(int idPatient) {
		for(Patient i:this.patients) {
			if(i.getIdPatient()==idPatient) {
				return i;
			}
		}
		return null;
		
	    }
	
	/**
	 * <b>Descripción:</b> Actualiza la información de un paciente existente.
	 * <br><br>
	 * Si algún atributo del nuevo paciente es null,
	 * se conserva el valor anterior.
	 * 
	 * @param newPatient Nueva información del paciente
	 * @return true si la actualización fue exitosa,
	 * false en caso contrario
	 */
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
	 
	 /**
	  * <b>Descripción:</b> Elimina un paciente utilizando su ID.
	  * 
	  * @param idPatient ID del paciente que se desea eliminar
	  * @return true si el paciente fue eliminado correctamente,
	  * false en caso contrario
	  */
	 public boolean delete(int idPatient) {
		    return this.patients.removeIf(patient -> 
		        patient.getIdPatient() == idPatient);
		}
}