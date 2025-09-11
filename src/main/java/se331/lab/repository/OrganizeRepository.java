package se331.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.entity.Organization;

import java.util.List;

public interface OrganizeRepository extends JpaRepository<Organization, Long> {
    List<Organization> findAll();
}
