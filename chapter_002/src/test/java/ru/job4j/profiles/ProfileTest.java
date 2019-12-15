package ru.job4j.profiles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {
    List<Address> addresses = new ArrayList<>();
    List<Profile> profiles = new ArrayList<>();
    @Test
    public void getAddressList() {
        Profiles profiles = new Profiles();
        this.createProfiles();
        List<Address> expected = this.addresses;
        assertThat(expected, is(profiles.collect(this.profiles)));
    }
    public void createProfiles() {
        Address add1 = new Address("City1", "street1", 1, 1);
        Profile prof1 = new Profile();
        prof1.setAddress(add1);
        this.addresses.add(add1);
        Address add2 = new Address("City2", "street2", 2, 2);
        Profile prof2 = new Profile();
        this.addresses.add(add2);
        prof2.setAddress(add2);
        this.profiles.add(prof1);
        this.profiles.add(prof2);
    }
}
