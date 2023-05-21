package com.dinny.operationsdinny.service.implementation;

import com.dinny.operationsdinny.dto.ContabilidadConsultDTO;
import com.dinny.operationsdinny.dto.ContabilidadConsultInDTO;
import com.dinny.operationsdinny.dto.DocumentoBse64DTO;
import com.dinny.operationsdinny.repository.ContabilidadRepository;
import com.dinny.operationsdinny.service.IDocumentoExcelService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DocumentoExcelService implements IDocumentoExcelService {

    private final ContabilidadRepository contabilidadRepository;

    @Override
    public DocumentoBse64DTO repote(ContabilidadConsultInDTO contabilidadConsultInDTO) throws ParseException {

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date fechaI = formatoFecha.parse(contabilidadConsultInDTO.getFechaI() + " 00:00:00");
        Date fechaF = formatoFecha.parse(contabilidadConsultInDTO.getFechaF() + " 23:59:59");

        List<Long> tipo = new ArrayList<>();

        if (contabilidadConsultInDTO.getTipo().equals("INGRESO")) {
            tipo.add(1L);
        } else if (contabilidadConsultInDTO.getTipo().equals("GASTO")) {
            tipo.add(2L);
        } else {
            tipo.add(1L);
            tipo.add(2L);
        }

        List<Map<String, ContabilidadConsultDTO>> listContabilidad =
                contabilidadRepository.listContabilidad(
                        contabilidadConsultInDTO.getUsuario(),
                        fechaI,
                        fechaF,
                        tipo
                );

        // Crear el libro de trabajo de Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Datos");

        // Escribir los encabezados de las columnas
        Row headerRow = sheet.createRow(0);
        int columnCount = 0;
        for (String columnName : listContabilidad.get(0).keySet()) {
            Cell headerCell = headerRow.createCell(columnCount++);
            headerCell.setCellValue(columnName);
        }

        int rowCount = 1;
        for (Map<String, ContabilidadConsultDTO> map : listContabilidad) {
            Row row = sheet.createRow(rowCount++);
            int cellCount = 0;
            for (Object obj : map.values()) {
                Cell cell = row.createCell(cellCount++);
                cell.setCellValue(obj.toString());
            }
        }

        // Autoajustar el ancho de las columnas
        for (int i = 0; i < columnCount; i++) {
            sheet.autoSizeColumn(i);
        }

        // Guardar el libro de trabajo de Excel en un archivo
        try (FileOutputStream outputStream = new FileOutputStream("datos.xlsx")) {

            workbook.write(outputStream);
            outputStream.close();
            Path path = Path.of("datos.xlsx");
            byte[] fileContent = Files.readAllBytes(path);
            String contraEncrip = Base64.getEncoder().encodeToString(fileContent);
            Files.delete(path);

            System.out.println(contraEncrip);

            return new DocumentoBse64DTO(contraEncrip);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<ContabilidadConsultDTO>
    repoteDatos(ContabilidadConsultInDTO contabilidadConsultInDTO) throws ParseException {

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date fechaI = formatoFecha.parse(contabilidadConsultInDTO.getFechaI() + " 00:00:00");
        Date fechaF = formatoFecha.parse(contabilidadConsultInDTO.getFechaF() + " 23:59:59");

        List<Long> tipo = new ArrayList<>();

        if (contabilidadConsultInDTO.getTipo().equals("INGRESO")) {
            tipo.add(1L);
        } else if (contabilidadConsultInDTO.getTipo().equals("GASTO")) {
            tipo.add(2L);
        } else {
            tipo.add(1L);
            tipo.add(2L);
        }

        List<ContabilidadConsultDTO> listContabilidad =
                contabilidadRepository.listContabilidad2(
                        contabilidadConsultInDTO.getUsuario(),
                        fechaI,
                        fechaF,
                        tipo
                );

        return listContabilidad;

    }
}