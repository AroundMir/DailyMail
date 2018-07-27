package com.mir.news.consts;

public enum Roles {
	EDITOR, 
	AUTHOR, 
	REVIEWER, 
	NONE;

	public static Roles getRoleByString(String status) {
		for (Roles role : values()) {
			if (role.name().equalsIgnoreCase(status)) {
				return role;
			}
		}
		return NONE;

	}

}
