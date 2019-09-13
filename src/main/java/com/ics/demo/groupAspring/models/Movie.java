package com.ics.demo.groupAspring.models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="movies")
public class Movie {

    public Movie(){}
    public Movie(@NotNull(groups = Create.class) String name, String yearReleased, Set<Category> categories) {
        this.name = name;
        this.yearReleased = yearReleased;
        this.categories = categories;
    }

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    @Column(name = "name")
    @NotNull(groups = Create.class)
    private String name;

    @Column(name = "year_released")
    private String yearReleased;


    @ManyToMany(mappedBy = "movies")
    private Set<Category> categories;

//    public Movie(@NotNull(groups = Create.class) String name, String yearReleased) {
//        this.name = name;
//        this.yearReleased = yearReleased;
//        this.categories = categories;
//    }

//    public Movie(String name, String year) {
//        this.name = name;
//        this.yearReleased = year;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return yearReleased;
    }

    public void setYear(String year) {
        this.yearReleased = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearReleased='" + yearReleased + '\'' +
                ", categories=" + categories +
                '}';
    }

    public interface  Create{}
    public interface  Update{}
}
