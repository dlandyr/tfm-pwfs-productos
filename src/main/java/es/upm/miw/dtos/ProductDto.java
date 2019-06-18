package es.upm.miw.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import es.upm.miw.documents.Product;
import es.upm.miw.documents.Provider;
import es.upm.miw.documents.Tax;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductDto extends ProductMinimumDto {

    @JsonInclude(Include.NON_NULL)
    private BigDecimal price;
    private Integer stock;
    private Tax tax;
    @JsonInclude(Include.NON_NULL)
    private String provider;
    @JsonInclude(Include.NON_NULL)
    private Boolean discontinued;
    @JsonInclude(Include.NON_NULL)
    private LocalDateTime registrationDate;

    public ProductDto() {
    }

    public ProductDto(String code, String description, BigDecimal price, Integer stock, Tax tax) {
        super(code, description);
        this.price = price;
        this.stock = stock;
        this.tax = tax;
    }

    public ProductDto(Product product) {
        this(product.getCode(), product.getDescription(), product.getPrice(), product.getStock(), product.getTax());
        this.setDiscontinued(product.getDiscontinued());
        this.registrationDate = product.getRegistrationDate();
        if (product.getProvider() != null) {
            this.setProvider(product.getProvider().getId());
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getStock() {
        return stock;
    }

    public ProductDto setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public ProductDto setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public ProductDto setProvider(Provider provider) {
        this.provider = provider.getId();
        return this;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }

    public ProductDto setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
        return this;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "price=" + price +
                ", stock=" + stock +
                ", provider='" + provider + '\'' +
                ", discontinued=" + discontinued +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
