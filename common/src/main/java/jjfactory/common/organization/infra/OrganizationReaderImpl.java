package jjfactory.common.organization.infra;


import jjfactory.common.global.exception.ResourceNotFoundException;
import jjfactory.common.organization.domain.Organization;
import jjfactory.common.organization.domain.OrganizationReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrganizationReaderImpl implements OrganizationReader {
    private final OrganizationRepository organizationRepository;

    @Override
    public Organization get(Long id) {
        return organizationRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("organization not found");
        });
    }
}
