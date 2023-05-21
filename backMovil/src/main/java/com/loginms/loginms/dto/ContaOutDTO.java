package com.loginms.loginms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContaOutDTO {

    private Long totalPagina;
    private List<ContabilidadOutDTO> contaOutList;

}
