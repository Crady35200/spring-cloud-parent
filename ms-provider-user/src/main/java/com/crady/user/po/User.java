package com.crady.user.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author :Crady
 * date :2019/6/19 16:16
 * desc :
 **/
@Data
public class User implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private Character sex;
}
