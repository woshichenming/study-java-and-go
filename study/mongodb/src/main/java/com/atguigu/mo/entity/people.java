package com.atguigu.mo.entity;


import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ：chenming
 * @date ：Created in 2021/4/22 15:52
 * @description：
 * @modified By：
 * @version: $
 */
@Document("collection1")
public class people {
    private  String id ;
    private String name ;
    private  int age ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "people{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

}
