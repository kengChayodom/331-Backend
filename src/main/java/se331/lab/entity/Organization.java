package se331.lab.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Organization {
    Long id;
    String organizationname;
    String address;

}
