package com.foi.nloncar.auth;

public final class SecurityContext {

	private static String CURRENT_PERMISSION = "READ";

	private SecurityContext() {
	}

	public static String currentPermission() {
		return CURRENT_PERMISSION;
	}
}
