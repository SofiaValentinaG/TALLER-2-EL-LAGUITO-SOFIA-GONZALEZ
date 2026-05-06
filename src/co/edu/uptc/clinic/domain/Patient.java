package co.edu.uptc.clinic.domain;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import co.edu.uptc.clinic.enums.*;

/** 
 * <b>Descripción: </b> Clase de modelo que representa
 * la información de un paciente dentro del sistema de la clínica <br>
 * 
 * Permite almacenar datos personales, prioridad de atención
 * y el historial de medicamentos del paciente.
 * 
 * @author SofiaValentinaG
*/
public class Patient {
	/** Atributo que determina el tipo de identificación del paciente */
	private IdentificationTypeEnum identificationType;
	
	/** Atributo que determina el identificador del paciente */
	private int idPatient;
	
	/** Atributo que determina el nombre del paciente */
	private String firstName;
	
	/** Atributo que determina el apellido del paciente */
	private String lastName;
	
	/** Atributo que determina el correo electrónico del paciente */
	private String email;
	
	/** Atributo que almacena el historial de medicamentos del paciente */
	private Set<String> medicationHistory;
	
	/** Atributo que determina la prioridad del paciente */
	private PriorityEnum priority;
	
	/**
	 * <b>Description: </b> Constructor de la clase <br>
	 * @param identificationType Tipo de identificación
	 * @param idPatient ID del paciente
	 * @param firstName Nombre del paciente
	 * @param lastName Apellido del paciente
	 * @param email Correo electrónico
	 * @param priority Prioridad del paciente
	 */
	public Patient(IdentificationTypeEnum identificationType, int idPatient, String firstName, String lastName,String email,
		PriorityEnum priority) {
		super();
		this.identificationType = identificationType;
		this.idPatient = idPatient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email=email;
		this.medicationHistory = new LinkedHashSet<>();
		this.priority = priority;
	}

	/**
	 * <b>Description: </b> Retorna el tipo de identificación
	 * @return identificationType Tipo de identificación
	 */
	public IdentificationTypeEnum getIdentificationType() {
		return identificationType;
	}

	/**
	 * <b>Description: </b> Asigna un nuevo tipo de identificación <br>
	 * @param identificationType Nuevo tipo de identificación
	 */
	public void setIdentificationType(IdentificationTypeEnum identificationType) {
		this.identificationType = identificationType;
	}

	/**
	 * <b>Description: </b> Retorna el ID del paciente
	 * @return idPatient ID del paciente
	 */
	public int getIdPatient() {
		return idPatient;
	}

	/**
	 * <b>Description: </b> Asigna un nuevo ID <br>
	 * @param idPatient Nuevo ID
	 */
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	/**
	 * <b>Description: </b> Retorna el nombre del paciente
	 * @return firstName Nombre
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <b>Description: </b> Asigna un nuevo nombre <br>
	 * @param firstName Nuevo nombre
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * <b>Description: </b> Retorna el apellido del paciente
	 * @return lastName Apellido
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * <b>Description: </b> Asigna un nuevo apellido <br>
	 * @param lastName Nuevo apellido
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * <b>Description: </b> Retorna el historial de medicamentos
	 * @return medicationHistory Historial de medicamentos
	 */
	public Set<String> getMedicationHistory() {
		return medicationHistory;
	}

	/**
	 * <b>Description: </b> Asigna un nuevo historial de medicamentos <br>
	 * @param medicationHistory Nuevo historial
	 */
	public void setMedicationHistory(Set<String> medicationHistory) {
		this.medicationHistory = medicationHistory;
	}

	/**
	 * <b>Description: </b> Retorna la prioridad del paciente
	 * @return priority Prioridad
	 */
	public PriorityEnum getPriority() {
		return priority;
	}

	/**
	 * <b>Description: </b> Asigna una nueva prioridad <br>
	 * @param priority Nueva prioridad
	 */
	public void setPriority(PriorityEnum priority) {
		this.priority = priority;
	}
	
	/**
	 * <b>Description: </b> Retorna el email del paciente
	 * @return email Correo electrónico
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <b>Description: </b> Asigna un nuevo email <br>
	 * @param email Nuevo correo
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * <b>Description: </b> Genera el código hash del paciente
	 * @return valor hash basado en identificación, ID y email
	 */
	@Override
	public int hashCode() {
		
		return Objects.hash(this.identificationType,this.idPatient, this.email);
	}

	/**
	 * <b>Description: </b> Compara si dos pacientes son iguales <br>
	 * @param obj Objeto a comparar
	 * @return true si son iguales, false en caso contrario
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		Patient auxPatient = (Patient) obj;
		if(auxPatient.getIdentificationType().equals(this.identificationType) && auxPatient.getIdPatient()== this.idPatient && auxPatient.getEmail().equals(this.email)) {
			return true;
			
		}
		else {
		   return false;
		}
	}

	/**
	 * <b>Description: </b> Retorna una representación en texto del paciente
	 * @return Información del paciente
	 */
	@Override
	public String toString() {
		
		    return "=== PATIENT ===" +
		           "• ID: " + identificationType + " - " + idPatient + "\n" +
		           "• Name: " + firstName + " " + lastName + "\n" +
		           "• Email: " + email + "\n" +
		           "• Priority: " + priority + "\n" +
		           "• Medication History: " + (medicationHistory.isEmpty() ? "None" : medicationHistory) + "\n" +
		           "====================";
		
	}
	 
}
