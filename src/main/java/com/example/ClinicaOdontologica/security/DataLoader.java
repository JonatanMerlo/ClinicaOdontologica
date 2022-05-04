package com.example.ClinicaOdontologica.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;


    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordAdmin = passwordEncoder.encode("admin");
        String passwordUser = passwordEncoder.encode("user");

        userRepository.save(new AppUser("Jonatan", "admin","admin@admin.com",passwordAdmin, AppUsuarioRoles.ADMIN));
        userRepository.save(new AppUser("Juan", "user","user@user.com",passwordUser, AppUsuarioRoles.USER));

    }
}
