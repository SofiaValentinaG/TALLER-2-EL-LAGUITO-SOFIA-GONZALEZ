package co.edu.uptc.clinic.domain;

import java.util.Date;
import java.util.Objects;
import co.edu.uptc.clinic.enums.*;

/** 
 * <b>Descripción: </b> Clase de modelo que representa
 * una cita médica dentro del sistema de la clínica <br>
 * 
 * Permite almacenar la información de la cita, incluyendo
 * fecha, paciente, doctor y prioridad. Además, permite ordenar
 * las citas por fecha y prioridad.
 * 
 * @author SofiaValentinaG
*/
public class MedicalAppoinment implements Comparable<MedicalAppoinment> {

    /** Atributo que determina el identificador de la cita */
    private int idMedicalAppoiment;

    /** Atributo que determina la fecha y hora de la cita */
    private Date timeAppoinmet;

    /** Atributo que determina el paciente asociado a la cita */
    private Patient patient;

    /** Atributo que determina el doctor asignado */
    private Doctor doctor;

    /** Atributo que determina la prioridad de la cita */
    private PriorityEnum priority;

    /**
     * <b>Description: </b> Constructor de la clase <br>
     * @param idMedicalAppoiment ID de la cita
     * @param timeAppoinmet Fecha y hora
     * @param patient Paciente
     * @param doctor Doctor
     * @param priority Prioridad de la cita
     */
    public MedicalAppoinment(int idMedicalAppoiment, Date timeAppoinmet, Patient patient, Doctor doctor, PriorityEnum priority) {
        this.idMedicalAppoiment = idMedicalAppoiment;
        this.timeAppoinmet = timeAppoinmet;
        this.patient = patient;
        this.doctor = doctor;
        this.priority = priority;
    }

    /**
     * <b>Description: </b> Retorna el ID de la cita
     * @return idMedicalAppoiment ID de la cita
     */
    public int getIdMedicalAppoiment() {
        return idMedicalAppoiment;
    }

    /**
     * <b>Description: </b> Asigna un nuevo ID <br>
     * @param idMedicalAppoiment Nuevo ID
     */
    public void setIdMedicalAppoiment(int idMedicalAppoiment) {
        this.idMedicalAppoiment = idMedicalAppoiment;
    }

    /**
     * <b>Description: </b> Retorna la fecha y hora de la cita
     * @return timeAppoinmet Fecha y hora
     */
    public Date getTimeAppoinmet() {
        return timeAppoinmet;
    }

    /**
     * <b>Description: </b> Asigna una nueva fecha <br>
     * @param timeAppoinmet Nueva fecha
     */
    public void setTimeAppoinmet(Date timeAppoinmet) {
        this.timeAppoinmet = timeAppoinmet;
    }

    /**
     * <b>Description: </b> Retorna el paciente
     * @return patient Paciente
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * <b>Description: </b> Asigna un nuevo paciente <br>
     * @param patient Nuevo paciente
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * <b>Description: </b> Retorna el doctor
     * @return doctor Doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * <b>Description: </b> Asigna un nuevo doctor <br>
     * @param doctor Nuevo doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * <b>Description: </b> Retorna la prioridad de la cita
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
     * <b>Description: </b> Genera el hash del objeto
     * @return valor hash basado en el ID
     */
    @Override
    public int hashCode() {
        return Objects.hash(idMedicalAppoiment);
    }

    /**
     * <b>Description: </b> Compara si dos citas son iguales <br>
     * @param obj Objeto a comparar
     * @return true si tienen el mismo ID
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MedicalAppoinment other = (MedicalAppoinment) obj;
        return idMedicalAppoiment == other.idMedicalAppoiment;
    }

    /**
     * <b>Description: </b> Retorna una representación en texto de la cita
     * @return Información de la cita
     */
    @Override
    public String toString() {
        return "\n=== MEDICAL APPOINTMENT ===\n" +
               "• Appointment ID: " + idMedicalAppoiment + "\n" +
               "• Date & Time: " + timeAppoinmet + "\n" +
               "• Patient: " + patient.getFirstName() + " " + patient.getLastName() + "\n" +
               "• Doctor: " + doctor.getFirstName() + " " + doctor.getLastName() + "\n" +
               "• Priority: " + priority + "\n" +
               "============================";
    }

    /**
     * <b>Description: </b> Compara citas médicas para ordenarlas <br>
     * 
     * Primero se ordenan por fecha y hora (ascendente).
     * Si coinciden en la misma fecha, se ordenan por prioridad
     * (de mayor a menor prioridad).
     * 
     * @param other Cita a comparar
     * @return valor negativo, positivo o cero según el orden
     */
    @Override
    public int compareTo(MedicalAppoinment other) {

        int compareTime = this.timeAppoinmet.compareTo(other.timeAppoinmet);

        if (compareTime != 0) {
            return compareTime;
        }

      
        return other.getPriority().getValue() - this.getPriority().getValue();
    }
}