package co.edu.uptc.clinic.service;


import java.util.Objects;
import java.util.Set;


import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.repository.PatientRepository;

/**
 * <b>Descripción:</b> Clase de servicio encargada de gestionar
 * las operaciones relacionadas con los pacientes de la clínica. <br>
 * Esta clase realiza validaciones antes de interactuar
 * con el repositorio de pacientes.
 * 
 * @author SofiaValentinaG
 */
public class PatientService {
	
	/**
	 * Repositorio encargado de almacenar y administrar los pacientes.
	 */
	private PatientRepository patientRepository;

	/**
	 * <b>Descripción:</b> Constructor de la clase PatientService. <br>
	 * Inicializa el repositorio de pacientes.
	 */
	public PatientService() {
		
		this.patientRepository = new PatientRepository();
	}
	
	/**
	 * <b>Descripción:</b> Valida la información de un paciente. <br>
	 * Verifica que el paciente no sea nulo y que tenga
	 * nombre y apellido registrados.
	 * 
	 * @param patient Representa el paciente a validar.
	 * @return true si el paciente es válido.
	 * @return false si el paciente es inválido.
	 */
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
	
	
	/**
	 * <b>Descripción:</b> Agrega un nuevo paciente al repositorio. <br>
	 * Primero valida que la información del paciente sea correcta.
	 * 
	 * @param patient Representa el paciente a agregar.
	 * @return true si el paciente fue agregado correctamente.
	 * @return false si no pudo agregarse.
	 */
	public boolean addPatient(Patient patient) {
		if(this.validatePatient(patient)) {
			return this.patientRepository.addPatient(patient);
		}
		return false;
		
	}
	
	
	/**
	 * <b>Descripción:</b> Obtiene todos los pacientes registrados.
	 * 
	 * @return Conjunto con todos los pacientes almacenados.
	 */
	public Set<Patient> findAll(){
		
		
		return this.patientRepository.findAll();
	}
	
	/**
	 * <b>Descripción:</b> Busca un paciente utilizando su ID.
	 * 
	 * @param patientId Representa el ID del paciente.
	 * @return El paciente encontrado.
	 * @return null si no existe un paciente con ese ID.
	 */
	public Patient findById(int patientId) {
		if(patientId < 1) {
			return null;
			}
	
		return this.patientRepository.findPatientById(patientId);
	}
	
	/**
	 * <b>Descripción:</b> Actualiza la información de un paciente. <br>
	 * Primero valida el nuevo paciente y verifica que exista
	 * previamente en el repositorio.
	 * 
	 * @param newPatient Representa la nueva información del paciente.
	 * @return true si la actualización fue exitosa.
	 * @return false si no pudo realizarse.
	 */
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

	
	/**
	 * <b>Descripción:</b> Elimina un paciente utilizando su ID.
	 * 
	 * @param patientId Representa el ID del paciente.
	 * @return true si el paciente fue eliminado correctamente.
	 * @return false si no pudo eliminarse.
	 */
	public boolean deletePatient(int patientId) {
		if(patientId < 1) {
			return false;
			}
		return this.patientRepository.delete(patientId);
	      
	}
	
}