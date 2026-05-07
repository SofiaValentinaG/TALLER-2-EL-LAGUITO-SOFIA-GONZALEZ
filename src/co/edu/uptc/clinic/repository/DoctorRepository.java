package co.edu.uptc.clinic.repository;

import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;
import co.edu.uptc.clinic.domain.Doctor;

/**
 * <b>Descripción:</b> Repositorio encargado de almacenar y gestionar
 * la información de los doctores dentro del sistema de la clínica.
 * <br><br>
 * Esta clase implementa operaciones CRUD básicas:
 * <ul>
 *   <li>Agregar doctores</li>
 *   <li>Buscar doctores</li>
 *   <li>Actualizar información</li>
 *   <li>Eliminar doctores</li>
 * </ul>
 * 
 * Los doctores son almacenados en un {@link TreeSet},
 * permitiendo mantenerlos ordenados automáticamente
 * según el método compareTo implementado en la clase Doctor.
 */
public class DoctorRepository {
	
	/** 
	 * Conjunto que almacena los doctores registrados.
	 * Se utiliza TreeSet para mantener el orden automático.
	 */
	private Set<Doctor> doctors;

	/**
	 * <b>Descripción:</b> Constructor del repositorio.
	 * Inicializa la colección de doctores.
	 */
	public DoctorRepository() {
	
		this.doctors = new TreeSet<>();
	}
	
	/**
	 * <b>Descripción:</b> Agrega un nuevo doctor al repositorio.
	 * 
	 * @param doctor Doctor que se desea agregar
	 * @return true si el doctor fue agregado correctamente,
	 * false en caso contrario
	 */
	public boolean addDoctor(Doctor doctor) {
		return this.doctors.add(doctor);
				
	}
	
	/**
	 * <b>Descripción:</b> Retorna todos los doctores registrados.
	 * 
	 * @return conjunto de doctores almacenados
	 */
	public Set <Doctor> findAll(){
		return this.doctors;
	}
	
	/**
	 * <b>Descripción:</b> Busca un doctor por su ID médico.
	 * 
	 * @param idDoctor ID del doctor a buscar
	 * @return Doctor encontrado o null si no existe
	 */
	public Doctor findDoctorById(int idDoctor) {
		for(Doctor i:this.doctors) {
			if(i.getMedicalId()== idDoctor) {
				return i;
			}
		}
		return null;
		
	    }
	
	/**
	 * <b>Descripción:</b> Actualiza la información de un doctor existente.
	 * <br><br>
	 * Si algún atributo del nuevo doctor es null,
	 * se conserva el valor anterior.
	 * 
	 * @param newDoctor Nueva información del doctor
	 * @return true si la actualización fue exitosa,
	 * false en caso contrario
	 */
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
	 
	 /**
	  * <b>Descripción:</b> Elimina un doctor del repositorio
	  * utilizando su ID médico.
	  * 
	  * @param medicalId ID del doctor a eliminar
	  * @return true si el doctor fue eliminado correctamente,
	  * false en caso contrario
	  */
	 public boolean delete(int medicalId) {
		    return this.doctors.removeIf(doctor -> 
		        doctor.getMedicalId() == medicalId);
		}
}