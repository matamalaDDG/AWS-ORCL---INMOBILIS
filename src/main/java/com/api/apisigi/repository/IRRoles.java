package com.api.apisigi.repository;

import com.api.apisigi.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("rolesrepo")
public interface IRRoles  extends JpaRepository<Roles,String> {
    public abstract Roles findRolesByIdroles(String id);
}
