package ru.job4j.profiles;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {
    List<Address> addresses = new ArrayList<>();
    List<Profile> profiles = new ArrayList<>();
    @Test
    public void getAddressList() {
        Profiles profiles = new Profiles();
        this.createProfiles();
       /* List<Address> expected = this.addresses.sort(new Comparator<Address>() {
            @Override
            public int compare(Address o1, Address o2) {
                return o1.compareTo(o2);
            }
        });*/
        List<Address> expected = new ArrayList<Address>();
        expected.add(new Address("City1", "street1", 1, 1));
        expected.add(new Address("НCity2", "street2", 2, 2));
        expected.add(new Address("ACity1", "street1", 1, 1));
        expected.add(new Address("BCity1", "street1", 1, 1));
        expected.add(new Address("BCity1", "street1", 1, 1));
        //expected.stream().distinct().sorted().collect(Collectors.toList());

        assertThat(expected.stream().distinct().sorted().collect(Collectors.toList()), is(profiles.collect(this.profiles)));
    }
    public void createProfiles() {
        Address add1 = new Address("City1", "street1", 1, 1);
        Profile prof1 = new Profile();
        prof1.setAddress(add1);
        this.addresses.add(add1);
        Address add2 = new Address("НCity2", "street2", 2, 2);
        Profile prof2 = new Profile();
        this.addresses.add(add2);
        prof2.setAddress(add2);

        Address add3 = new Address("ACity1", "street1", 1, 1);
        Profile prof3 = new Profile();
        prof3.setAddress(add3);
        this.addresses.add(add3);

        Address add4 = new Address("BCity1", "street1", 1, 1);
        Profile prof4 = new Profile();
        prof4.setAddress(add4);
        this.addresses.add(add4);

        Address add5 = new Address("BCity1", "street1", 1, 1);
        Profile prof5 = new Profile();
        prof5.setAddress(add5);
        this.addresses.add(add5);

        this.profiles.add(prof1);
        this.profiles.add(prof2);
        this.profiles.add(prof3);
        this.profiles.add(prof4);
        this.profiles.add(prof5);
    }
}
