package com.team1.bb.core.center;

import com.team1.bb.core.embeddable.Address;

import javax.persistence.*;

/**
 * Created by caleb on 4/25/2017.
 */
@Entity
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private String name;

    @Embedded
    private Address address;

    @ManyToOne
    private CenterType type;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



    public Center withId(final long id) {
        setId(id);
        return this;
    }

    public Center withName(final String name) {
        setName(name);
        return this;
    }

    public Center withAddress(final Address address) {
        setAddress(address);
        return this;
    }

    public CenterType getType() {
        return type;
    }

    public void setType(CenterType type) {
        this.type = type;
    }

    public Center withType(final CenterType type) {
        setType(type);
        return this;
    }


}
