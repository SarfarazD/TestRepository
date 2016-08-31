package utility;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import org.testng.annotations.Test;

import java.util.*;
import java.io.*;


public class SendMailUsingAuthentication
{

  private static final String SMTP_HOST_NAME = "smtp.gmail.com";
  private static final String SMTP_AUTH_USER = "sarfaraz.doni@clariontechnologies.co.in";
  private static final String SMTP_AUTH_PWD  = "Clarion@12";

  private static final String emailMsgTxt      = "Hi Nikhil, This is a just demo email functionality.Please ignore mail once received :-)";
  private static final String emailSubjectTxt  = "Testing email!";
  private static final String emailFromAddress = "sarfaraz.doni@clariontechnologies.co.in";

  // Add List of Email address to who email needs to be sent to
  private static final String[] emailList = {"sarfaraz.doni@clariontechnologies.co.in"};


  public  static void main(String args[]) throws Exception
  {
    SendMailUsingAuthentication smtpMailSender = new SendMailUsingAuthentication();
    smtpMailSender.postMail( emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
    System.out.println("Sucessfully Sent mail to All Users");
  }


private BodyPart messageBodyPart;

  public void postMail( String recipients[ ], String subject,
                            String message , String from) throws MessagingException
  {
    boolean debug = false;

     //Set the host smtp address
     Properties props = new Properties();
     props.put("mail.smtp.host", SMTP_HOST_NAME);
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.port", 465);
     props.put("mail.debug", "true"); 
     props.put("mail.smtp.auth", "true"); 
     props.put("mail.smtp.starttls.enable","true"); 
    props.put("mail.smtp.EnableSSL.enable","true");

     props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
     props.setProperty("mail.smtp.socketFactory.fallback", "false");   
     props.setProperty("mail.smtp.port", "465");   
     props.setProperty("mail.smtp.socketFactory.port", "465"); 
    Authenticator auth = new SMTPAuthenticator();
    Session session = Session.getDefaultInstance(props, auth);

    session.setDebug(debug);

    // create a message
    Message msg = new MimeMessage(session);

    // set the from and to address
    InternetAddress addressFrom = new InternetAddress(from);
    msg.setFrom(addressFrom);
  
    // new code added
  Multipart multipart = new MimeMultipart();
 // multipart.addBodyPart(messageBodyPart);

    // Part two is attachment
    messageBodyPart = new MimeBodyPart();
    String filename = "E://Appium//Report.html";
  
    DataSource source = new FileDataSource(filename);
    messageBodyPart.setDataHandler(new DataHandler(source));
    
    messageBodyPart.setFileName("Attachment Here:");
    messageBodyPart.setDescription(message);
    multipart.addBodyPart(messageBodyPart);

    // Put parts in message
   msg.setContent(multipart);

    InternetAddress[] addressTo = new InternetAddress[recipients.length];
    for (int i = 0; i < recipients.length; i++)
    {
        addressTo[i] = new InternetAddress(recipients[i]);
    }
    msg.setRecipients(Message.RecipientType.TO, addressTo); 

  // Setting the Subject and Content Type
msg.setSubject(subject);
    msg.setContent(multipart);
      Transport.send(msg);
 }

/**
* SimpleAuthenticator is used to do simple authentication
* when the SMTP server requires it.
*/
private class SMTPAuthenticator extends javax.mail.Authenticator
{

    public PasswordAuthentication getPasswordAuthentication()
    {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PWD;
        return new PasswordAuthentication(username, password);
    }
}

}