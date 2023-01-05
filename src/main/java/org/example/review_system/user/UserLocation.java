package org.example.review_system.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLocation {
    private String userId;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String state;
    private String pin;
}
