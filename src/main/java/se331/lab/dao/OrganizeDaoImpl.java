package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Event;
import se331.lab.entity.Organization;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizeDaoImpl implements OrganizeDao {
    List<Organization> organizeList;

    @PostConstruct
    public void init() {
        organizeList = new ArrayList<>();

        organizeList.add(Organization.builder()
                .id(1L)
                .organizationname("Green Paws Foundation")
                .address("12 Catnip Rd, Meow Town")
                .build());

        organizeList.add(Organization.builder()
                .id(2L)
                .organizationname("Flora City Community")
                .address("45 Garden Ave, Flora City")
                .build());

        organizeList.add(Organization.builder()
                .id(3L)
                .organizationname("Ocean Care")
                .address("99 Beach Blvd, Playa Del Carmen")
                .build());

        organizeList.add(Organization.builder()
                .id(4L)
                .organizationname("Woof Town Rescue")
                .address("7 Bark St, Woof Town")
                .build());

        organizeList.add(Organization.builder()
                .id(5L)
                .organizationname("Tin City Food Bank")
                .address("101 Can Rd, Tin City")
                .build());
        organizeList.add(Organization.builder()
                .id(6L)
                .organizationname("Keng Have CPU")
                .address("CMU City")
                .build());
    }
    @Override
    public Integer getOrganizeSize(){
        return organizeList.size();
    }

    @Override
    public List<Organization> getOrganizes(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizeList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return organizeList.subList(firstIndex, firstIndex + pageSize);
    }

    @Override
    public Organization getOrganize (Long id) {
        return organizeList.stream().filter(organization -> organization.getId().equals(id)).findFirst().orElse(null);
    }


}