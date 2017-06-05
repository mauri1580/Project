package com.team1.bb.core.test;

import com.team1.bb.core.center.Center;
import com.team1.bb.core.donation.Donation;
import com.team1.bb.core.employee.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by caleb_000 on 4/26/2017.
 */
@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Donation donation;

    @ManyToOne
    private Center testingCenter;

    @ManyToOne
    private Employee tester;

    @ManyToOne
    private TestType type;

    @Column
    private Boolean pass;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    public Center getTestingCenter() {
        return testingCenter;
    }

    public void setTestingCenter(Center testingCenter) {
        this.testingCenter = testingCenter;
    }

    public Employee getTester() {
        return tester;
    }

    public void setTester(Employee tester) {
        this.tester = tester;
    }

    public TestType getType() {
        return type;
    }

    public void setType(TestType type) {
        this.type = type;
    }

    public Boolean getPass() {
        return pass;
    }

    public void setPass(Boolean pass) {
        this.pass = pass;
    }

    public Test withId(final long id) {
        setId(id);
        return this;
    }

    public Test withDonation(final Donation donation) {
        setDonation(donation);
        return this;
    }

    public Test withTestingCenter(final Center testingCenter) {
        setTestingCenter(testingCenter);
        return this;
    }

    public Test withTester(final Employee tester) {
        setTester(tester);
        return this;
    }

    public Test withType(final TestType type) {
        setType(type);
        return this;
    }

    public Test withPass(final Boolean pass) {
        setPass(pass);
        return this;
    }


}
