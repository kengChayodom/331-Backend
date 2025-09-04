package se331.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.lab.dao.OrganizeDao;
import se331.lab.entity.Organization;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizeServiceImpl implements OrganizeService  {
    final OrganizeDao organizeDao;

    @Override
    public Integer getOrganizeSize() {
        return organizeDao.getOrganizeSize();
    }

    @Override
    public List<Organization> getOrganizes(Integer pageSize, Integer page) {
        return organizeDao.getOrganizes(pageSize, page);
    }

    @Override
    public Organization getOrganize(Long id) {
        return organizeDao.getOrganize(id);
    }
}
