package net.biancheng.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Website {
    private int id;
    private String name;
    private String url;
    private int age;
    private String country;
    private Date createtime;

    private int pageNo=0;
    private int pageSize=10;

    @Override
    public String toString() {
        return "id" + id + "name" + name + "url" + url + "age" + age + "country" + country + "createtime" + createtime;
    }
}