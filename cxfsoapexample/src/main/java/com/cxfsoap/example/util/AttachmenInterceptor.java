package com.cxfsoap.example.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.attachment.AttachmentImpl;
import org.apache.cxf.interceptor.AttachmentOutInterceptor;
import org.apache.cxf.message.Attachment;
import org.apache.cxf.message.Message;

public class AttachmenInterceptor extends AttachmentOutInterceptor{

	@Override
	public void handleMessage(Message message) {
		@SuppressWarnings("unchecked")
		List<Object> contents=message.getContent(List.class);
		
	
		for(final Object obj:contents) {			
			if(obj.toString().contains("GetBookingDetailsResponse")) {
				List<Attachment> attachments=new ArrayList<>();
							
				try {
					AttachmentImpl attachemnt = AttachmentCreator.getAttachMents();
					attachments.add(attachemnt);
				} catch (IOException e) {
					e.printStackTrace();
				}				
				message.setAttachments(attachments);
				System.out.println("GetBookingDetailsResponse Interceptor");
			}
			
		}		
	}

}
