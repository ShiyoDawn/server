package org.example.server.Service;

import org.example.server.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonMapper personMapper;//注入人员数据；

}
