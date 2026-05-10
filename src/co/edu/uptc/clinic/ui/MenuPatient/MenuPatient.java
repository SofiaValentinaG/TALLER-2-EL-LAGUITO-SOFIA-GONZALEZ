package co.edu.uptc.clinic.ui.MenuPatient;

import javax.swing.JOptionPane;

import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
import co.edu.uptc.clinic.enums.PriorityEnum;
import co.edu.uptc.clinic.service.PatientService;

/**
 * <b>Descripción:</b> Clase encargada de gestionar
 * el menú de pacientes del sistema de la clínica.
 * Permite agregar, mostrar, buscar, actualizar
 * y eliminar pacientes.
 * 
 * @author SofiaValentinaG
 */
public class MenuPatient {

	/** Servicio encargado de la lógica de pacientes */
    private PatientService patientService = new PatientService();
    
    
    /**
     * <b>Descripción:</b> Constructor de la clase MenuPatient.
     * Inicializa el servicio de pacientes.
     * 
     * @param patientService Servicio encargado de gestionar pacientes
     */
    public MenuPatient(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
    
    /**
     * <b>Descripción:</b> Método encargado de mostrar
     * el menú principal de pacientes y ejecutar
     * las opciones seleccionadas por el usuario.
     */
	public void startMenuPatient() {

        while (true) {

            String optionPatient = JOptionPane.showInputDialog(
                "===== MENÚ PACIENTE =====\n" +
                "1. Agregar Paciente\n" +
                "2. Mostrar todos\n" +
                "3. Buscar por ID\n" +
                "4. Actualizar\n" +
                "5. Eliminar\n" +
                "6. Volver"
            );

            if (optionPatient == null) break;

            switch(optionPatient) {

            case "1":
                Patient patient = createPatient();
                if (patient != null) {
                    patientService.addPatient(patient);
                }
                break;

            case "2":
            	 String result = "";

            	    for (Patient p : patientService.findAll()) {
            	        result += p.toString() + "\n\n";
            	    }

            	    if (result.isEmpty()) {
            	        result = "No hay pacientes registrados";
            	    }

            	    JOptionPane.showMessageDialog(null, result);
               
                
                break;

            case "3":
                String idFind = JOptionPane.showInputDialog("ID:");
                if (!isNumber(idFind)) break;

                Patient found = patientService.findById(Integer.parseInt(idFind));

                JOptionPane.showMessageDialog(null,
                    found != null ? found : "No encontrado");
                break;

            case "4":
                String idUp = JOptionPane.showInputDialog("ID:");
                if (!isNumber(idUp)) break;

                Patient update = updatePatient(Integer.parseInt(idUp));

                if (update != null) {
                    patientService.updatePatient(update);
                }
                break;

            case "5":
                String idDel = JOptionPane.showInputDialog("ID:");
                if (!isNumber(idDel)) break;

                patientService.deletePatient(Integer.parseInt(idDel));
                break;

            case "6":
                return;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }
    
    /**
     * <b>Descripción:</b> Método encargado de actualizar
     * la información de un paciente existente.
     * 
     * @param id Identificador del paciente
     * @return Objeto Patient actualizado
     */
    public static Patient updatePatient(int id) {
 	   String firstName = JOptionPane.showInputDialog("Nombre:");
        String lastName = JOptionPane.showInputDialog("Apellido:");
        String email = JOptionPane.showInputDialog("Email:");
        PriorityEnum priority = (PriorityEnum) JOptionPane.showInputDialog(null,"Seleccione la prioridad:","Prioridad", JOptionPane.QUESTION_MESSAGE,
     	        null,
     	        PriorityEnum.values(), 
     	        PriorityEnum.LOW     );
        IdentificationTypeEnum identificationType = (IdentificationTypeEnum) JOptionPane.showInputDialog(
     	        null,
     	        "Seleccione el tipo de identificación:",
     	        "Identificación",
     	        JOptionPane.QUESTION_MESSAGE,
     	        null,
     	        IdentificationTypeEnum.values(),
     	        IdentificationTypeEnum.CC
     	);
        Patient patient=new Patient (identificationType,id, firstName, lastName, email,priority);
        
        String medications = JOptionPane.showInputDialog(
                "Ingrese los medicamentos separados por coma Ejemplo: Acetaminofen, Ibuprofeno,etc.."
        );
        
        if (medications != null && !medications.isEmpty()) {

            String[] medsArray = medications.split(",");

            for (String med : medsArray) {
                patient.getMedicationHistory().add(med.trim());
            }
        }
        
        

        return patient;
 	   
    }
    
    /**
     * <b>Descripción:</b> Método encargado de crear
     * un nuevo paciente solicitando los datos
     * necesarios al usuario.
     * 
     * @return Objeto Patient creado o null si ocurre un error
     */
    public static Patient createPatient() {
 	
 	   String idPatient = JOptionPane.showInputDialog("ID paciente:");
        if (!isNumber(idPatient)) {
     	   JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido");
     	    return null;
     	 
        }

        int id = Integer.parseInt(idPatient);

        String firstName = JOptionPane.showInputDialog("Nombre:");
        String lastName = JOptionPane.showInputDialog("Apellido:");
        String email = JOptionPane.showInputDialog("Email:");
        PriorityEnum priority = (PriorityEnum) JOptionPane.showInputDialog(null,"Seleccione la prioridad:","Prioridad", JOptionPane.QUESTION_MESSAGE,
     	        null,
     	        PriorityEnum.values(), 
     	        PriorityEnum.LOW     );
        IdentificationTypeEnum identificationType = (IdentificationTypeEnum) JOptionPane.showInputDialog(
     	        null,
     	        "Seleccione el tipo de identificación:",
     	        "Identificación",
     	        JOptionPane.QUESTION_MESSAGE,
     	        null,
     	        IdentificationTypeEnum.values(),
     	        IdentificationTypeEnum.CC
     	);
        
        Patient patient= new Patient (identificationType,id, firstName, lastName, email,priority);
  	   
        
        String medications = JOptionPane.showInputDialog(
                "Ingrese los medicamentos separados por coma Ejemplo: Acetaminofen, Ibuprofeno,etc.."
        );
        
        if (medications != null && !medications.isEmpty()) {

            String[] medsArray = medications.split(",");

            for (String med : medsArray) {
                patient.getMedicationHistory().add(med.trim());
            }
        }
        

        return  patient;
 	   
    }
    
    /**
     * <b>Descripción:</b> Método encargado de validar
     * si un texto contiene únicamente números.
     * 
     * @param text Texto a validar
     * @return true si el texto es numérico,
     * false en caso contrario
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