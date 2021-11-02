package dev.mbo.quarkus.sample.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.common.Parameters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Person extends PanacheEntityBase {

  @Id
  @SequenceGenerator(
    name = "personSequence",
    sequenceName = "person_id_seq",
    allocationSize = 1,
    initialValue = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personSequence")
  public Integer id;

  public String name;
  public LocalDate birth;
  public Status status;

  public static Person findByName(String name) {
    return find("name", name).firstResult();
  }

  public static List<Person> findAlive() {
    return list("status", Status.Alive);
  }

  public static void deleteStefs() {
    delete("name", "Stef");
  }

  public static List<Person> findAllLivingStef() {
    return Person.find("name = :name and status = :status",
        Parameters.with("name", "stef").and("status", Status.Alive).map())
      .list();
  }

}
