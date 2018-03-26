package com.cxfsoap.example.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfHeaderAndFooter extends PdfPageEventHelper {

	 Font ffont = new Font(Font.FontFamily.UNDEFINED, 10, Font.ITALIC);

	 	@Override
	    public void onEndPage(PdfWriter writer, Document document) {
	        PdfContentByte cb = writer.getDirectContent();
	        Phrase footer = new Phrase(" \u00A9 Copyright Morya Airlines all right reserved.", ffont);
	     
	        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
	                footer,
	                (document.right() - document.left()) / 2 + document.leftMargin(),
	                document.bottom() - 10, 0);
	    }
}
