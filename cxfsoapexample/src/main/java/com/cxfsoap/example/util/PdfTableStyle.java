package com.cxfsoap.example.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
 
public class PdfTableStyle {
 
	private PdfTableStyle(){}
	
    public static void headerCellStyle(PdfPCell cell){
    // alignment
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    // padding
        cell.setPaddingTop(0f);
        cell.setPaddingBottom(7f);
        // background color
        cell.setBackgroundColor(new BaseColor(0,121,182));
        // border
        cell.setBorder(0);
        cell.setBorderWidthBottom(1f);
 
    }
    public static void labelCellStyleRow1(PdfPCell cell){
    // alignment
    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        // padding
        cell.setPaddingLeft(3f);
        cell.setPaddingTop(0f);
        // background color
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        // border
        cell.setBorder(0);
        cell.setBorderWidthBottom(0.5f);
        cell.setBorderColorBottom(BaseColor.WHITE);
        // height
        cell.setMinimumHeight(18f);
    }
    public static void valueCellStyleRow1(PdfPCell cell){
    // alignment
    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        // padding
        cell.setPaddingTop(0f);
        cell.setPaddingBottom(5f);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        // border
        cell.setBorder(0);
        cell.setBorderWidthBottom(0.5f);
        cell.setBorderColorBottom(BaseColor.WHITE);
        // height
        cell.setMinimumHeight(18f);
    }
    public static void labelCellStyleRow2(PdfPCell cell){
        // alignment
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            // padding
            cell.setPaddingLeft(3f);
            cell.setPaddingTop(0f);
            // background color
            cell.setBackgroundColor(BaseColor.GRAY);
            // border
            cell.setBorder(0);
            cell.setBorderWidthBottom(0.5f);
            cell.setBorderColorBottom(BaseColor.WHITE);
            // height
            cell.setMinimumHeight(18f);
      }
    public static void valueCellStyleRow2(PdfPCell cell){
        // alignment
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            // padding
            cell.setPaddingTop(0f);
            cell.setPaddingBottom(5f);
            cell.setBackgroundColor(BaseColor.GRAY);
            // border
            cell.setBorder(0);
            cell.setBorderWidthBottom(0.5f);
            cell.setBorderColorBottom(BaseColor.WHITE);
            // height
            cell.setMinimumHeight(18f);
     }
}
