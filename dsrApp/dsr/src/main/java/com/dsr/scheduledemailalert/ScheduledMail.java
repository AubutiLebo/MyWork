package com.dsr.scheduledemailalert;

import org.springframework.stereotype.Component;

import com.dsr.mailsender.SMTPMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import java.time.LocalTime;
import javax.mail.MessagingException;


@Component
public class ScheduledMail 
{
    
    @Autowired
	private SMTPMailSender smtpMailSender;
   
      LocalTime alertTime = LocalTime.of(14, 30);
      LocalTime AlertTeminationTime = LocalTime.of(14, 31);
	  @Scheduled(fixedRate = 40000) 
	  public void ScheduledMailAlert() throws MessagingException 
	  {
		  
	      if(LocalTime.now().isAfter(alertTime) && LocalTime.now().isBefore(AlertTeminationTime))
	      {
	         sendMail();
	         System.out.println("Alert sent");
	      }
	     
	  }
	  
	  public void sendMail() throws MessagingException
	  {
		  smtpMailSender.send("lebohang.ntsiu@gmail.com", "DSR Reminder", "Hi User, This is a reminder for you to send through your DSR to your Manager. Thank you");
	  } 
    
}

