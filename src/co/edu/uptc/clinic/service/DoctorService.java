package co.edu.uptc.clinic.service;

import java.util.Objects;
import java.util.Set;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.repository.DoctorRepository;

/**
 * <b>Descripción:</b> Clase de servicio encargada de gestionar
 * las operaciones relacionadas con los doctores de la clínica. <br>
 * Esta clase actúa como intermediaria entre la interfaz de usuario
 * y el repositorio de doctores, realizando validaciones antes
 * de ejecutar las operaciones.
 * 
 * @author SofiaValentinaG
 */
public class DoctorService {
	
	/**
	 * Repositorio encargado de almacenar y administrar los doctores.
	 */
	private DoctorRepository doctorRepository;

	/**
	 * <b>Descripción:</b> Constructor de la clase DoctorService. <br>
	 * Inicializa el repositorio de doctores.
	 */
	public DoctorService() {
		
		this.doctorRepository = new DoctorRepository();
		
	}
	
	/**
	 * <b>Descripción:</b> Valida la información de un doctor. <br>
	 * Verifica que el objeto doctor no sea nulo y que tenga
	 * nombre y apellido registrados.
	 * 
	 * @param doctor Representa el doctor a validar.
	 * @return true si el doctor es válido.
	 * @return false si el doctor es inválido.
	 */
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
	
	/**
	 * <b>Descripción:</b> Agrega un nuevo doctor al repositorio. <br>
	 * Antes de agregarlo, valida que la información sea correcta.
	 * 
	 * @param doctor Representa el doctor a agregar.
	 * @return true si el doctor fue agregado correctamente.
	 * @return false si el doctor no pudo agregarse.
	 */
	public boolean addDoctor(Doctor doctor) {
		if(this.validateDoctor(doctor)) {
			return this.doctorRepository.addDoctor(doctor);
		}
		return false;
		
	}
	
	/**
	 * <b>Descripción:</b> Obtiene todos los doctores registrados.
	 * 
	 * @return Conjunto con todos los doctores almacenados.
	 */
	public Set<Doctor> findAll(){
		
		
		return this.doctorRepository.findAll();
	}
	
	/**
	 * <b>Descripción:</b> Busca un doctor por su identificador médico.
	 * 
	 * @param medicalId Representa el ID del doctor.
	 * @return El doctor encontrado.
	 * @return null si no existe un doctor con ese ID.
	 */
	public Doctor findById(int medicalId) {
		if(medicalId < 1) {
			return null;
			}
	
		return this.doctorRepository.findDoctorById(medicalId);
	}
	
	/**
	 * <b>Descripción:</b> Actualiza la información de un doctor. <br>
	 * Primero valida el nuevo doctor y verifica que exista
	 * en el repositorio.
	 * 
	 * @param newDoctor Representa la nueva información del doctor.
	 * @return true si la actualización fue exitosa.
	 * @return false si no se pudo actualizar.
	 */
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
	
	/**
	 * <b>Descripción:</b> Elimina un doctor del repositorio
	 * utilizando su ID médico.
	 * 
	 * @param medicalId Representa el ID del doctor a eliminar.
	 * @return true si el doctor fue eliminado correctamente.
	 * @return false si no se pudo eliminar.
	 */
	public boolean deleteDoctor(int medicalId) {
		if(medicalId < 1) {
			return false;
			}
		return this.doctorRepository.delete(medicalId);
	      
	}
	
	
	
	

	}
