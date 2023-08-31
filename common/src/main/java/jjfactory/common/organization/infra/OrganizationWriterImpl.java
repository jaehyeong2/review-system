package jjfactory.common.organization.infra;

import jjfactory.common.organization.domain.Organization;
import jjfactory.common.organization.domain.OrganizationWriter;
import jjfactory.common.organization.infra.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrganizationWriterImpl implements OrganizationWriter {
    private final OrganizationRepository organizationRepository;
    @Override
    public Organization write(Organization organization) {
        return organizationRepository.save(organization);
    }
}
