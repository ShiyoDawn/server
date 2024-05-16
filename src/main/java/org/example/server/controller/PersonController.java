package org.example.server.controller;

import lombok.Data;
import org.example.server.Service.PersonService;
import org.example.server.payload.Result;
import org.example.server.payload.request.DataRequest;
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

    @PostMapping("/getAll")
    public Result getAll() {
        return Result.success(personSevice.getAll());
    }

    @PostMapping("/getPersonList")
    public Result getPersonList() {
        return personSevice.getPersonList();
    }

    @PostMapping("/selectById")
    public Result selectById(@Valid @RequestBody DataRequest dataRequest) {
        Integer id = dataRequest.getInteger("id");
        return personSevice.selectById(id);
    }

    @PostMapping("/selectByPersonNum")
    public Result selectByPersonNum(@Valid @RequestBody DataRequest dataRequest) {
        String person_num = dataRequest.getString("person_num");
        return personSevice.selectByPersonNum(person_num);
    }

    @PostMapping("/selectSPersonById")
    public Result selectSPersonById(@Valid @RequestBody DataRequest dataRequest) {
        Integer id = dataRequest.getInteger("id");
        return personSevice.selectSPersonByIdMap(id);
    }

//    @PostMapping("/updatePhoto")
//    public Result updatePhoto(@Valid @RequestBody DataRequest dataRequest) {
//        String person_num = dataRequest.getString("person_num");
//        byte[] photo = dataRequest.getBytes("photo");
//        return personSevice.updatePhoto(person_num, photo);
//    }

    @PostMapping("/selectPhoto")
    public Result selectPhoto(@Valid @RequestBody DataRequest dataRequest) {
        String person_num = dataRequest.getString("person_num");
        return personSevice.selectPhoto(person_num);
    }
}
