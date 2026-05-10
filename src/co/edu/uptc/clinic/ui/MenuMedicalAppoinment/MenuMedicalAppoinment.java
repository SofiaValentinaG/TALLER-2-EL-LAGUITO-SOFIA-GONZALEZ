package co.edu.uptc.clinic.ui.MenuMedicalAppoinment;

import java.util.Date;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.domain.MedicalAppoinment;
import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.enums.PriorityEnum;
import co.edu.uptc.clinic.service.DoctorService;
import co.edu.uptc.clinic.service.MedicalAppoinmentService;
import co.edu.uptc.clinic.service.PatientService;

/**
 * <b>Descripción:</b> Clase encargada de gestionar
 * el menú de citas médicas del sistema de la clínica.
 * Permite agregar, mostrar, buscar, actualizar y eliminar citas médicas.
 * 
 * @author SofiaValentinaG
 */
public class MenuMedicalAppoinment {

	/** Servicio encargado de la lógica de citas médicas */
	private MedicalAppoinmentService medicalAppoinmentService;
	
	/** Servicio encargado de la lógica de pacientes */
	private PatientService patientService;
	
	/** Servicio encargado de la lógica de doctores */
	private DoctorService doctorService;

	/**
	 * <b>Descripción:</b> Constructor de la clase MenuMedicalAppoinment.
	 * Inicializa los servicios necesarios para gestionar las citas.
	 * 
	 * @param medicalAppoinmentService Servicio de citas médicas
	 * @param patientService Servicio de pacientes
	 * @param doctorService Servicio de doctores
	 */
	public MenuMedicalAppoinment(
	    MedicalAppoinmentService medicalAppoinmentService,
	    PatientService patientService,
	    DoctorService doctorService
	) {
	    this.medicalAppoinmentService = medicalAppoinmentService;
	    this.patientService = patientService;
	    this.doctorService = doctorService;
	}

	/**
	 * <b>Descripción:</b> Método encargado de mostrar el menú
	 * principal de citas médicas y ejecutar las opciones seleccionadas
	 * por el usuario.
	 */
    public void startMenuMedicalAppoinment() {

        while (true) {

            String option = JOptionPane.showInputDialog(
                "===== MENÚ CITAS =====\n" +
                "1. Agregar cita\n" +
                "2. Mostrar todas las citas\n" +
                "3. Buscar por ID\n" +
                "4. Actualizar\n" +
                "5. Eliminar\n" +
                "6. Volver"
            );

            if (option == null) return;

            switch(option) {

            case "1":
                MedicalAppoinment cita = createMedicalAppoinment();
                if (cita != null) {
                    medicalAppoinmentService.addMedicalAppoinment(cita);
                }
                break;

            case "2":
            	 String result = "";

            	    for (MedicalAppoinment i: medicalAppoinmentService.findAll()) {
            	        result += i.toString() + "\n\n";
            	    }

            	    if (result.isEmpty()) {
            	        result = "No hay citas registradas";
            	    }

            	    JOptionPane.showMessageDialog(null, result);
                break;

            case "3":
                String idFind = JOptionPane.showInputDialog("ID:");
                if (!isNumber(idFind)) break;

                MedicalAppoinment found = medicalAppoinmentService.findById(Integer.parseInt(idFind));

                JOptionPane.showMessageDialog(null,
                    found != null ? found : "No encontrado");
                break;

            case "4":
                String idUp = JOptionPane.showInputDialog("ID:");
                if (!isNumber(idUp)) break;

                MedicalAppoinment update = updateMedicalAppoinment(Integer.parseInt(idUp));

                if (update != null) {
                    medicalAppoinmentService.updateMedicalAppoinment(update);
                }
                break;

            case "5":
                String idDel = JOptionPane.showInputDialog("ID:");
                if (!isNumber(idDel)) break;

                medicalAppoinmentService.deleteMedicalAppoinment(Integer.parseInt(idDel));
                break;

            case "6":
                return;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }

 
    /**
     * <b>Descripción:</b> Método encargado de crear una nueva
     * cita médica solicitando los datos necesarios al usuario.
     * 
     * @return Objeto MedicalAppoinment creado o null si ocurre algún error
     */
    public  MedicalAppoinment createMedicalAppoinment() {
    	
    	//Id de la cita

        String idStr = JOptionPane.showInputDialog("ID de la cita:");
        if (!isNumber(idStr)) return null;

        int id = Integer.parseInt(idStr);

        // Fecha
        JDateChooser dateChooser = new JDateChooser();

        int option = JOptionPane.showConfirmDialog(
            null,
            dateChooser,
            "Seleccione fecha",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (option != JOptionPane.OK_OPTION) return null;

        Date fecha = dateChooser.getDate();

        // id paciente
        String idPatientStr = JOptionPane.showInputDialog("ID del paciente:");
        if (!isNumber(idPatientStr)) return null;

        Patient patient = patientService.findById(Integer.parseInt(idPatientStr));

        if (patient == null) {
            JOptionPane.showMessageDialog(null, "Paciente no existe");
            return null;
        }

        // Buscar iddoctor
        String idDoctorStr = JOptionPane.showInputDialog("ID del doctor:");
        if (!isNumber(idDoctorStr)) return null;

        Doctor doctor = doctorService.findById(Integer.parseInt(idDoctorStr));

        if (doctor == null) {
            JOptionPane.showMessageDialog(null, "Doctor no existe");
            return null;
        }

        // Prioridad
        PriorityEnum priority = (PriorityEnum) JOptionPane.showInputDialog(
            null,
            "Seleccione prioridad:",
            "Prioridad",
            JOptionPane.QUESTION_MESSAGE,
            null,
            PriorityEnum.values(),
            PriorityEnum.LOW
        );

        if (priority == null) return null;

        return new MedicalAppoinment(id, fecha, patient, doctor, priority);
    }


    /**
     * <b>Descripción:</b> Método encargado de actualizar
     * una cita médica existente.
     * 
     * @param id Identificador de la cita a actualizar
     * @return Nueva cita médica actualizada o null si no existe
     */
    public MedicalAppoinment updateMedicalAppoinment(int id) {

        MedicalAppoinment old = medicalAppoinmentService.findById(id);

        if (old == null) {
            JOptionPane.showMessageDialog(null, "Cita no existe");
            return null;
        }

     
        JDateChooser dateChooser = new JDateChooser();

        int option = JOptionPane.showConfirmDialog(
            null,
            dateChooser,
            "Seleccione nueva fecha",
            JOptionPane.OK_CANCEL_OPTION
        );

        Date fecha = (option == JOptionPane.OK_OPTION)
            ? dateChooser.getDate()
            : old.getTimeAppoinmet();

   
        PriorityEnum priority = (PriorityEnum) JOptionPane.showInputDialog(
            null,
            "Seleccione prioridad:",
            "Prioridad",
            JOptionPane.QUESTION_MESSAGE,
            null,
            PriorityEnum.values(),
            old.getPriority()
        );

        if (priority == null) priority = old.getPriority();

        return new MedicalAppoinment(
            id,
            fecha,
            old.getPatient(),
            old.getDoctor(),
            priority
        );
    }

   
    /**
     * <b>Descripción:</b> Método encargado de validar
     * si un texto contiene únicamente números.
     * 
     * @param text Texto a validar
     * @return true si el texto es numérico, false en caso contrario
     */
    public static boolean isNumber(String text) {
        if (text == null || text.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo vacío");
            return false;
        }

        for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número");
                return false;
            }
        }

        return true;
    }
}