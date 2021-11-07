package dev.mbo.quarkus.sample.model

import dev.mbo.quarkus.sample.model.types.Status
import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import org.hibernate.validator.constraints.Length
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "persons")
class Person : PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "personSequence", sequenceName = "person_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personSequence")
    var id: Long? = null

    @NotBlank
    @Length(max = 255)
    @Column(name = "name", length = 255)
    var name: String? = null

    @NotNull
    @Column(name = "birth")
    var birth: LocalDate? = null

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 32)
    var status: Status? = null

    companion object : PanacheCompanion<Person> {

        fun findByName(name: String): Person? {
            return find("name", name).firstResult()
        }

    }
}
