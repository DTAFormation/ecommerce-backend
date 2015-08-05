package dta.ecommerce.backend.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("products")
public class ProductResource {

    @GET
    public String listProducts() {
        return "hello products";
    }
}
