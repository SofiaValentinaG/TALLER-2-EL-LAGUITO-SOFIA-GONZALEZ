package co.edu.uptc.clinic.ui.MenuDoctor;

import javax.swing.JOptionPane;

import co.edu.uptc.clinic.domain.Doctor;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;

import co.edu.uptc.clinic.service.DoctorService;

/**
 * <b>Descripción:</b> Clase encargada de gestionar el menú
 * de doctores de la clínica mediante interfaces gráficas
 * utilizando JOptionPane. <br>
 * Permite agregar, buscar, actualizar, eliminar y mostrar
 * doctores registrados en el sistema.
 * 
 * @author SofiaValentinaG
 */
public class MenuDoctor {

	/**
	 * Servicio encargado de gestionar las operaciones
	 * relacionadas con los doctores.
	 */
    private DoctorService doctorService= new DoctorService();
    
    /**
     * <b>Descripción:</b> Constructor de la clase MenuDoctor. <br>
     * Inicializa el servicio de doctores.
     * 
     * @param doctorService Representa el servicio de doctores.
     */
    public MenuDoctor(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
    
    /**
     * <b>Descripción:</b> Método encargado de mostrar y controlar
     * el menú principal de doctores. <br>
     * Permite ejecutar operaciones CRUD sobre los doctores.
     */
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
            	
            	/**
            	 * Crea un nuevo doctor y lo agrega al sistema.
            	 */
                Doctor doctor = createDoctor();
                if (doctor != null) {
                   doctorService.addDoctor(doctor);
                }
                break;

            case "2":
            	
            	/**
            	 * Muestra todos los doctores registrados.
            	 */
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
            	
            	/**
            	 * Busca un doctor utilizando su ID.
            	 */
                String idFind = JOptionPane.showInputDialog("ID:");
                if (!isNumber(idFind)) break;

                Doctor found = doctorService.findById(Integer.parseInt(idFind));

                JOptionPane.showMessageDialog(null,
                    found != null ? found : "No encontrado");
                break;

            case "4":
            	
            	/**
            	 * Actualiza la información de un doctor existente.
            	 */
                String idUp = JOptionPane.showInputDialog("ID:");
                if (!isNumber(idUp)) break;

                Doctor update = updateDoctor(Integer.parseInt(idUp));

                if (update != null) {
                    doctorService.updateDoctor(update);
                }
                break;

            case "5":
            	
            	/**
            	 * Elimina un doctor utilizando su ID.
            	 */
                String idDel = JOptionPane.showInputDialog("ID:");
                if (!isNumber(idDel)) break;

                doctorService.deleteDoctor(Integer.parseInt(idDel));
                break;

            case "6":
            	
            	/**
            	 * Regresa al menú principal.
            	 */
                return;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }
	
	/**
	 * <b>Descripción:</b> Solicita los nuevos datos de un doctor
	 * y crea un objeto actualizado.
	 * 
	 * @param id Representa el ID del doctor a actualizar.
	 * @return Un nuevo objeto Doctor con la información actualizada.
	 */
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
    
    /**
     * <b>Descripción:</b> Solicita la información necesaria
     * para crear un nuevo doctor.
     * 
     * @return Un nuevo objeto Doctor.
     * @return null si el ID ingresado no es válido.
     */
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
    
    /**
     * <b>Descripción:</b> Verifica si un texto contiene
     * únicamente números.
     * 
     * @param text Representa el texto a validar.
     * @return true si el texto es numérico.
     * @return false si el texto es inválido.
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
