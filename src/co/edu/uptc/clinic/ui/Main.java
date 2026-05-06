package co.edu.uptc.clinic.ui;
import javax.swing.JOptionPane;

import co.edu.uptc.clinic.MenuDoctor.MenuDoctor;
import co.edu.uptc.clinic.MenuMedicalAppoinment.MenuMedicalAppoinment;
import co.edu.uptc.clinic.MenuPatient.ui.MenuPatient;



public class Main {
   public static void main(String []args) {
	   
	   MenuDoctor menuDoctor= new MenuDoctor();
	   MenuPatient menuPatient= new MenuPatient();
	   MenuMedicalAppoinment menuMedicalAppoinment= new MenuMedicalAppoinment();
	   
	   
	   
	   
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
           
        