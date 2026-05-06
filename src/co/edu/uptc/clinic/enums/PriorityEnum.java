package co.edu.uptc.clinic.enums;

/**
 * <b>Descripción:</b> Enumeración que representa los niveles de prioridad
 * para la atención de pacientes o citas médicas dentro del sistema de la clínica.
 * <br><br>
 * Cada nivel de prioridad tiene asociado un valor numérico que permite
 * ordenar o comparar prioridades.
 * <br><br>
 * Niveles disponibles:
 * <ul>
 *   <li>LOW → Prioridad baja (0)</li>
 *   <li>MEDIUM → Prioridad media (1)</li>
 *   <li>HIGH → Prioridad alta (2)</li>
 *   <li>CRITICAL → Prioridad crítica (3)</li>
 * </ul>
 * 
 * Este valor es útil, por ejemplo, para ordenar citas cuando tienen la misma hora,
 * mostrando primero las de mayor prioridad.
 */
public enum PriorityEnum {

	/** Prioridad baja */
	LOW (0),

	/** Prioridad media */
	MEDIUM (1),

	/** Prioridad alta */
	HIGH(2),

	/** Prioridad crítica (la más urgente) */
	CRITICAL(3);

	/** Valor numérico asociado a la prioridad */
	private int value;

	/**
	 * <b>Descripción:</b> Constructor del enum que asigna
	 * el valor numérico de la prioridad.
	 * 
	 * @param value Valor entero que representa la prioridad
	 */
	private PriorityEnum(int value) {
		this.value = value;
	}

	/**
	 * <b>Descripción:</b> Obtiene el valor numérico de la prioridad.
	 * 
	 * @return valor entero de la prioridad
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <b>Descripción:</b> Permite modificar el valor de la prioridad.
	 * 
	
	 * @param value Nuevo valor de la prioridad
	 */
	public void setValue(int value) {
		this.value = value;
	}
}