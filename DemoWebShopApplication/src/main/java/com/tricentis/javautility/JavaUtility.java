package com.tricentis.javautility;

import java.time.LocalDateTime;

public class JavaUtility {
	
	public String getSysTime() {
		return LocalDateTime.now().toString().replace(":", "_");
	}
}
