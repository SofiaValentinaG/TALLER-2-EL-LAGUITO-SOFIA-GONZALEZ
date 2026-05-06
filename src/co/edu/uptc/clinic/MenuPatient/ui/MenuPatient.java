package co.edu.uptc.clinic.MenuPatient.ui;

import javax.swing.JOptionPane;

import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
import co.edu.uptc.clinic.enums.PriorityEnum;
import co.edu.uptc.clinic.service.PatientService;

public class MenuPatient {

    private PatientService patientService = new PatientService();

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
        

        return  new Patient (identificationType,id, firstName, lastName, email,priority);
 	   
    }
    
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
        

        return  new Patient (identificationType,id, firstName, lastName, email,priority);
 	   
    }
    
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
