package se331.lab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organization;
import se331.lab.repository.OrganizeRepository;


@Repository
@RequiredArgsConstructor
@Profile("db")

public class OrganizeDaoDbImpl implements OrganizeDao {

    final OrganizeRepository organizeRepository;
    @Override
    public Integer getOrganizeSize(){
        return Math.toIntExact(organizeRepository.count());
    }

    @Override
    public Page<Organization> getOrganizes(Integer pageSize, Integer page){
        return organizeRepository.findAll(PageRequest.of(page - 1 , pageSize));
    }

    @Override
    public Organization getOrganize(Long id){
        return organizeRepository.findById(id).orElse(null);
    }

    @Override
    public Organization save(Organization organization){
        return organizeRepository.save(organization);
    }

}
