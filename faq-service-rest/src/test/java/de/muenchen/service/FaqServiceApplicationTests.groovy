package de.muenchen.service

import de.muenchen.service.domain.AnswerEntity
import de.muenchen.service.domain.FaqEntity
import de.muenchen.service.domain.QuestionEntity
import de.muenchen.service.domain.RatingEntity
import de.muenchen.service.repo.FaqRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import uk.co.jemos.podam.api.PodamFactory
import uk.co.jemos.podam.api.PodamFactoryImpl

import static org.junit.Assert.assertNotNull

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = FaqServiceApplication)
class FaqServiceApplicationTests {

    @Autowired
    FaqRepository repository;

    PodamFactory factory = new PodamFactoryImpl();

    @Test
    void contextLoads() {
        FaqEntity entity = FaqDataLoader.createRandomEntity();
        entity = repository.save(entity);
        assertNotNull(entity.getOid());
    }

}
