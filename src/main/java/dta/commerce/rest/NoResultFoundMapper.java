package dta.commerce.rest;

import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


//Renvoie un code 404 d�s qu'une NoResultException est lev�e.
@Provider
public class NoResultFoundMapper implements ExceptionMapper<NoResultException> {

	@Override
	public Response toResponse(NoResultException exception) {
		return Response.status(Response.Status.NOT_FOUND).build();
	}
	
}