package co.edu.uptc.clinic.ui;

import javax.swing.JOptionPane;

import co.edu.uptc.clinic.service.DoctorService;
import co.edu.uptc.clinic.service.MedicalAppoinmentService;
import co.edu.uptc.clinic.service.PatientService;
import co.edu.uptc.clinic.ui.MenuDoctor.MenuDoctor;
import co.edu.uptc.clinic.ui.MenuMedicalAppoinment.MenuMedicalAppoinment;
import co.edu.uptc.clinic.ui.MenuPatient.MenuPatient;

/**
 * <b>Descripción:</b> Clase principal del sistema de gestión
 * de la clínica El Laguito. <br>
 * Se encarga de inicializar los servicios y los menús
 * principales de la aplicación.
 * 
 * @author SofiaValentinaG
 */
public class Main {

	/**
	 * <b>Descripción:</b> Método principal que inicia la ejecución
	 * del programa. <br>
	 * Inicializa los servicios, crea los menús y muestra
	 * el menú principal del sistema.
	 * 
	 * @param args Parámetro de argumentos de ejecución
	 */
   public static void main(String []args) {
	   
	   /**
	    * Servicio encargado de gestionar los pacientes
	    */
	   PatientService patientService = new PatientService();
	   
	   /**
	    * Servicio encargado de gestionar los doctores
	    */
       DoctorService doctorService = new DoctorService();
       
       /**
        * Servicio encargado de gestionar las citas médicas
        */
       MedicalAppoinmentService medicalAppoinmentService = new MedicalAppoinmentService();

       /**
        * Menú de gestión de pacientes
        */
       MenuPatient menuPatient = new MenuPatient(patientService);
       
       /**
        * Menú de gestión de doctores
        */
       MenuDoctor menuDoctor = new MenuDoctor(doctorService);
       
       /**
        * Menú de gestión de citas médicas
        */
       MenuMedicalAppoinment menuMedicalAppoinment =
           new MenuMedicalAppoinment(medicalAppoinmentService, patientService, doctorService);
	   
	   /**
	    * Ciclo principal del sistema
	    */
	   while (true) {

           String option = JOptionPane.showInputDialog(
               "===== CLÍNICA EL LAGUITO =====\n" +
               "1. Menu Paciente\n" +
               "2. Menu Doctor\n" +
               "3. Menu Cita\n" +
               "4. Salir" 
            
           );
           
           /**
            * Valida si el usuario cerró la ventana
            */
           if(option== null) {
        	   JOptionPane.showMessageDialog(null, "Por favor ingrese una opcion valida");
        	   break;
           }
          
           /**
            * Evalúa la opción seleccionada por el usuario
            */
           switch(option) {

           case "1":
        	   menuPatient.startMenuPatient();
        	   break;
        	   
           case "2":
        	   menuDoctor.startMenuDoctor();
        	   break;

           case "3":
        	   menuMedicalAppoinment.startMenuMedicalAppoinment();
        	   break;

           case "4":
               return;

           default:
               javax.swing.JOptionPane.showMessageDialog(null, "Opción inválida");
           }
	   }
   }
}
        