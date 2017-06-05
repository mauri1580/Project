package com.team1.bb.core.donation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team1.bb.core.center.Center;
import com.team1.bb.core.donor.Donor;
import com.team1.bb.core.employee.Employee;
import com.team1.bb.core.request.Request;
import com.team1.bb.core.test.Test;
import org.joda.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by caleb_000 on 4/26/2017.
 */
@Entity
public class Donation implements Comparable<Donation> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Boolean viability;

    @Column(name = "draw_date")
    private LocalDate drawDate = LocalDate.now();

    @JsonIgnore
    @ManyToOne
    private Donor donor;

    @ManyToOne
    private Employee drawer;

    @ManyToOne
    private Center donationCenter;

    @JsonIgnore
    @OneToMany(mappedBy = "donation", fetch = FetchType.EAGER)
    private Set<Test> test = new HashSet<>();

    @ManyToOne
    private Request request;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getViability() {
        return viability;
    }

    public void setViability(Boolean viability) {
        this.viability = viability;
    }

    public LocalDate getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(LocalDate drawDate) {
        this.drawDate = drawDate;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Employee getDrawer() {
        return drawer;
    }

    public void setDrawer(Employee drawer) {
        this.drawer = drawer;
    }

    public Center getDonationCenter() {
        return donationCenter;
    }

    public void setDonationCenter(Center donationCenter) {
        this.donationCenter = donationCenter;
    }

    public Set<Test> getTest() {
        return test;
    }

    public void setTest(Set<Test> test) {
        this.test = test;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Donation withId(final long id) {
        setId(id);
        return this;
    }

    public Donation withViability(final Boolean viability) {
        setViability(viability);
        return this;
    }

    public Donation withDrawDate(final LocalDate drawDate) {
        setDrawDate(drawDate);
        return this;
    }

    public Donation withDonor(final Donor donor) {
        setDonor(donor);
        return this;
    }

    public Donation withDrawer(final Employee drawer) {
        setDrawer(drawer);
        return this;
    }

    public Donation withDonationCenter(final Center donationCenter) {
        setDonationCenter(donationCenter);
        return this;
    }

    public Donation withTest(final Set<Test> test) {
        setTest(test);
        return this;
    }

    public Donation withRequest(final Request request) {
        setRequest(request);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Donation donation = (Donation) o;

        if (id != donation.id) return false;
        if (viability != null ? !viability.equals(donation.viability) : donation.viability != null) return false;
        if (drawDate != null ? !drawDate.equals(donation.drawDate) : donation.drawDate != null) return false;
        if (donor != null ? !donor.equals(donation.donor) : donation.donor != null) return false;
        if (drawer != null ? !drawer.equals(donation.drawer) : donation.drawer != null) return false;
        if (donationCenter != null ? !donationCenter.equals(donation.donationCenter) : donation.donationCenter != null)
            return false;
        if (test != null ? !test.equals(donation.test) : donation.test != null) return false;
        return request != null ? request.equals(donation.request) : donation.request == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (viability != null ? viability.hashCode() : 0);
        result = 31 * result + (drawDate != null ? drawDate.hashCode() : 0);
        result = 31 * result + (donor != null ? donor.hashCode() : 0);
        result = 31 * result + (drawer != null ? drawer.hashCode() : 0);
        result = 31 * result + (donationCenter != null ? donationCenter.hashCode() : 0);
        result = 31 * result + (test != null ? test.hashCode() : 0);
        result = 31 * result + (request != null ? request.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Donation o) {
        return this.drawDate.compareTo(o.drawDate);
    }

    @Override
    public String toString() {
        return "Donation{" +
            "id=" + id +
            ", viability=" + viability +
            ", drawDate=" + drawDate +
            ", donor=" + donor +
            ", drawer=" + drawer +
            ", donationCenter=" + donationCenter +
            ", test=" + test +
            ", request=" + request +
            '}';
    }
}
