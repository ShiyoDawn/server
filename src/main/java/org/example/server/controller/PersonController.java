package org.example.server.controller;

import org.example.server.Service.PersonService;
import org.example.server.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {
    @Autowired
    PersonService personSevice;
//    @PostMapping("/test")
//    public Optional<Person> getPerson(@RequestParam Integer id) {
//        return personSevice.getPerson(id);
//    }
}
