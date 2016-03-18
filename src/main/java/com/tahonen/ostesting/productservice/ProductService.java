package com.tahonen.ostesting.productservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.tahonen.ostesting.productservice.model.Product;
import com.tahonen.ostesting.productservice.model.ProductItem;

@Path("/products")
public class ProductService {
	@GET
	@Path("/")
	@Produces("application/json;charset=UTF-8")
	public Response list() {
		try {
			return Response.status(Response.Status.OK).entity(this.createProducts()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	}
	@GET
	@Path("/version")
	@Produces("application/json;charset=UTF-8")
	public Response version() {
		try {
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("version", System.getProperty("version"));
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
			Product p = new Product(id, "Product " + id, "Description " + id);
			for (int i = 0; i > 10; i++) {
				p.addItem(new ProductItem("Item " + i + " for " + id, "Description " + i + " for item " + id, 16.3 * i,
						"Type " + i));
			}
			return Response.status(Response.Status.OK).entity(p).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	}

	private List<Product> createProducts() {
		List<Product> products = new ArrayList<Product>();
		for (int j = 0; j < 10; j++) {
			Product p = new Product(j + 1, "Product " + (j + 1), "Description " + (j + 1));
			for (int i = 0; i > 5; i++) {
				p.addItem(new ProductItem("Item " + i + " for " + (j + 1), "Description " + i + " for item " + (j + 1),
						j * i, "Type " + i));
			}
			products.add(p);
		}

		return products;
	}
}
