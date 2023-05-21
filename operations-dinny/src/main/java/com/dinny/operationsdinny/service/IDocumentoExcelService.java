package com.dinny.operationsdinny.service;

import com.dinny.operationsdinny.dto.ContabilidadConsultDTO;
import com.dinny.operationsdinny.dto.ContabilidadConsultInDTO;
import com.dinny.operationsdinny.dto.DocumentoBse64DTO;

import java.text.ParseException;
import java.util.List;

public interface IDocumentoExcelService {

    /**
     * repote
     *
     * @param contabilidadConsultInDTO Parametro de entrada
     * @return DocumentoBse64DTO
     * @throws ParseException Error
     */
    DocumentoBse64DTO repote(ContabilidadConsultInDTO contabilidadConsultInDTO) throws ParseException;


    /**
     * repoteDatos
     * @param contabilidadConsultInDTO Parametro de entrada
     * @return List<ContabilidadConsultDTO>
     * @throws ParseException Error
     */
    List<ContabilidadConsultDTO> repoteDatos(
            ContabilidadConsultInDTO contabilidadConsultInDTO) throws ParseException;
}
