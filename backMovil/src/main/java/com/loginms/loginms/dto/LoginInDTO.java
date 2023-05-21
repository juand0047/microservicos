package com.loginms.loginms.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginInDTO {

    private String usuario;
    private String contrasena;

}
