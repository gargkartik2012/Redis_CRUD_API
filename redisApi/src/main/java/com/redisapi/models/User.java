package com.redisapi.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {

    private String userId;
    private String name;

    private String phone;
    private String email;


}
