package com.foi.nloncar.auth;

public class AccountService {

	public int withInlineCheck(int balance) {
		if (!"READ".equals(SecurityContext.currentPermission())) {
			throw new AuthorizationException("missing permission READ");
		}
		return computeBalance(balance);
	}

	public int withAspectCheck(int balance) {
		return computeBalance(balance);
	}

	private int computeBalance(int balance) {
		return balance * 2;
	}
}
