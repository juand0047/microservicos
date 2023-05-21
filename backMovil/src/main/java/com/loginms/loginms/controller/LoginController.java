package com.loginms.loginms.controller;

import com.loginms.loginms.dto.LoginInDTO;
import com.loginms.loginms.service.ILoginService;
import com.loginms.loginms.utilities.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = Constantes.Urls.PATH_LOGIN)
public class LoginController {

    @Autowired
    private ILoginService iLoginService;

    /**
     * login
     *
     * @param loginInDTO Parametro de entrada
     * @return Boolean
     * @throws NullPointerException Error
     */
    @PostMapping()
    public Boolean login(@RequestBody LoginInDTO loginInDTO) throws NullPointerException {
        return iLoginService.login(loginInDTO);
    }

}
