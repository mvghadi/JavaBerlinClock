package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.beans.Lamp;

public class BerlinTimeConverter implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		if(aTime == null || !aTime.matches("^(([0-1][0-9]|[2][0-3]):[0-5][0-9]:[0-5][0-9])|(24:00:00)$")) {
			throw new IllegalArgumentException("Invalid TimeFormat, required in HH:MM:SS.");
		}
		return Lamp.getTime(aTime);
	}
	
}
