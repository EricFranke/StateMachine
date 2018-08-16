package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "JpaProcess")
@Table(name = "sm_process")
public class JpaProcess {

    @Id
    @GeneratedValue(generator = "process")
    @GenericGenerator(name = "process", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "num_transitions")
    private int counter;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ****************************************************************************************** //
    // ****************************************************************************************** //
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}