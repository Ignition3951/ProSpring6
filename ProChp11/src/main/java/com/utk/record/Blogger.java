package com.utk.record;

import java.time.LocalDate;

public record Blogger(String firstName, String lastName, LocalDate birthDate, java.net.URL personalSite) {

}
