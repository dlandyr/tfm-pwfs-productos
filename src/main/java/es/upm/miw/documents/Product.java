package es.upm.miw.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
public class Product {

    @Id
    private String code;

    private LocalDateTime registrationDate;

    private String description;

    private BigDecimal price;

    private String reference;

    private Integer stock;

    private Tax tax;

    private Boolean discontinued;

    @DBRef(lazy = true)
    private Provider provider;

    public Product() {

        this.registrationDate = LocalDateTime.now();
    }

    public static Builder builder(String code) {

        return new Builder(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (code.equals(((Product) obj).code));
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", registrationDate=" + registrationDate +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", reference='" + reference + '\'' +
                ", stock=" + stock +
                ", tax=" + tax +
                ", discontinued=" + discontinued +
                '}';
    }

    public static class Builder {
        private Product product;

        private Builder(String code) {
            this.product = new Product();
            this.product.code = code;
            this.product.discontinued = false;
            this.product.stock = 0;
            this.product.tax = Tax.GENERAL;
        }

        public Builder reference(String reference) {
            this.product.reference = reference;
            return this;
        }

        public Builder description(String description) {
            this.product.description = description;
            return this;
        }

        public Builder price(String price) {
            this.product.price = new BigDecimal(price);
            return this;
        }

        public Builder price(BigDecimal price) {
            this.product.price = price;
            return this;
        }

        public Builder stock(Integer stock) {
            this.product.stock = stock;
            return this;
        }

        public Builder provider(Provider provider) {
            this.product.provider = provider;
            return this;
        }

        public Builder tax(Tax tax) {
            this.product.tax = tax;
            return this;
        }

        public Product build() {
            return this.product;
        }
    }

}
