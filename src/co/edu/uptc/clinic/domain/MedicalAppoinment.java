package co.edu.uptc.clinic.domain;

import java.util.Date;
import java.util.Objects;
import co.edu.uptc.clinic.enums.*;
public class MedicalAppoinment {

    private int idMedicalAppoiment;
    private Date timeAppoinmet;
    private Patient patient;
    private Doctor doctor;
    private PriorityEnum priority;

    public MedicalAppoinment(int idMedicalAppoiment, Date timeAppoinmet, Patient patient, Doctor doctor, PriorityEnum priority) {
        this.idMedicalAppoiment = idMedicalAppoiment;
        this.timeAppoinmet = timeAppoinmet;
        this.patient = patient;
        this.doctor = doctor;
        this.priority= priority;
    }

    public int getIdMedicalAppoiment() {
        return idMedicalAppoiment;
    }

    public void setIdMedicalAppoiment(int idMedicalAppoiment) {
        this.idMedicalAppoiment = idMedicalAppoiment;
    }

    public Date getTimeAppoinmet() {
        return timeAppoinmet;
    }

    public void setTimeAppoinmet(Date timeAppoinmet) {
        this.timeAppoinmet = timeAppoinmet;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    

    public PriorityEnum getPriority() {
		return priority;
	}

	public void setPriority(PriorityEnum priority) {
		this.priority = priority;
	}

	@Override
    public int hashCode() {
        return Objects.hash(idMedicalAppoiment);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MedicalAppoinment other = (MedicalAppoinment) obj;
        return idMedicalAppoiment == other.idMedicalAppoiment;
    }
    

    @Override
    public String toString() {
        return "\n=== MEDICAL APPOINTMENT ===\n" +
               "• Appointment ID: " + idMedicalAppoiment + "\n" +
               "• Date & Time: " + timeAppoinmet + "\n" +
               "• Patient: " + patient.getFirstName() + " " + patient.getLastName() + "\n" +
               "• Doctor: " + doctor.getFirstName() + " " + doctor.getLastName() + "\n" +
               "============================";
    }
}