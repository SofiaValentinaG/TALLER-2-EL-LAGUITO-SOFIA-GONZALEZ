package co.edu.uptc.clinic.enums;

public enum IdentificationTypeEnum {
	CC("Cédula de ciudadanía"),TI("Tarjeta de identidad"),CE("Cédula de extranjería"),PA("Pasaporte");
	private String identificationName;

	private IdentificationTypeEnum(String identificationName) {
		this.identificationName = identificationName;
	}

	public String getIdentificationName() {
		return identificationName;
	}

	public void setIdentificationName(String identificationName) {
		this.identificationName = identificationName;
	}
	

	
   
  
}
