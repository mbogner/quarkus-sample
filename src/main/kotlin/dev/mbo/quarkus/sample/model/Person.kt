package dev.mbo.quarkus.sample.model

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.ws.rs.NotFoundException

@Entity
class Person : PanacheEntityBase() {

    @Id
    @SequenceGenerator(name = "personSequence", sequenceName = "person_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personSequence")
    var id: Int? = null
    var name: String? = null
    var birth: LocalDate? = null
    var status: Status? = null

    @Suppress("RemoveRedundantQualifierName")
    companion object {

        fun findByName(name: String): Person {
            return PanacheEntityBase.find<Person>("name", name).firstResult()
        }

        fun listAll(): List<Person> {
            return PanacheEntityBase.listAll()
        }

        fun findById(id: Int): Person {
            return PanacheEntityBase.findById(id) ?: throw NotFoundException()
        }

        fun deleteById(id: Int) {
            findById(id).delete()
        }

        fun count(): Long {
            return PanacheEntityBase.count()
        }
    }
}
