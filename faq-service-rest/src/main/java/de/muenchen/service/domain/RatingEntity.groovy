package de.muenchen.service.domain

import org.hibernate.envers.Audited
import org.hibernate.search.annotations.Field

import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

/**
 * Created by dennis_huning on 05.01.16.
 */
@Entity
@Table(name = "Rating")
@Audited
class RatingEntity extends BaseEntity {

    @Field
    String user;

    @Field
    @Max(5l)
    @Min(0l)
    @NotNull
    Short rating;
}
