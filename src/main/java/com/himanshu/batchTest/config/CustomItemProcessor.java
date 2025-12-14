package com.himanshu.batchTest.config;

import com.himanshu.batchTest.entity.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Product,Product> {

    @Override
    public Product process(Product item) throws Exception
    {
        double discountPre = Double.parseDouble(item.getDiscount());
        double originalPrice = Double.parseDouble(item.getPrice());

        // Calculate discount amount: (discount% / 100) * price
        double discountAmount = (discountPre / 100.0) * originalPrice;

        // Calculate final price: price - discount amount
        double finalPrice = originalPrice - discountAmount;

        item.setDiscountedPrice(String.format("%.2f", finalPrice));

        return item;
    }
}
