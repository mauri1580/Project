package com.team1.bb;

import com.team1.bb.core.authority.Authority;
import com.team1.bb.core.authority.AuthorityRepository;
import com.team1.bb.core.center.Center;
import com.team1.bb.core.center.CenterRepository;
import com.team1.bb.core.center.CenterType;
import com.team1.bb.core.center.CenterTypeRepository;
import com.team1.bb.core.donation.Donation;
import com.team1.bb.core.donation.DonationRepository;
import com.team1.bb.core.donation.DonationService;
import com.team1.bb.core.donor.Donor;
import com.team1.bb.core.donor.DonorRepository;
import com.team1.bb.core.embeddable.Address;
import com.team1.bb.core.embeddable.CommonFields;
import com.team1.bb.core.employee.Employee;
import com.team1.bb.core.employee.EmployeeRepository;
import com.team1.bb.core.test.Test;
import com.team1.bb.core.test.TestType;
import com.team1.bb.core.test.TestTypeRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdebnath on 4/30/17.
 */
@Component
public class SeedDatabase {

    private List<Donation> donations;
    private List<Authority> authorities;
    private List<Employee> employees;
    private List<Donor> donors;
    private List<CenterType> centerTypes;
    private List<Center> centers;
    private List<TestType> testTypes;
    private List<Test> tests;

    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private CenterTypeRepository centerTypeRepository;

    @Autowired
    private CenterRepository centerRepository;

    @Autowired
    private TestTypeRepository testTypeRepository;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private DonationService donationService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public SeedDatabase() {
        authorities = new ArrayList<>();
        employees = new ArrayList<>();
        donors = new ArrayList<>();
        donations = new ArrayList<>();
        centerTypes = new ArrayList<>();
        centers = new ArrayList<>();
        testTypes = new ArrayList<>();
        tests = new ArrayList<>();
    }

    @PostConstruct
    public void run(){
        seedAuthorities();
        seedCenter();
        seedEmployees();
        seedDonors();
        seedDonations();
        seedTests();
    }

    private void seedTests() {
        testTypes.add(new TestType()
            .withId(1)
            .withName("STD")
            .withDescription("Check for STDS"));

        testTypes.add(new TestType()
            .withId(2)
            .withName("ANEMIA")
            .withDescription("Check for low iron count"));

        testTypeRepository.save(testTypes);

        for (Donation donation : donationRepository.findAll()) {
            donationService.createTestForDonation(donation);
        }
    }

    private void seedCenter() {
        centerTypes.add(new CenterType()
            .withId(1)
            .withName("DONATION")
            .withDescription("Where blood donations are collected."));

        centerTypes.add(new CenterType()
            .withId(2)
            .withName("TESTING")
            .withDescription("Where blood donations are tested."));

        centerTypes.add(new CenterType()
            .withId(3)
            .withName("REQUEST")
            .withDescription("Where blood donations are requested."));

        centerTypeRepository.save(centerTypes);

        CommonFields commonFields = new CommonFields()
            .withCreatedById(0L)
            .withUpdatedById(0L);

        Address address = new Address()
            .withStreet("666 Testerson Avenue")
            .withCity("Hogwarts")
            .withState("CA")
            .withZipcode("54321");

        centers.add(new Center()
            .withId(1)
            .withName("Blood Drive 1")
            .withAddress(address)
            .withType(centerTypes.get(0))
        );

        centers.add(new Center()
            .withId(2)
            .withName("Testing Center 1")
            .withAddress(address)
            .withType(centerTypes.get(1))
        );

        centers.add(new Center()
            .withId(3)
            .withName("Hospital 1")
            .withAddress(address)
            .withType(centerTypes.get(2))
        );

        centers.add(new Center()
            .withId(4)
            .withName("Hospital 2")
            .withAddress(address)
            .withType(centerTypes.get(2))
        );

        centerRepository.save(centers);
    }

    private void seedAuthorities() {
        authorities.add(new Authority()
            .withId(1)
            .withName("ADMIN")
            .withDescription("Has admin privileges to access everything"));

        authorities.add(new Authority()
            .withId(2)
            .withName("DONATION")
            .withDescription("Has privileges to access donation services"));

        authorities.add(new Authority()
            .withId(3)
            .withName("TEST")
            .withDescription("Has privileges to access test services"));

        authorities.add(new Authority()
            .withId(4)
            .withName("REQUEST")
            .withDescription("Has privileges to access request services"));

        authorityRepository.save(authorities);
    }

    private void seedEmployees() {

        CommonFields commonFields = new CommonFields()
            .withCreatedById(0L)
            .withUpdatedById(0L);


        employees.add(new Employee()
            .withEmail("admin@bb.com")
            .withPassword(passwordEncoder.encode("password"))
            .withFirstName("Albus")
            .withLastName("Dumbledore")
            .withAuthority(authorityRepository.findByName("ADMIN"))
            .withAuthority(authorityRepository.findByName("DONATION"))
            .withAuthority(authorityRepository.findByName("TEST"))
            .withAuthority(authorityRepository.findByName("REQUEST"))
            .withCenter(centers.get(2))
            .withCommonFields(commonFields));

        employees.add(new Employee()
            .withEmail("donating@bb.com")
            .withPassword(passwordEncoder.encode("password"))
            .withFirstName("Harry")
            .withLastName("Potter")
            .withAuthority(authorityRepository.findByName("DONATION"))
            .withCenter(centers.get(0))
            .withCommonFields(commonFields));

        employees.add(new Employee()
            .withEmail("testing@bb.com")
            .withPassword(passwordEncoder.encode("password"))
            .withFirstName("Ronald")
            .withLastName("Weasely")
            .withAuthority(authorityRepository.findByName("TEST"))
            .withCenter(centers.get(1))
            .withCommonFields(commonFields));

        employees.add(new Employee()
            .withEmail("requesting@bb.com")
            .withPassword(passwordEncoder.encode("password"))
            .withFirstName("Hermoine")
            .withLastName("Granger")
            .withAuthority(authorityRepository.findByName("REQUEST"))
            .withCenter(centers.get(3))
            .withCommonFields(commonFields));

        employeeRepository.save(employees);
    }

