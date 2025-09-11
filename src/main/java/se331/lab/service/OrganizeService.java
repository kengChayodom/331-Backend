package se331.lab.service;

import org.springframework.data.domain.Page;
import se331.lab.entity.Organization;



public interface OrganizeService {
    Integer getOrganizeSize();
    Page<Organization> getOrganizes (Integer pageSize, Integer page);
    Organization getOrganize (Long id);
    Organization save(Organization organization);
}
