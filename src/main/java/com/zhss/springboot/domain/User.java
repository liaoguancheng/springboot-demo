package com.zhss.springboot.domain;

import com.zhss.springboot.validator.Age;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age);
    }

    public interface Save{}
    public interface Update {}

    @NotNull(groups = {Update.class})
    @Null(groups = Save.class)
    private Long id;

    @Size(min = 3, max = 20, groups = {Save.class, Update.class})
    private String name;

    @Age(min = 1, max = 200, groups = {Save.class, Update.class})
    private Integer age;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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


}
