package com.arachidsocial.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by yassine on 2017-05-17.
 */
@Document(collection = "users")
public class User implements UserDetails {
    // For hashing the passwords
    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    @Id
    //The username is the email
    private String username;
    private String password;
    private String firstName, LastName, address, city, postalCode, province, country, imgURL;
    //Mandatory when you want to use Spring Security. But we will not use them.
    private boolean accountNonExpired, accountNonLocked, credentialsNonExpired, enabled;
    private List<String> authorities = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private ArrayList<String> friendRequestsReceived = new ArrayList<>();
    private ArrayList<String> friendRequestsSent = new ArrayList<>();
    private ArrayList<String> friends = new ArrayList<>();
    private PasswordResetVoucher passwordResetVoucher;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(String.valueOf(this.authorities));
    }

    public void grantAuthority(String authority) {
        this.authorities.add(authority);
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public ArrayList<String> getFriendRequestsReceived() {
        return friendRequestsReceived;
    }

    public void setFriendRequestsReceived(ArrayList<String> friendRequestsReceived) {
        this.friendRequestsReceived = friendRequestsReceived;
    }

    public ArrayList<String> getFriendRequestsSent() {
        return friendRequestsSent;
    }

    public void setFriendRequestsSent(ArrayList<String> friendRequestsSent) {
        this.friendRequestsSent = friendRequestsSent;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    public void addTicket(Ticket ticket){
        ArrayList<Ticket> tickets = this.getTickets();
        tickets.add(ticket);
        this.setTickets(tickets);
    }

    public void removeTicket(Ticket ticket){
        ArrayList<Ticket> tickets = this.getTickets();
        tickets.remove(ticket);
        this.setTickets(tickets);
    }
}