    private void seedDonors() {
        CommonFields commonFields = new CommonFields()
            .withCreatedById(0L)
            .withUpdatedById(0L);

        Address address = new Address()
            .withStreet("123 Test Street")
            .withCity("Test")
            .withState("NY")
            .withZipcode("12345");

        donors.add(new Donor()
            .withFirstName("Subhrajit")
            .withMiddleInitial("")
            .withLastName("Debnath")
            .withDateOfBirth(new LocalDate(1995,10,22))
            .withBloodType("A+")
            .withEmail("sdebnath2@albany.edu")
            .withPhoneNumber("5183006497")
            .withAddress(address)
            .withEligibility(true)
            .withCommonFields(commonFields)
        );

        donors.add(new Donor()
            .withFirstName("Sub")
            .withMiddleInitial("")
            .withLastName("Deb")
            .withDateOfBirth(new LocalDate(1995,5,12))
            .withBloodType("AB+")
            .withEmail("sdeb@albany.edu")
            .withPhoneNumber("5183006497")
            .withAddress(address)
            .withEligibility(false)
            .withCommonFields(commonFields)
        );

        donors.add(new Donor()
            .withFirstName("Mauricio")
            .withMiddleInitial("E")
            .withLastName("Hernandez")
            .withDateOfBirth(new LocalDate(1995,10,22))
            .withBloodType("O-")
            .withEmail("mehernandez@albany.edu")
            .withPhoneNumber("6318270474")
            .withAddress(address)
            .withEligibility(true)
            .withCommonFields(commonFields)
        );

        donors.add(new Donor()
            .withFirstName("Caleb")
            .withMiddleInitial("B")
            .withLastName("Rodabaugh")
            .withDateOfBirth(new LocalDate(1995,10,22))
            .withBloodType("B+")
            .withEmail("crodabaugh@albany.edu")
            .withPhoneNumber("8154510023")
            .withAddress(address)
            .withEligibility(true)
            .withCommonFields(commonFields)
        );

        donors.add(new Donor()
            .withFirstName("Allan")
            .withMiddleInitial("A")
            .withLastName("Abraham")
            .withDateOfBirth(new LocalDate(1995,10,22))
            .withBloodType("A+")
            .withEmail("aabraham2@albany.edu")
            .withPhoneNumber("5183895298")
            .withAddress(address)
            .withEligibility(true)
            .withCommonFields(commonFields)
        );

        donors.add(new Donor()
            .withFirstName("Adam")
            .withMiddleInitial("")
            .withLastName("Lampl")
            .withDateOfBirth(new LocalDate(1995,10,22))
            .withBloodType("A+")
            .withEmail("alampl@albany.edu")
            .withPhoneNumber("6313278718")
            .withAddress(address)
            .withEligibility(true)
            .withCommonFields(commonFields)
        );

        donors.add(new Donor()
            .withFirstName("Dong")
            .withMiddleInitial("")
            .withLastName("Kim")
            .withDateOfBirth(new LocalDate(1995,10,22))
            .withBloodType("A+")
            .withEmail("dkim@albany.edu")
            .withPhoneNumber("5185678835")
            .withAddress(address)
            .withEligibility(true)
            .withCommonFields(commonFields)
        );

        donorRepository.save(donors);
    }

    private void seedDonations() {
        LocalDate date = new LocalDate(2017, 2, 10);

        donations.add(new Donation()
            .withId(1)
            .withDonor(donors.get(0))
            .withDrawer(employees.get(1))
            .withDonationCenter(employees.get(1).getCenter())
            .withDrawDate(date));

        donations.add(new Donation()
            .withId(2)
            .withDonor(donors.get(1))
            .withDrawer(employees.get(1))
            .withDonationCenter(employees.get(1).getCenter())
            .withDrawDate(date));

        donations.add(new Donation()
            .withId(3)
            .withDonor(donors.get(2))
            .withDrawer(employees.get(0))
            .withDonationCenter(employees.get(0).getCenter())
            .withDrawDate(date));

        donations.add(new Donation()
            .withId(4)
            .withDonor(donors.get(3))
            .withDrawer(employees.get(1))
            .withDonationCenter(employees.get(1).getCenter())
            .withDrawDate(date));

        donations.add(new Donation()
            .withId(5)
            .withDonor(donors.get(4))
            .withDrawer(employees.get(0))
            .withDonationCenter(employees.get(0).getCenter())
            .withDrawDate(date));

        donationRepository.save(donations);
    }




}
