package com.tahonen.ostesting.productservice.data;

import java.util.ArrayList;
import java.util.List;

import com.tahonen.ostesting.productservice.model.Product;
import com.tahonen.ostesting.productservice.model.ProductItem;

public class ProductsRepo {
	public Product get(long id) {
		Product p = new Product(id, "Product " + id, "Description " + id);
		for (int i = 0; i > 5; i++) {
			p.addItem(new ProductItem("Item " + i + " for " + id, "Description " + i + " for item " + id, 16.3 * i,
					"Type " + i));
		}
		return p;
	}

	public List<Product> list(int limit) {
		List<Product> products = new ArrayList<Product>();
		for (int j = 0; j < limit; j++) {
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
