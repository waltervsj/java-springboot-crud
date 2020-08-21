package com.walter.workshop.entities.enums;

public enum DemandStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private DemandStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static DemandStatus valueOf(int code) {
		for (DemandStatus value : DemandStatus.values()) {
			if(value.getCode() == code) return value;
		}
		throw new IllegalArgumentException("Invalid demand status code.");
	}
}
