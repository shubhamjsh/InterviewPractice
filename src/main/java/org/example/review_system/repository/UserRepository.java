package org.example.review_system.repository;

import org.example.review_system.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    public static List<User> users = new ArrayList<>();
    public static Map<String, User> userMap = new HashMap<>();
}
