package co.edu.uptc.clinic.ui;
import javax.swing.JOptionPane;

import co.edu.uptc.clinic.domain.Patient;
import co.edu.uptc.clinic.enums.IdentificationTypeEnum;
import co.edu.uptc.clinic.enums.PriorityEnum;
import co.edu.uptc.clinic.service.*;

public class Main {
   public static void main(String []args) {
	   
	   PatientService patientService= new PatientService();
	   MedicalAppoinmentService medicalAppoinmentService = new MedicalAppoinmentService();
	   DoctorService doctorService= new DoctorService();
	   
	   
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
           
	   }
   }
}
           
        