package com.cxfsoap.example.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import com.cxfsoap.example.model.BookingDetailsResponse;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class PdfDocumentCreator {

	private PdfDocumentCreator() {}
	
	public static void createPdfDocument(String filePath,String logoPath,BookingDetailsResponse data) throws DocumentException, IOException {
		
		Rectangle layout = new Rectangle(PageSize.A4);
	    layout.setBackgroundColor(new BaseColor(255, 255, 255));
	    layout.setBorderColor(BaseColor.DARK_GRAY); 
	    layout.setBorderWidth(10);     
	    layout.setBorder(Rectangle.BOX); 
	    
	    Document document = new Document(layout);
	    populateDocumentProperties(document);
	    
	    String fileName=data.getFlightId()+data.getGovtIdentityId()+"_"+data.getDepartDate()+".pdf";
	    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath+fileName));

	    String userPassword=data.getGovtIdentityId();
	    String ownerPassword=data.getFlightId();
	    
	    addDocumentEcryption(writer,userPassword,ownerPassword);
	    
        document.open();
	    
        populateImageLogo(document,logoPath);
        populateAddressContent(document);
       
             
        document.add(new LineSeparator(2f,100,BaseColor.DARK_GRAY,Element.ALIGN_CENTER,-2f));
        
        document.add(PdfTableBuilder.createTable(data));
        
        document.add(new LineSeparator(2f,100,BaseColor.DARK_GRAY,Element.ALIGN_CENTER,-2f));

        PdfContentByte cb = writer.getDirectContent();
        
        populateBarCode(cb);
                
        populateBottomText(document);
               
        PdfHeaderAndFooter footer=new PdfHeaderAndFooter();
        footer.onEndPage(writer, document);
        
        document.close();
        writer.close();                
	}

	private static void addDocumentEcryption(PdfWriter writer, String userPassword, String ownerPassword) throws DocumentException {
		
		writer.setEncryption(userPassword.getBytes(),
				ownerPassword.getBytes(), PdfWriter.ALLOW_PRINTING,
        PdfWriter.ENCRYPTION_AES_128);     		
	}

	private static void populateBottomText(Document document) throws DocumentException {
		 Font f2= new Font (Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL, BaseColor.BLACK);
	        Paragraph info2= new Paragraph("** Please carry your original government ID proof and display on security. \n",f2);        
	      
	        PdfPTable table2 = new PdfPTable(1);
	        table2.setWidthPercentage(100);
	        table2.spacingAfter();        
	        PdfPCell bottomCell = new PdfPCell(info2);
	        bottomCell.setHorizontalAlignment(Element.ALIGN_LEFT);
	        bottomCell.setExtraParagraphSpace(1.5f);
	        
	        bottomCell.disableBorderSide(1);
	        bottomCell.disableBorderSide(2);
	        bottomCell.disableBorderSide(4);
	        bottomCell.disableBorderSide(8);
	        
	        Paragraph info3= new Paragraph("** Please come 2 hours before boarding time for security check and boarding procedures,Thank You! \n",f2);
	        PdfPCell bottomCell2 = new PdfPCell(info3);
	        bottomCell2.setHorizontalAlignment(Element.ALIGN_LEFT);
	        bottomCell2.setExtraParagraphSpace(1.5f);
	        
	        bottomCell2.disableBorderSide(1);
	        bottomCell2.disableBorderSide(2);
	        bottomCell2.disableBorderSide(4);
	        bottomCell2.disableBorderSide(8);
	        
	        table2.addCell(bottomCell);
	        table2.addCell(bottomCell2);
	        document.add(table2);   		
	}

	private static void populateBarCode(PdfContentByte cb) {
		Barcode128 barcode128 = new Barcode128();
        barcode128.setCode("moryaairliens.com");
        barcode128.setCodeType(Barcode.CODE128);
       
        PdfTemplate template = barcode128.createTemplateWithBarcode(
                cb, BaseColor.BLACK, BaseColor.BLACK);
        float x = 35;
        float y = 230;
        float w = template.getWidth();
        float h = template.getHeight();
        cb.saveState();
        cb.setColorFill(BaseColor.LIGHT_GRAY);
        cb.rectangle(x, y, w, h);
        cb.fill();
        cb.restoreState();
        cb.addTemplate(template, 35, 230);		
	}

	private static void populateAddressContent(Document document) throws DocumentException {
		 Font f1= new Font (Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK);
	        Paragraph info= new Paragraph("MoryaAirlines Pvt. Ltd.\nAddress:102,Udyog Vihar,Phase-2,Gurgaon-122040\nContact Number:+91 7654-8765-90\nDate:"+new Date(),f1);        
	      
	        PdfPTable table1 = new PdfPTable(1);
	        table1.setWidthPercentage(100);
	        table1.spacingAfter();        
	        PdfPCell cell = new PdfPCell(info);
	        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell.setExtraParagraphSpace(1.5f);
	        
	        cell.disableBorderSide(1);
	        cell.disableBorderSide(2);
	        cell.disableBorderSide(4);
	        cell.disableBorderSide(8);
	        
	        table1.addCell(cell);
	        document.add(table1);		
	}

	private static void populateImageLogo(Document document, String logoPath) throws MalformedURLException, IOException, DocumentException {
		 Image image1 = Image.getInstance(logoPath);       
	        image1.setAbsolutePosition(20f, 730f);
	        image1.scaleAbsolute(200, 100);
	        document.add(image1);
	}

	private static void populateDocumentProperties(Document document) {
		document.setPageSize(document.getPageSize());
	    document.setMargins(36, 72, 108, 180);
	    document.setMarginMirroring(false);
	    document.addAuthor("Morya Airways Pvt Ltd.");
        document.addCreationDate();
        document.addCreator("Morya Airways Pvt Ltd.");
        document.addTitle("Booking Details Reciept");
        document.addSubject("Booking Details for Passenger: Anil kumar");		
	}

}
