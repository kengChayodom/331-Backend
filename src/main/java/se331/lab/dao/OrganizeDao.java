package se331.lab.dao;

import se331.lab.entity.Organization;

import java.util.List;

public interface OrganizeDao {
    Integer getOrganizeSize();
    List<Organization> getOrganizes (Integer pageSize, Integer page);
    Organization getOrganize (Long id);
}

