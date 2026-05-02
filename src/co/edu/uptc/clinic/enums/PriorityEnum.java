package co.edu.uptc.clinic.enums;

public enum PriorityEnum {
	 LOW (0), MEDIUM (1), HIGH(2), CRITICAL(3);
	private int value;

	private PriorityEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
