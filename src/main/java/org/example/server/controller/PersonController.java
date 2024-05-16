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

    @PostMapping("/updatePhoto")
    public Result updatePhoto(@Valid @RequestBody DataRequest dataRequest) {
        String person_num = dataRequest.getString("person_num");
        byte[] photo = dataRequest.getBytes("photo");
        return personSevice.updatePhoto(person_num, photo);
    }

    @PostMapping("/selectPhoto")
    public Result selectPhoto(@Valid @RequestBody DataRequest dataRequest) {
        String person_num = dataRequest.getString("person_num");
        return personSevice.selectPhoto(person_num);
    }

    @PostMapping("/addPerson")
    public Result addPerson(@Valid @RequestBody DataRequest dataRequest) {
        String person_name = dataRequest.getString("person_name");
        String phone_number = dataRequest.getString("phone_number");
        String identity = dataRequest.getString("identity");
        String person_num = dataRequest.getString("person_num");
        String birthday = dataRequest.getString("birthday");
        String user_type = dataRequest.getString("user_type");
        String department = dataRequest.getString("department");
        String email = dataRequest.getString("email");
        String identity_number = dataRequest.getString("identity_number");
        Integer gender_id = dataRequest.getInteger("gender_id");
        //byte[] photo = dataRequest.getBytes("photo");
        personSevice.addPerson(person_name, phone_number, identity, person_num, birthday, user_type, department, email, identity_number, gender_id);
        return Result.ok("添加成功！");
    }

    @PostMapping("/updatePerson")
    public Result updatePerson(@Valid @RequestBody DataRequest dataRequest) {
        Integer id = dataRequest.getInteger("id");
        String person_name = dataRequest.getString("person_name");
        String phone_number = dataRequest.getString("phone_number");
        String identity = dataRequest.getString("identity");
        String person_num = dataRequest.getString("person_num");
        String birthday = dataRequest.getString("birthday");
        String user_type = dataRequest.getString("user_type");
        String department = dataRequest.getString("department");
        String email = dataRequest.getString("email");
        String identity_number = dataRequest.getString("identity_number");
        Integer gender_id=dataRequest.getInteger("gender_id");
        personSevice.updatePerson(id, person_name, phone_number, identity, person_num, birthday, user_type, department, email, identity_number,gender_id);
        return Result.ok("修改成功！");
    }
    @PostMapping("/deletePerson")
    public Result deletePerson(@Valid @RequestBody DataRequest dataRequest) {
        Integer id = dataRequest.getInteger("id");
        personSevice.deletePerson(id);
        return Result.ok("删除成功！");
    }
}
