package com.cxfsoap.example.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.activation.DataHandler;

import org.apache.cxf.attachment.AttachmentImpl;
import org.apache.cxf.attachment.ByteDataSource;

public class AttachmentCreator {

	private static Map<String,String> fileMetadamap=new HashMap<>();
	
	private AttachmentCreator() {}
	
	public static AttachmentImpl getAttachMents(String fileContentId) throws IOException {
		String contentType="application/pdf";
		byte[] fileBytes=getFileBytes("D:\\moryaflights\\reciepts\\"+fileContentId+".pdf");
		ByteDataSource fileDataSource=new ByteDataSource(fileBytes);
		fileDataSource.setContentType(contentType);
		AttachmentImpl attachment=new AttachmentImpl(fileContentId,new DataHandler(fileDataSource));
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

	public static Map<String, String> getFileMetadamap() {
		return fileMetadamap;
	}

	public static void setFileMetadamap(Map<String, String> fileMetadamap) {
		AttachmentCreator.fileMetadamap = fileMetadamap;
	}	
}
