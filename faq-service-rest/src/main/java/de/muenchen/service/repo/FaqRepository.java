package de.muenchen.service.repo;

import de.muenchen.service.domain.FaqEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dennis_huning on 05.01.16.
 */
public interface FaqRepository extends CrudRepository<FaqEntity, String> {
}
