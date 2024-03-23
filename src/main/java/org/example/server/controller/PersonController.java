package org.example.server.controller;

import org.example.server.Service.PersonSevice;
import org.example.server.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {
    @Autowired
    PersonSevice personSevice;
    @PostMapping("/test")
    public List<Person> getPerson(@RequestParam Integer id) {
        return personSevice.getPerson(id);
    }
}
