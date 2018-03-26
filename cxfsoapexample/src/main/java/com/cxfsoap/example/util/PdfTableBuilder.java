package com.cxfsoap.example.util;

import java.util.List;

import com.cxfsoap.example.model.BookingDetailsResponse;
import com.cxfsoap.example.model.PassengerList;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
 
public class PdfTableBuilder {
	
	private PdfTableBuilder(){}
     // create table
    public static PdfPTable createTable(BookingDetailsResponse data) throws DocumentException {
 
        // create 6 column table
        PdfPTable table = new PdfPTable(2);
        // set the width of the table to 100% of page
        table.setWidthPercentage(100);
        table.setSpacingBefore(25f); //Space before table
        table.setSpacingAfter(25f); //Space after table
        // set relative columns width
        table.setWidths(new float[]{1f,4f});
        // ----------------Table Header "Title"----------------
        // font
        Font font = new Font(FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
        // create header cell
        PdfPCell cell = new PdfPCell(new Phrase("Booking Details",font));
        // set Column span "1 cell = 2 cells width"
        cell.setColspan(2);
        // set style
        PdfTableStyle.headerCellStyle(cell);
        // add to table
        table.addCell(cell);
 
        //-----------------Table Cells Label/Value------------------
        PassengerList passengerList=data.getPassengerList();
        List<String> nameList=passengerList.getName();
        StringBuilder nameBuilder=new StringBuilder();
        for(String name:nameList) {
        	nameBuilder.append(name+",");
        }
        // 1st Row
        table.addCell(createLabelCellRow1("Name:"));        
        table.addCell(createValueCellRow1(nameBuilder.toString()));
        // 2nd Row
        table.addCell(createLabelCellRow2(data.getGovtIdentityType()+":"));        
        table.addCell(createValueCellRow2(data.getGovtIdentityId()));               
        // 3rd Row
        table.addCell(createLabelCellRow1("Flight Id:"));        
        table.addCell(createValueCellRow1(data.getFlightId()));      
        // 4th Row
        table.addCell(createLabelCellRow2("Flight Name:"));        
        table.addCell(createValueCellRow2(data.getFlightId()));
        
        table.addCell(createLabelCellRow1("Travel Date:"));        
        table.addCell(createValueCellRow1(data.getDepartDate()));
        
        table.addCell(createLabelCellRow2("Departure Time:"));        
        table.addCell(createValueCellRow2(data.getDeptTime()));
        
        table.addCell(createLabelCellRow1("Arrival Time:"));        
        table.addCell(createValueCellRow1(data.getArrivalTime()));
        
        table.addCell(createLabelCellRow2("Duration:"));        
        table.addCell(createValueCellRow2(data.getDuration()));
        
        table.addCell(createLabelCellRow1("Boarding Airport:"));        
        table.addCell(createValueCellRow1(data.getBoardingAirport()));
        
        table.addCell(createLabelCellRow2("Arrival Airport:"));        
        table.addCell(createValueCellRow2(data.getArrivalAirport()));
        
        table.addCell(createLabelCellRow1("Total Fare:"));        
        table.addCell(createValueCellRow1(String.valueOf(data.getTotalFare())));
        
        table.addCell(createLabelCellRow2("Travel Class:"));        
        table.addCell(createValueCellRow2(data.getTravelClass()));
        
        table.addCell(createLabelCellRow1("Adults:"));        
        table.addCell(createValueCellRow1(String.valueOf(data.getNoOfAdults())));
        
        table.addCell(createLabelCellRow2("Children:"));        
        table.addCell(createValueCellRow2(String.valueOf(data.getNoOfChildren())));
        
        table.addCell(createLabelCellRow1("Booking Date:"));        
        table.addCell(createValueCellRow1(data.getBookingDate()));
        
        return table;
    }
 
    // create cells
    private static PdfPCell createLabelCellRow1(String text){
        // font
        Font font = new Font(FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.DARK_GRAY);
        // create cell
        PdfPCell cell = new PdfPCell(new Phrase(text,font));
        // set style
        PdfTableStyle.labelCellStyleRow1(cell);
        return cell;
    }
 
    private static PdfPCell createLabelCellRow2(String text){
        // font
        Font font = new Font(FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.DARK_GRAY); 
        // create cell
        PdfPCell cell = new PdfPCell(new Phrase(text,font));
        // set style
        PdfTableStyle.labelCellStyleRow2(cell);
        return cell;
    }
    // create cells
    private static PdfPCell createValueCellRow1(String text){
        // font
        Font font = new Font(FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.BLACK);
        // create cell
        PdfPCell cell = new PdfPCell(new Phrase(text,font));
        // set style
        PdfTableStyle.valueCellStyleRow1(cell);
        return cell;
    }
    private static PdfPCell createValueCellRow2(String text){
        // font
        Font font = new Font(FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.BLACK);
        // create cell
        PdfPCell cell = new PdfPCell(new Phrase(text,font));
        // set style
        PdfTableStyle.valueCellStyleRow2(cell);
        return cell;
    }
}