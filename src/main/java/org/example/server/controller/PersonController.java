package org.example.server.controller;

import org.example.server.Service.PersonService;
import org.example.server.payload.response.DataResponse;
import org.example.server.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {

    //id,person_name,gender_id,phone_number,identity,person_num,birthday,user_type,department,email,identity_number

    @Autowired
    PersonService personSevice;

    @GetMapping("/getPersonList")
    public DataResponse getPersonList() {
        return DataResponse.success(personSevice.getPersonList());
    }

    @PostMapping("/selectById")
    public DataResponse selectById(@Valid @RequestParam Integer id) {
        return DataResponse.success(personSevice.selectById(id));
    }

    @PostMapping("/selectByPersonNum")
    public DataResponse selectByPersonNum(@Valid @RequestParam String person_num) {
        return DataResponse.success(personSevice.selectByPersonNum(person_num));
    }

    @GetMapping("/selectSPersonById")
    public DataResponse selectSPersonById(@RequestParam Integer id){
        return DataResponse.success(personSevice.selectSPersonByIdMap(id));
    }
}
