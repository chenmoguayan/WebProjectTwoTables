package org.qingqiao.bean;

/**
 * @author hj
 * @data 2023/2/1 16:00
 */
public class Animal {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Type type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Animal() {
    }

    public Animal(Integer id, String name, Integer age, String sex, Type type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.type = type;
    }
}
