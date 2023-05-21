package com.dinny.operationsdinny.controller;

import com.dinny.operationsdinny.dto.ContabilidadConsultDTO;
import com.dinny.operationsdinny.dto.ContabilidadConsultInDTO;
import com.dinny.operationsdinny.dto.DocumentoBse64DTO;
import com.dinny.operationsdinny.service.IDocumentoExcelService;
import com.dinny.operationsdinny.utilities.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = Constantes.Urls.PATH_EXCEL)
public class DocumentoExcelController {

    @Autowired
    IDocumentoExcelService iDocumentoExcelService;

    /**
     * repote
     *
     * @param contabilidadConsultInDTO Parametro de entrada
     * @return DocumentoBse64DTO
     * @throws ParseException Error
     */
    @PostMapping
    public DocumentoBse64DTO repote(@RequestBody ContabilidadConsultInDTO contabilidadConsultInDTO) throws ParseException {
        return iDocumentoExcelService.repote(contabilidadConsultInDTO);
    }

    /**
     * repoteDatos
     *
     * @param contabilidadConsultInDTO Parametro de entrada
     * @return List<ContabilidadConsultDTO>
     * @throws ParseException Error
     */
    @PostMapping("/datos")
    public List<ContabilidadConsultDTO>
    repoteDatos(@RequestBody ContabilidadConsultInDTO contabilidadConsultInDTO) throws ParseException {
        return iDocumentoExcelService.repoteDatos(contabilidadConsultInDTO);
    }

}
