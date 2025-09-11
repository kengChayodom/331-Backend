package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Event;
import se331.lab.entity.Organization;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizeDaoImpl implements OrganizeDao {
    List<Organization> organizeList;

    @PostConstruct
    public void init() {
        organizeList = new ArrayList<>();

        organizeList.add(Organization.builder()
                .id(1L)
                .organization_Name("Green Paws Foundation")
                .address("12 Catnip Rd, Meow Town")
                .build());

        organizeList.add(Organization.builder()
                .id(2L)
                .organization_Name("Flora City Community")
                .address("45 Garden Ave, Flora City")
                .build());

        organizeList.add(Organization.builder()
                .id(3L)
                .organization_Name("Ocean Care")
                .address("99 Beach Blvd, Playa Del Carmen")
                .build());

        organizeList.add(Organization.builder()
                .id(4L)
                .organization_Name("Woof Town Rescue")
                .address("7 Bark St, Woof Town")
                .build());

        organizeList.add(Organization.builder()
                .id(5L)
                .organization_Name("Tin City Food Bank")
                .address("101 Can Rd, Tin City")
                .build());
        organizeList.add(Organization.builder()
                .id(6L)
                .organization_Name("Keng Have CPU")
                .address("CMU City")
                .build());
    }
    @Override
    public Integer getOrganizeSize(){
        return organizeList.size();
    }

    @Override
    public Page<Organization> getOrganizes(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizeList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Organization>(organizeList.subList(firstIndex, firstIndex + pageSize), PageRequest.of(page,pageSize),organizeList.size());
    }

    @Override
    public Organization getOrganize (Long id) {
        return organizeList.stream().filter(organization -> organization.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organization save(Organization organization) {
        organization.setId(organizeList.get(organizeList.size()-1).getId()+1);
        organizeList.add(organization);
        return organization;
    }


}