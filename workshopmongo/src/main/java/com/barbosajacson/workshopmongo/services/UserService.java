package com.barbosajacson.workshopmongo.services;

import com.barbosajacson.workshopmongo.domain.User;
import com.barbosajacson.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
@Autowired
private UserRepository repo;
    public List<User> findAll() {
return repo.findAll();

    }
}
