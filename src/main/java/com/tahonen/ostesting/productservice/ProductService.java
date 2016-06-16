package com.tahonen.ostesting.productservice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.tahonen.ostesting.productservice.data.ProductsRepo;
import com.tahonen.ostesting.productservice.model.Product;

@Path("/products")
public class ProductService {
	@GET
	@Path("/")
	@Produces("application/json;charset=UTF-8")
	public Response list() {
		try {
			return Response.status(Response.Status.OK).entity(new ProductsRepo().get(10)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GET
	@Path("/version")
	@Produces("application/json;charset=UTF-8")
	public Response version(@Context HttpServletRequest request) {
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("version", request.getServletContext().getInitParameter("version"));
			return Response.status(Response.Status.OK).entity(data).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GET
	@Path("/{id}")
	@Produces("application/json;charset=UTF-8")
	public Response get(@PathParam("id") long id) {
		try {
			Product p = new ProductsRepo().get(101);
			return Response.status(Response.Status.OK).entity(p).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	}
}
