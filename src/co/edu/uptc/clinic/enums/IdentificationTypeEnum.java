package co.edu.uptc.clinic.enums;

/**
 * <b>Descripción:</b> Enumeración que representa los diferentes tipos de
 * identificación que puede tener un paciente o doctor dentro del sistema
 * de la clínica.
 * <br><br>
 * Cada valor del enum contiene una abreviatura (CC, TI, etc.)
 * y una descripción completa del tipo de identificación.
 * 
 * Ejemplos:
 * <ul>
 *   <li>CC → Cédula de ciudadanía</li>
 *   <li>TI → Tarjeta de identidad</li>
 *   <li>CE → Cédula de extranjería</li>
 *   <li>PA → Pasaporte</li>
 * </ul>
 */
public enum IdentificationTypeEnum {

	/** Representa la Cédula de ciudadanía */
	CC("Cédula de ciudadanía"),

	/** Representa la Tarjeta de identidad */
	TI("Tarjeta de identidad"),

	/** Representa la Cédula de extranjería */
	CE("Cédula de extranjería"),

	/** Representa el Pasaporte */
	PA("Pasaporte");

	/** Nombre completo del tipo de identificación */
	private String identificationName;

	/**
	 * <b>Descripción:</b> Constructor del enum que asigna
	 * el nombre completo del tipo de identificación.
	 * 
	 * @param identificationName Nombre descriptivo del tipo de identificación
	 */
	private IdentificationTypeEnum(String identificationName) {
		this.identificationName = identificationName;
	}

	/**
	 * <b>Descripción:</b> Obtiene el nombre completo del tipo de identificación.
	 * 
	 * @return Nombre del tipo de identificación
	 */
	public String getIdentificationName() {
		return identificationName;
	}

	/**
	 * <b>Descripción:</b> Permite modificar el nombre del tipo de identificación.
	 * 
	 * 
	 * 
	 * @param identificationName Nuevo nombre del tipo de identificación
	 */
	public void setIdentificationName(String identificationName) {
		this.identificationName = identificationName;
	}
}