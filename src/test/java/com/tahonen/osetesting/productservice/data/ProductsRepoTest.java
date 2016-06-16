package com.tahonen.osetesting.productservice.data;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.tahonen.ostesting.productservice.data.ProductsRepo;


public class ProductsRepoTest {
	@Test
	public void get(){
		ProductsRepo pr = new ProductsRepo();
		assertEquals("Product id must be 1", 1, pr.get(1).getId());
		assertEquals("Product id must be 3", 3, pr.get(3).getId());
		assertEquals("Product id must be 5", 5, pr.get(5).getId());
		assertEquals("Product id must be 7", 7, pr.get(7).getId());
	}
	@Test
	public void list(){
		ProductsRepo pr = new ProductsRepo();
		assertEquals("List size must be 10", 10, pr.list(10).size());
	}
}
