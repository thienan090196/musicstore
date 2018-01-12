package com.nashtech.musicstore.dao;

import com.nashtech.musicstore.model.Role;

public interface IRoleDao extends IGenericDao<Role, Integer> {
    Role findRoleByName(String name);
}
