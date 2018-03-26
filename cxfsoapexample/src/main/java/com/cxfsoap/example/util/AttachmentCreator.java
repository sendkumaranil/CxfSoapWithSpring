package com.cxfsoap.example.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.activation.DataHandler;

import org.apache.cxf.attachment.AttachmentImpl;
import org.apache.cxf.attachment.ByteDataSource;

public class AttachmentCreator {

	private AttachmentCreator() {}
	
	public static AttachmentImpl getAttachMents() throws IOException {
		String contentType="application/pdf";
		byte[] fileBytes=getFileBytes("D:\\moryaflights\\reciepts\\MORDELBANG002BDKPK8645B_26-10-2018.pdf");
		ByteDataSource fileDataSource=new ByteDataSource(fileBytes);
		fileDataSource.setContentType(contentType);
		AttachmentImpl attachment=new AttachmentImpl("billrecipt",new DataHandler(fileDataSource));
		attachment.setHeader("Content-Id", "billrecipt");
		attachment.setHeader("Content-Transfer-Encoding", "binary");
		attachment.setHeader("Content-Type", contentType);
		attachment.setXOP(true);
		return attachment;
	}

	private static byte[] getFileBytes(String filePath) throws IOException {		
        byte[] bytesArray = null;
        
        try(FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {        	 
             bytesArray = new byte[fileInputStream.available()];             
             fileInputStream.read(bytesArray);
		}     
		return bytesArray;
	}
}
