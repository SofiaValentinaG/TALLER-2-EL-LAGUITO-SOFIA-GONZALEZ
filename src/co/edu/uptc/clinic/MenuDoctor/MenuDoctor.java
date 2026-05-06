package co.edu.uptc.clinic.MenuDoctor;

import javax.swing.JOptionPane;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;

import co.edu.uptc.clinic.service.DoctorService;


public class MenuDoctor {

    private DoctorService doctorService= new DoctorService();

    public void startMenuDoctor() {

        while (true) {

            String optionDoctor = JOptionPane.showInputDialog(
                "===== MENÚ PACIENTE =====\n" +
                "1. Agregar Doctor\n" +
                "2. Mostrar todos\n" +
                "3. Buscar por ID\n" +
                "4. Actualizar\n" +
                "5. Eliminar\n" +
                "6. Volver"
            );

            if (optionDoctor == null) break;

            switch(optionDoctor) {

            case "1":
                Doctor doctor = createDoctor();
                if (doctor != null) {
                   doctorService.addDoctor(doctor);
                }
                break;

            case "2":
            	 String result = "";

            	    for (Doctor d : doctorService.findAll()) {
            	        result += d.toString() + "\n\n";
            	    }

            	    if (result.isEmpty()) {
            	        result = "No hay doctores registrados";
            	    }

            	    JOptionPane.showMessageDialog(null, result);
                break;

            case "3":
                String idFind = JOptionPane.showInputDialog("ID:");
                if (!isNumber(idFind)) break;

                Doctor found = doctorService.findById(Integer.parseInt(idFind));

                JOptionPane.showMessageDialog(null,
                    found != null ? found : "No encontrado");
                break;

            case "4":
                String idUp = JOptionPane.showInputDialog("ID:");
                if (!isNumber(idUp)) break;

                Doctor update = updateDoctor(Integer.parseInt(idUp));

                if (update != null) {
                    doctorService.updateDoctor(update);
                }
                break;

            case "5":
                String idDel = JOptionPane.showInputDialog("ID:");
                if (!isNumber(idDel)) break;

                doctorService.deleteDoctor(Integer.parseInt(idDel));
                break;

            case "6":
                return;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }
    public static Doctor updateDoctor(int id) {
    	
 	   String firstName = JOptionPane.showInputDialog("Nombre:");
        String lastName = JOptionPane.showInputDialog("Apellido:");
        String speciality = JOptionPane.showInputDialog("speciality:");
        String yearsOfExperience = JOptionPane.showInputDialog("Años de experiencia:");
        int years = Integer.parseInt(yearsOfExperience);
        
  
        IdentificationTypeEnum identificationType = (IdentificationTypeEnum) JOptionPane.showInputDialog(
     	        null,
     	        "Seleccione el tipo de identificación:",
     	        "Identificación",
     	        JOptionPane.QUESTION_MESSAGE,
     	        null,
     	        IdentificationTypeEnum.values(),
     	        IdentificationTypeEnum.CC
     	);
        

        return  new Doctor(identificationType,id, firstName, lastName,
    			speciality,  years);
 	   
    }
    
    public static Doctor createDoctor() {
 	
 	   String idDoctor = JOptionPane.showInputDialog("ID doctor:");
        if (!isNumber(idDoctor)) {
     	   JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido");
     	    return null;
     	 
        }

        int id = Integer.parseInt(idDoctor);

        String firstName = JOptionPane.showInputDialog("Nombre:");
        String lastName = JOptionPane.showInputDialog("Apellido:");
        String speciality = JOptionPane.showInputDialog("speciality:");
        String yearsOfExperience = JOptionPane.showInputDialog("Años de experiencia:");
        int years = Integer.parseInt(yearsOfExperience);
        
  
        IdentificationTypeEnum identificationType = (IdentificationTypeEnum) JOptionPane.showInputDialog(
     	        null,
     	        "Seleccione el tipo de identificación:",
     	        "Identificación",
     	        JOptionPane.QUESTION_MESSAGE,
     	        null,
     	        IdentificationTypeEnum.values(),
     	        IdentificationTypeEnum.CC
     	);
        

        return  new Doctor(identificationType,id, firstName, lastName,
    			speciality,  years);
 	   
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
