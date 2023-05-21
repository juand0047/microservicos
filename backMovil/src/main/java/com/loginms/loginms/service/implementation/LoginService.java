package com.loginms.loginms.service.implementation;

import com.loginms.loginms.dto.LoginConsultDTO;
import com.loginms.loginms.dto.LoginInDTO;
import com.loginms.loginms.repository.UsuarioRepository;
import com.loginms.loginms.service.ILoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoginService implements ILoginService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Boolean login(LoginInDTO loginInDTO) throws NullPointerException {
        if (Objects.isNull(loginInDTO)){
            throw new NullPointerException("Informacion de ingreso no puede llegar nula.");
        }

        LoginConsultDTO consultDTO = usuarioRepository.loginIn(loginInDTO.getUsuario());
        if (Objects.isNull(consultDTO)){
            throw new NullPointerException("Usuario no encontrado o no existe.");
        }

        byte[] bytesDecodificados = Base64.getDecoder().decode(consultDTO.getPassword());
        String cadenaDecodificada = new String(bytesDecodificados);

        System.out.println(consultDTO.getUse() + " " + consultDTO.getPassword() + " " + cadenaDecodificada);
        System.out.println(loginInDTO.getUsuario() + " " + loginInDTO.getContrasena());

        if (loginInDTO.getUsuario().equals(consultDTO.getUse()) &&
                loginInDTO.getContrasena().equals(cadenaDecodificada)){
            return true;
        }

        return false;

    }
}
