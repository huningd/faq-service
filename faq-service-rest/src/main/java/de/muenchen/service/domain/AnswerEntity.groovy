package de.muenchen.service.domain

import org.hibernate.envers.Audited
import org.hibernate.search.annotations.Field

import javax.persistence.*

/**
 * Created by dennis_huning on 05.01.16.
 */
@Entity
@Table(name = "Answer")
@Audited
class AnswerEntity extends BaseEntity {

    @Field
    String text;

    @Field
    String user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
            (
                    name = "ANS_RATING",
                    joinColumns = [@JoinColumn(name = "ANS_ID", referencedColumnName = "OID")],
                    inverseJoinColumns = [@JoinColumn(name = "RATING_ID", referencedColumnName = "OID", unique = true)]
            )
    Set<RatingEntity> ratings;
}
