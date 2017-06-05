package com.team1.bb.core.center;

import javax.persistence.*;

@Entity
public class CenterType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private String name;

    @Column()
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CenterType withId(final long id) {
        setId(id);
        return this;
    }

    public CenterType withName(final String name) {
        setName(name);
        return this;
    }

    public CenterType withDescription(final String description) {
        setDescription(description);
        return this;
    }


}
