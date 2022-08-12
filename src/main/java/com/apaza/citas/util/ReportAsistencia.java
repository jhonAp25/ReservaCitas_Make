package com.apaza.citas.util;


import com.apaza.citas.model.Asistencia;
import com.apaza.citas.model.Especialidad;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ReportAsistencia {

    private static final Logger logger = LoggerFactory.getLogger(ReportAsistencia.class);

    private static final Color COLOR_TEXT = new Color(39, 43, 48);
    private static final Color COLOR_TEXT_HINT = new Color(130, 132, 135);
    private static final Color COLOR_BG_HINT = new Color(198, 198, 198);

    private static final Color COLOR_BG_RED = new Color(255, 62, 96);
    private static final Color COLOR_BG_RED_DARK = new Color(155, 46, 65);

    private static final Color COLOR_BORDER_BLUE_DARK = new Color(54, 91, 115);

    private static final String FONT_FAMILY = FontFactory.HELVETICA;

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    String currentDate = dateFormat.format(new Date());
    Path pathStatic = Paths.get("src/main/resources/static");

    public ByteArrayOutputStream generateList(List<Asistencia> asisteniciaList, LocalDate date, Especialidad specialty, String status) {

        Document document = new Document(PageSize.A4.rotate(), 40, 40, 40, 40);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        boolean dateInd = date != null;
        boolean specialtyInd = specialty.getDescripcion() != null;
        boolean statusInd = status != null;

        try {
            // CABECERA

            PdfPTable tblHeader = new PdfPTable(3);
            tblHeader.setSpacingAfter(30);
            tblHeader.setWidthPercentage(100);
            tblHeader.setWidths(new int[]{25, 50, 25});

            Font titleFont = FontFactory.getFont(FONT_FAMILY, 22, Font.BOLD, COLOR_TEXT);
            Font dateFont = FontFactory.getFont(FONT_FAMILY, 11, Font.NORMAL, COLOR_TEXT);

            PdfPCell headerCell;

            Path pathLogoMake = pathStatic.resolve("logoMake.png").toAbsolutePath();
            Image logoMake = Image.getInstance(String.valueOf(pathLogoMake));
            logoMake.scaleToFit(100, 50);

            headerCell = new PdfPCell(logoMake);
            headerCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            headerCell.setBorderColor(Color.WHITE);
            headerCell.setVerticalAlignment(Element.ALIGN_CENTER);
            tblHeader.addCell(headerCell);

            headerCell = new PdfPCell(new Phrase("ASISTENCIA DE CITAS", titleFont));
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell.setBorderColor(Color.WHITE);
            headerCell.setVerticalAlignment(Element.ALIGN_CENTER);
            headerCell.setPaddingTop(6);
            tblHeader.addCell(headerCell);

            headerCell = new PdfPCell(new Phrase("Reporte Fecha: ".concat(currentDate), dateFont));
            headerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            headerCell.setBorderColor(Color.WHITE);
            headerCell.setVerticalAlignment(Element.ALIGN_CENTER);
            headerCell.setPaddingTop(10);
            tblHeader.addCell(headerCell);

            // FILTROS

            Paragraph titleFilter = new Paragraph("Filtros Aplicados:", FontFactory.getFont(FONT_FAMILY, 12, COLOR_TEXT));

            PdfPTable tblFilter = new PdfPTable(3);
            tblFilter.setSpacingAfter(20);
            tblFilter.setWidthPercentage(60);
            tblFilter.setWidths(new int[]{15, 30, 15});
            tblFilter.setHorizontalAlignment(Element.ALIGN_LEFT);
            tblFilter.setSpacingBefore(10);

            PdfPCell filterCell;

            if (dateInd) {
                filterCell = new PdfPCell(new Phrase("Fecha: ".concat(date.toString()), FontFactory.getFont(FONT_FAMILY, 11, Font.NORMAL, COLOR_TEXT)));
            } else {
                filterCell = new PdfPCell(new Phrase("Fecha: ", FontFactory.getFont(FONT_FAMILY, 11, Font.NORMAL, COLOR_TEXT_HINT)));
                filterCell.setBackgroundColor(COLOR_BG_HINT);
            }
            filterCell.setBorderColor(COLOR_BORDER_BLUE_DARK);
            filterCell.setPadding(5);
            tblFilter.addCell(filterCell);

            if (specialtyInd) {
                filterCell = new PdfPCell(new Phrase("Especialidad: ".concat(specialty.getDescripcion()), FontFactory.getFont(FONT_FAMILY, 11, Font.NORMAL, COLOR_TEXT)));
            } else {
                filterCell = new PdfPCell(new Phrase("Especialidad: ", FontFactory.getFont(FONT_FAMILY, 11, Font.NORMAL, COLOR_TEXT_HINT)));
                filterCell.setBackgroundColor(COLOR_BG_HINT);
            }
            filterCell.setBorderColor(COLOR_BORDER_BLUE_DARK);
            filterCell.setPadding(5);
            tblFilter.addCell(filterCell);

            if (statusInd) {
                filterCell = new PdfPCell(new Phrase("Estado: ".concat(status), FontFactory.getFont(FONT_FAMILY, 11, Font.NORMAL, COLOR_TEXT)));
            } else {
                filterCell = new PdfPCell(new Phrase("Estado: ", FontFactory.getFont(FONT_FAMILY, 11, Font.NORMAL, COLOR_TEXT_HINT)));
                filterCell.setBackgroundColor(COLOR_BG_HINT);
            }
            filterCell.setBorderColor(COLOR_BORDER_BLUE_DARK);
            filterCell.setPadding(8);
            tblFilter.addCell(filterCell);

            // TABLA ASISTENCIA - CABECERA

            PdfPTable tblMainHead = new PdfPTable(6);
            tblMainHead.setWidthPercentage(100);
            tblMainHead.setWidths(new int[]{4, 30, 13, 30, 11, 12});

            Font tblHeadFont = FontFactory.getFont(FONT_FAMILY, 10, Font.BOLD, Color.WHITE);

            PdfPCell headMainCell;

            headMainCell = new PdfPCell(new Phrase(" ", tblHeadFont));
            headMainCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headMainCell.setVerticalAlignment(Element.ALIGN_CENTER);
            headMainCell.setBackgroundColor(COLOR_BG_RED);
            headMainCell.setBorderColor(COLOR_BG_RED_DARK);
            headMainCell.setPadding(8);

            tblMainHead.addCell(headMainCell);

            headMainCell = new PdfPCell(new Phrase("ESTUDIANTE", tblHeadFont));
            headMainCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            headMainCell.setVerticalAlignment(Element.ALIGN_CENTER);
            headMainCell.setBackgroundColor(COLOR_BG_RED);
            headMainCell.setBorderColor(COLOR_BG_RED_DARK);
            headMainCell.setPadding(8);
            tblMainHead.addCell(headMainCell);

            headMainCell = new PdfPCell(new Phrase("ESPECIALIDAD", tblHeadFont));
            headMainCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headMainCell.setVerticalAlignment(Element.ALIGN_CENTER);
            headMainCell.setBackgroundColor(COLOR_BG_RED);
            headMainCell.setBorderColor(COLOR_BG_RED_DARK);
            headMainCell.setPadding(8);
            tblMainHead.addCell(headMainCell);

            headMainCell = new PdfPCell(new Phrase("ESPECIALISTA", tblHeadFont));
            headMainCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            headMainCell.setVerticalAlignment(Element.ALIGN_CENTER);
            headMainCell.setBackgroundColor(COLOR_BG_RED);
            headMainCell.setBorderColor(COLOR_BG_RED_DARK);
            headMainCell.setPadding(8);
            tblMainHead.addCell(headMainCell);

            headMainCell = new PdfPCell(new Phrase("FECHA", tblHeadFont));
            headMainCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headMainCell.setVerticalAlignment(Element.ALIGN_CENTER);
            headMainCell.setBackgroundColor(COLOR_BG_RED);
            headMainCell.setBorderColor(COLOR_BG_RED_DARK);
            headMainCell.setPadding(8);
            tblMainHead.addCell(headMainCell);

            headMainCell = new PdfPCell(new Phrase("ESTADO", tblHeadFont));
            headMainCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headMainCell.setVerticalAlignment(Element.ALIGN_CENTER);
            headMainCell.setBackgroundColor(COLOR_BG_RED);
            headMainCell.setBorderColor(COLOR_BG_RED_DARK);
            headMainCell.setPadding(8);
            tblMainHead.addCell(headMainCell);

            // TABLA ASISTENCIA - CUERPO

            int index = 0;
            Font tblBodyFont = FontFactory.getFont(FONT_FAMILY, 11, Font.NORMAL, COLOR_TEXT);

            for (Asistencia asistencia : asisteniciaList) {
                ++index;

                PdfPCell headBodyCell;

                headBodyCell = new PdfPCell(new Phrase(String.valueOf(index), tblBodyFont));
                headBodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headBodyCell.setVerticalAlignment(Element.ALIGN_CENTER);
                headBodyCell.setBorderColor(COLOR_BORDER_BLUE_DARK);
                headBodyCell.setPadding(8);
                tblMainHead.addCell(headBodyCell);

                String studentFullName = asistencia.getEstudiante().getApellido().toUpperCase().concat(", ").concat(asistencia.getEstudiante().getNombre().toUpperCase());
                headBodyCell = new PdfPCell(new Phrase(studentFullName.toUpperCase(), tblBodyFont));
                headBodyCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                headBodyCell.setVerticalAlignment(Element.ALIGN_CENTER);
                headBodyCell.setBorderColor(COLOR_BORDER_BLUE_DARK);
                headBodyCell.setPadding(8);
                tblMainHead.addCell(headBodyCell);

                headBodyCell = new PdfPCell(new Phrase(asistencia.getCita().getEspecialista().getEspecialidad().getDescripcion().toUpperCase(), tblBodyFont));
                headBodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headBodyCell.setVerticalAlignment(Element.ALIGN_CENTER);
                headBodyCell.setBorderColor(COLOR_BORDER_BLUE_DARK);
                headBodyCell.setPadding(8);
                tblMainHead.addCell(headBodyCell);

                String specialistFullName = asistencia.getCita().getEspecialista().getApellido().concat(", ").concat(asistencia.getCita().getEspecialista().getNombre());
                headBodyCell = new PdfPCell(new Phrase(specialistFullName.toUpperCase(), tblBodyFont));
                headBodyCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                headBodyCell.setVerticalAlignment(Element.ALIGN_CENTER);
                headBodyCell.setBorderColor(COLOR_BORDER_BLUE_DARK);
                headBodyCell.setPadding(8);
                tblMainHead.addCell(headBodyCell);

                headBodyCell = new PdfPCell(new Phrase(String.valueOf(asistencia.getCita().getFecha()), tblBodyFont));
                headBodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headBodyCell.setVerticalAlignment(Element.ALIGN_CENTER);
                headBodyCell.setBorderColor(COLOR_BORDER_BLUE_DARK);
                headBodyCell.setPadding(8);
                tblMainHead.addCell(headBodyCell);

                headBodyCell = new PdfPCell(new Phrase(asistencia.getEstado(), tblBodyFont));
                headBodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headBodyCell.setVerticalAlignment(Element.ALIGN_CENTER);
                switch (asistencia.getEstado()) {
                    case "PENDIENTE":
                        headBodyCell.setBackgroundColor( new Color(255, 228, 178));
                        break;
                    case "ASISTIDO":
                        headBodyCell.setBackgroundColor( new Color(205, 253, 230));
                        break;
                    case "CANCELADO":
                        headBodyCell.setBackgroundColor( new Color(234, 234, 234));
                        break;
                    default:
                        headBodyCell.setBackgroundColor( new Color(255, 217, 217));
                        break;
                }
                headBodyCell.setBorderColor(COLOR_BORDER_BLUE_DARK);
                headBodyCell.setPadding(8);
                tblMainHead.addCell(headBodyCell);
            }


            PdfWriter.getInstance(document, out);
            document.open();

            document.addTitle("LISTA DE ASISTENCIA DE CITAS");
            document.add(tblHeader);
            document.add(titleFilter);
            document.add(tblFilter);
            document.add(tblMainHead);

            document.close();

        } catch (DocumentException | IOException ex) {
            logger.error("Error occurred: ", ex);
        }
        return out;
    }

}

