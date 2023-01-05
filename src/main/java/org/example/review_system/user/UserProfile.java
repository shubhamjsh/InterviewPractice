package org.example.review_system.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    private String userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String userName;
    private UserLocation location;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogIn;
    private VerificationStatus status;
}
