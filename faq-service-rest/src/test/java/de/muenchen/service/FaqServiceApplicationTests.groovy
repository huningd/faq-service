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
        FaqEntity entity = factory.manufacturePojo(FaqEntity);
        entity.setOid(null);
        entity.answers.clear();

        QuestionEntity question = factory.manufacturePojo(QuestionEntity);
        question.oid = null;

        AnswerEntity answer = factory.manufacturePojo(AnswerEntity);
        answer.oid = null;
        answer.ratings.clear();

        RatingEntity rating = new RatingEntity();
        rating.rating = 5;
        rating.user = "test";

        answer.ratings.add(rating);

        entity.answers.add(answer);
        entity.question = question;

        entity = repository.save(entity);
        assertNotNull(entity.getOid());
    }

}
