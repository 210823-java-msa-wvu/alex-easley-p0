package dev.easley.services;

import dev.easley.models.User;

import dev.easley.services.exception.InvalidCharacterException;
import dev.easley.services.repositories.UserRepo;


public class UserServices {

    UserRepo userRepo = new UserRepo();

    public void usernameValidation (String username) throws InvalidCharacterException {
        if (username.matches("[^a-zA-Z0-9]*")) {System.out.println(username);
            throw new InvalidCharacterException("No Special Characters");
        }

    }

    public boolean accountCreation(String username, String password, String user_type) throws InvalidCharacterException {
        usernameValidation(username);
        if (username.length() < 15) {
            userRepo.createAccount(username, password, user_type);
            return true;
        }
        return false;
    }

    public User getUser(String username) {

        return userRepo.getByUsername(username);
    }


    public boolean login(String username, String password) {


        User u = userRepo.getByUsername(username);


        if (u != null) {

            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }

}
