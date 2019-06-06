package es.upm.miw.dtos;

import es.upm.miw.documents.Product;

import javax.validation.constraints.NotNull;

public class ProductMinimumDto {

    @NotNull
    private String code;

    @NotNull
    private String description;

    public ProductMinimumDto() {
        this.description = "";
    }

    public ProductMinimumDto(String code, String description) {
        super();
        this.code = code;
        this.description = description;
    }

    public ProductMinimumDto(Product product) {
        this.code = product.getCode();
        this.description = product.getDescription();
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

    @Override
    public String toString() {
        return "ProductMinimumDto [code=" + code + ", description=" + description + "]";
    }

}
