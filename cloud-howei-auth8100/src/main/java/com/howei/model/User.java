package com.howei.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 登录用户信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User   {

    private Long id;

    private String name;

    private String username;

    private String password;





}
