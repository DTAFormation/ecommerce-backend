package dta.commerce.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import dta.commerce.persistance.Mail;
import dta.commerce.service.EmailService;
import dta.commerce.service.IEmailService;

@Path("/contactSAV")
public class EmailSAV {
	@EJB IEmailService emailService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response contactSAV(Mail mail){
		emailService.envoiEmailSAV(mail.getObject(),mail.getMsg(),mail.getExpediteur());
		ResponseBuilder builder = Response.ok();
		builder.status(200);
		return builder.build();  
	}

}
