package de.muenchen.service.config

import de.muenchen.service.domain.FaqEntity
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration

/**
 * Created by dennis_huning on 17.01.16.
 */
@Configuration
class FaqRepositoryRestMvcConfiguration extends RepositoryRestConfigurerAdapter{

    @Override
    void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(FaqEntity);
    }
}
