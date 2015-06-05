package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Skill extends Model {

    @Id
    private Integer id;
	
	@OneToOne(mappedBy="skill")
    @Column(nullable = false, length = 50)
    @Constraints.Required
    public String name;

    public static Finder<Integer, Skill> find = new Finder (Integer.class, Skill.class);

    public static List<Skill> all() { return find.all(); }
	
}
