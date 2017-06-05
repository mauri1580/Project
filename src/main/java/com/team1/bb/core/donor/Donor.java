package com.team1.bb.core.donor;

import com.team1.bb.core.donation.Donation;
import com.team1.bb.core.embeddable.Address;
import com.team1.bb.core.embeddable.CommonFields;
import org.hibernate.annotations.SortNatural;
import org.joda.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by caleb on 4/25/2017.
 */
@Entity
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false, length = 35)
    private String firstName;

    @Column(name = "middle_initial", length = 1)
    private String middleInitial;

    @Column(name = "last_name", nullable = false, length = 35)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 11)
    private String phoneNumber;

    @Column(name = "blood_type", length = 3)
    private String bloodType;

    @Embedded
    private Address address;

    @Column
    private Boolean eligibility;

    @Embedded
    private CommonFields commonFields;

    @OneToMany(mappedBy = "donor", fetch = FetchType.EAGER)
    @SortNatural
    private SortedSet<Donation> donations = new TreeSet<>();

    @Transient
    private Boolean canDonateAgain;

    public Boolean getCanDonateAgain() {
        return canDonateAgain;
    }

    public void setCanDonateAgain(Boolean canDonateAgain) {
        this.canDonateAgain = canDonateAgain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getEligibility() {
        return eligibility;
    }

    public void setEligibility(Boolean eligibility) {
        this.eligibility = eligibility;
    }

    public CommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(CommonFields commonFields) {
        this.commonFields = commonFields;
    }

    public Donor withId(final Long id) {
        setId(id);
        return this;
    }

    public Donor withFirstName(final String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Donor withMiddleInitial(final String middleInitial) {
        setMiddleInitial(middleInitial);
        return this;
    }

    public Donor withLastName(final String lastName) {
        setLastName(lastName);
        return this;
    }

    public Donor withDateOfBirth(final LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public Donor withBloodType(final String bloodType) {
        setBloodType(bloodType);
        return this;
    }

    public Donor withEmail(final String email) {
        setEmail(email);
        return this;
    }


    public Donor withAddress(final Address address) {
        setAddress(address);
        return this;
    }

    public Donor withEligibility(final Boolean eligibility) {
        setEligibility(eligibility);
        return this;
    }

    public Donor withCommonFields(final CommonFields commonFields) {
        setCommonFields(commonFields);
        return this;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Donation> getDonations() {
        return donations;
    }

    public Donor withPhoneNumber(final String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Donor donor = (Donor) o;

        if (id != donor.id) return false;
        if (firstName != null ? !firstName.equals(donor.firstName) : donor.firstName != null) return false;
        if (middleInitial != null ? !middleInitial.equals(donor.middleInitial) : donor.middleInitial != null)
            return false;
        if (lastName != null ? !lastName.equals(donor.lastName) : donor.lastName != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(donor.dateOfBirth) : donor.dateOfBirth != null) return false;
        if (email != null ? !email.equals(donor.email) : donor.email != null) return false;
        if (bloodType != null ? !bloodType.equals(donor.bloodType) : donor.bloodType != null) return false;
        if (address != null ? !address.equals(donor.address) : donor.address != null) return false;
        return eligibility != null ? eligibility.equals(donor.eligibility) : donor.eligibility == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleInitial != null ? middleInitial.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (bloodType != null ? bloodType.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (eligibility != null ? eligibility.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Donor{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", middleInitial='" + middleInitial + '\'' +
            ", lastName='" + lastName + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            ", bloodType='" + bloodType + '\'' +
            ", address=" + address +
            ", eligibility=" + eligibility +
            ", commonFields=" + commonFields +
            '}';
    }
}
