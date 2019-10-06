package com.example.demo.controller;

import com.example.demo.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/save")
    public String save(){
        for(int i=0;i<100;i++){
            Person person=new Person();
            person.setId(i);
            person.setName("瓜田李下"+i);
            person.setAge(i%10+15);

            mongoTemplate.save(person);
        }

        return "success";
    }

    @RequestMapping("/get")
    public List<Person> get(){
        Query query=Query.query(Criteria.where("age").gte(18));
        return mongoTemplate.find(query,Person.class);
    }
}