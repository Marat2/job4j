package ru.job4j.profiles;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        List<Address> addresses =  profiles.stream().map(Profile::getAddress).distinct().sorted().collect(Collectors.toList());
        System.out.println(addresses.toString());
        return addresses;
    }
}
