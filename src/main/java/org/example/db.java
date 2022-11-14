package org.example;

import org.example.repository.UserRepository;
import java.sql.Connection;
import java.sql.DriverManager;

public class db {
    public static UserRepository userRepository = new UserRepository();
}
