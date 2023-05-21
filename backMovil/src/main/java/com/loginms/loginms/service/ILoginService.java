package com.loginms.loginms.service;

import com.loginms.loginms.dto.LoginInDTO;

public interface ILoginService {

    /**
     * login
     * @param loginInDTO Parametro de entrada
     * @return Boolean
     * @throws NullPointerException Error
     */
    Boolean login(LoginInDTO loginInDTO) throws NullPointerException;

}
