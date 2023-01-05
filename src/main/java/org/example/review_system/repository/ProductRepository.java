package org.example.review_system.repository;

import org.example.review_system.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    public static List<Product> products = new ArrayList<>();
    public static Map<Long, Product> productMap = new HashMap<>();
}
