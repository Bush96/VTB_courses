package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Thing")
public class Thing {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "val")
    private int val;

    public Thing(){

    }

    public Thing( int val) {
        this.val = val;
    }


    public int getId() {
        return id;
    }

    public int getVal() {
        return val;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "id=" + id +
                ", val=" + val +
                '}';
    }
}
