package de.muenchen.service

import de.muenchen.service.domain.AnswerEntity
import de.muenchen.service.domain.FaqEntity
import de.muenchen.service.domain.QuestionEntity
import de.muenchen.service.domain.RatingEntity
import de.muenchen.service.repo.FaqRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.util.StringUtils

/**
 * Created by huningd on 14.01.16.
 */
class FaqDataLoader {

    @Autowired
    FaqRepository repository;

    static FaqEntity createRandomEntity() {
        FaqEntity entity = new FaqEntity();
        entity.answers = new HashSet<>();
        entity.topic ="Topic";
        entity.setOid(null);

        QuestionEntity question = new QuestionEntity()
        question.text = "text";
        question.oid = null;

        AnswerEntity answer = new AnswerEntity()
        answer.text = "Answer";
        answer.oid = null;
        answer.ratings = new HashSet<>();

        RatingEntity rating = new RatingEntity();
        rating.rating = 5;
        rating.user = "test";

        answer.ratings.add(rating);

        entity.answers.add(answer);
        entity.question = question;
        return entity;
    }

    void loadData(){
        FaqEntity e = createRandomEntity();
        repository.save(e);
    }
}
