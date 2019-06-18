package es.upm.miw.dtos.output;

import es.upm.miw.documents.Product;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class ProductSearchOutputDto {
    @Id
    private String code;
    private String description;
    private Integer stock;
    private BigDecimal price;

    public ProductSearchOutputDto() {
    }

    public ProductSearchOutputDto(String code, String description, Integer stock, BigDecimal price) {
        this.code = code;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public ProductSearchOutputDto(Product product) {
        this.code = product.getCode();
        this.description = product.getDescription();
        this.stock = product.getStock();
        this.price = product.getPrice();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal retailPrice) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductSearchOutputDto{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}