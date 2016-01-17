package de.muenchen.service.repo;

import de.muenchen.service.domain.FaqEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.ExposesResourceFor;

import java.util.UUID;

/**
 * Created by dennis_huning on 05.01.16.
 */
@RepositoryRestResource(collectionResourceRel = "faq", path = "faq")
public interface FaqRepository extends CrudRepository<FaqEntity, UUID> {
}
