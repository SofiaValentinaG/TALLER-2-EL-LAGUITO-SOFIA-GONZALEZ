package co.edu.uptc.clinic.enums;

public enum IdentificationType {
	CC("Cédula de ciudadanía"),TI("Tarjeta de identidad"),CE("Cédula de extranjería"),PA("Pasaporte");
	private String j;

	IdentificationType(String j) {
		this.j = j;
	}

	public String getJ() {
		return j;
	}

	public void setJ(String j) {
		this.j = j;
	}
	

   
  
}
