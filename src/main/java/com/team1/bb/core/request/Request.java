package com.team1.bb.core.request;

import com.team1.bb.core.center.Center;
import com.team1.bb.core.donation.Donation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caleb_000 on 4/26/2017.
 */
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "request", fetch = FetchType.EAGER)
    private List<Donation> donations = new ArrayList<>();

    @ManyToOne
    private Center requestCenter;

    @Column(nullable = false)
    private Integer amount;

    @Column(name = "blood_type", length = 2)
    private String bloodType;

    @Column
    private Boolean fulfilled;

}
