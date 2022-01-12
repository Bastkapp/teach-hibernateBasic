package ch.bissbert.hibernatebasics.data;

import javax.persistence.*;

/**
 * a simple class that only contains an {@link Integer} id and a {@link String} name
 * the id should be automatically incremented
 */
@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "Cupboard_ID")
    @ManyToOne
    private Cupboard cupboard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cupboard getCupboard() {
        return cupboard;
    }

    public void setCupboard(Cupboard cupboard) {
        this.cupboard = cupboard;
    }


}
