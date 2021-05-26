package com.dtits.springsecurity.dao;

import com.dtits.springsecurity.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
