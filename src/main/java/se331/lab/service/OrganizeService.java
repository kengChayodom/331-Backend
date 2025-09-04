package se331.lab.service;

import se331.lab.entity.Event;
import se331.lab.entity.Organization;

import java.util.List;

public interface OrganizeService {
    Integer getOrganizeSize();
    List<Organization> getOrganizes (Integer pageSize, Integer page);
    Organization getOrganize (Long id);
}
