package com.clairgustafson.StudentGroup.util;

public enum AcademicLevel {
	
	EXCEEDS(4),
	MASTERY(3),
	APPROACHING(2),
	DEVELOPING(1);

	private double rating;
	
	AcademicLevel( double rating){
		this.rating = rating;
	}
	
	public double getRating() {
		return rating;
	}
}
