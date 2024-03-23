package org.example.server.Service;

import org.example.server.mapper.PersonMapper;
import org.example.server.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonSevice {
    @Autowired
    PersonMapper personMapper;
    public Optional<Person> getPerson(Integer id) {
        return personMapper.findById(id);
    }
}
