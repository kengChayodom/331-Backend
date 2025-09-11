package se331.lab.dao;

import org.springframework.data.domain.Page;
import se331.lab.entity.Organization;


public interface OrganizeDao {
    Integer getOrganizeSize();
    Page<Organization> getOrganizes (Integer pageSize, Integer page);
    Organization getOrganize (Long id);
    Organization save(Organization organization);
}

