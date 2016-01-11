package de.muenchen.service.domain

import org.hibernate.envers.Audited
import org.hibernate.search.annotations.Field

import javax.persistence.Entity
import javax.persistence.Table

/**
 * Created by dennis_huning on 05.01.16.
 */
@Entity
@Table(name = "Question")
@Audited
class QuestionEntity extends BaseEntity {

    @Field
    String text;

}
