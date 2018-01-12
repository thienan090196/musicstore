package com.nashtech.musicstore.dao;

import com.nashtech.musicstore.model.Role;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("roleDao")
@Transactional
public class RoleDaoImp extends GenericDaoImp<Role, Integer> implements IRoleDao {
    public Role findRoleByName(String name) {
        return (Role) currentSession().createCriteria(Role.class).add(Restrictions.eq("roleName", name)).uniqueResult();
    }
}
