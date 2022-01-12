package ch.bissbert.hibernatebasics.data;

import javax.persistence.*;
import java.util.List;

/**
 * a simple class having an {@link Integer} id, a list of items({@link Item}) and {@link String} name
 * The id should be automatically incremented
 */
@Entity
@Table(name = "cupboard")
public class Cupboard {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "cupboard")
    private List<Item> items;

    @Column(name = "name")
    private String name;
}
