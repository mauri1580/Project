package com.team1.bb.core.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team1.bb.core.authority.Authority;
import com.team1.bb.core.center.Center;
import com.team1.bb.core.embeddable.CommonFields;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(name = "first_name", nullable = false, length = 35)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 35)
    private String lastName;

    @JsonIgnore
    @Embedded
    private CommonFields commonFields;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_x_authority",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")
    )
    private final List<Authority> authorities = new ArrayList<>();

    @ManyToOne
    private Center center;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("ROLE_USER");
        authorityList.addAll(authorities);
        return authorityList;
    }

    public void setAuthorities(List<Authority> authorities) {
        authorities.addAll(authorities);
    }

    public CommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(CommonFields commonFields) {
        this.commonFields = commonFields;
    }


    public Employee withId(final Long id) {
        setId(id);
        return this;
    }

    public Employee withEmail(final String email) {
        setEmail(email);
        return this;
    }

    public Employee withPassword(final String password) {
        setPassword(password);
        return this;
    }

    public Employee withFirstName(final String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Employee withLastName(final String lastName) {
        setLastName(lastName);
        return this;
    }

    public Employee withCommonFields(final CommonFields commonFields) {
        setCommonFields(commonFields);
        return this;
    }

    public Employee withAuthorities(final List<Authority> authorities) {
        setAuthorities(authorities);
        return this;
    }

    public Employee withAuthority(final Authority authority) {
        authorities.add(authority);
        return this;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public Employee withCenter(final Center center) {
        setCenter(center);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (password != null ? !password.equals(employee.password) : employee.password != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        return lastName != null ? lastName.equals(employee.lastName) : employee.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
