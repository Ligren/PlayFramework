package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import play.data.validation.*;
import play.db.ebean.Model;

@Entity
public class Category extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String title;

    @OneToMany(mappedBy="category")
    public List<Job> jobs;

    public static Finder<Long,Category> find = new Finder (
            Long.class, Category.class
    );

    public static List<Category> all() {
        return find.all();
    }
}