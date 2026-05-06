package co.edu.uptc.clinic.ui;
import javax.swing.JOptionPane;

import co.edu.uptc.clinic.service.DoctorService;
import co.edu.uptc.clinic.service.MedicalAppoinmentService;
import co.edu.uptc.clinic.service.PatientService;
import co.edu.uptc.clinic.ui.MenuDoctor.MenuDoctor;
import co.edu.uptc.clinic.ui.MenuMedicalAppoinment.MenuMedicalAppoinment;
import co.edu.uptc.clinic.ui.MenuPatient.MenuPatient;



public class Main {
   public static void main(String []args) {
	   
	   PatientService patientService = new PatientService();
	   
       DoctorService doctorService = new DoctorService();
       
       MedicalAppoinmentService medicalAppoinmentService = new MedicalAppoinmentService();

    
       MenuPatient menuPatient = new MenuPatient(patientService);
       MenuDoctor menuDoctor = new MenuDoctor(doctorService);
       MenuMedicalAppoinment menuMedicalAppoinment =
           new MenuMedicalAppoinment(medicalAppoinmentService, patientService, doctorService);
	   
	   
	   
	   
	   while (true) {

           String option = JOptionPane.showInputDialog(
               "===== CLÍNICA EL LAGUITO =====\n" +
               "1. Menu Paciente\n" +
               "2. Menu Doctor\n" +
               "3. Menu Cita\n" +
               "4. Salir" 
            
           );
           
           
           if(option== null) {
        	   JOptionPane.showMessageDialog(null, "Por favor ingrese una opcion valida");
        	   break;
           }
          
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
           
        