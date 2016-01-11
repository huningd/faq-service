package de.muenchen.service.domain

import org.hibernate.envers.Audited
import org.hibernate.search.annotations.Field
import org.hibernate.search.annotations.Indexed
import org.hibernate.search.annotations.IndexedEmbedded

import javax.persistence.*
import javax.validation.constraints.NotNull

/**
 * Created by dennis_huning on 05.01.16.
 */
@Entity
@Table(name = "FAQ")
@Indexed
@Audited
class FaqEntity extends BaseEntity {

    @Field
    String topic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUESTION_ID")
    @NotNull
    @IndexedEmbedded
    QuestionEntity question;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
            (
                    name = "FAQ_ANSWER",
                    joinColumns = [@JoinColumn(name = "FAQ_ID", referencedColumnName = "OID")],
                    inverseJoinColumns = [@JoinColumn(name = "ANSWER_ID", referencedColumnName = "OID", unique = true)]
            )
    @IndexedEmbedded
    Set<AnswerEntity> answers;
}
