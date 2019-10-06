package com.example.demo.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "person")
public class Person {

    private Integer id;
    private String name;
    private Integer age;
}
