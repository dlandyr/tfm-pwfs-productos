package es.upm.miw.rest_controllers;

import es.upm.miw.business_controllers.ProductController;
import es.upm.miw.dtos.ProductDto;
import es.upm.miw.dtos.ProductMinimumDto;
import es.upm.miw.dtos.input.ProductSearchInputDto;
import es.upm.miw.dtos.output.ProductSearchOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('OPERATOR')")
@RestController
@RequestMapping(ProductResource.PRODUCTS)
public class ProductResource {

    public static final String PRODUCTS = "/products";
    public static final String CODE_ID = "/{code}";
    public static final String MINIMUM = "/minimum";
    public static final String SEARCH = "/search";

    @Autowired
    private ProductController productController;

    @GetMapping
    public List<ProductSearchOutputDto> readAll() {
        return this.productController.readAll();
    }

    @GetMapping(value = CODE_ID)
    public ProductDto readProduct(@PathVariable String code) {
        return this.productController.readProduct(code);
    }

    @GetMapping(value = MINIMUM)
    public List<ProductMinimumDto> readProductsMinimum() {
        return this.productController.readProductsMinimum();
    }

    @PostMapping
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto) {
        return this.productController.createProduct(productDto);
    }

    @PostMapping(value = SEARCH)
    public List<ProductSearchOutputDto> readProducts(@RequestBody ProductSearchInputDto product) {
        return this.productController.readProducts(product.getDescription(), product.getStock(),
                product.getMinPrice(), product.getMaxPrice());
    }

    @PutMapping(value = CODE_ID)
    public ProductDto update(@PathVariable String code, @Valid @RequestBody ProductDto productDto) {
        return this.productController.update(code, productDto);
    }

    @DeleteMapping(value = CODE_ID)
    public void delete(@PathVariable String code) {
        this.productController.delete(code);
    }

}