package es.upm.miw.business_controllers;

//import es.upm.miw.data_services.DatabaseSeederService;
import es.upm.miw.documents.*;
import es.upm.miw.dtos.ProductDto;
import es.upm.miw.dtos.ProductMinimumDto;
//import es.upm.miw.dtos.input.FamilySizeInputDto;
import es.upm.miw.dtos.output.ProductSearchOutputDto;
import es.upm.miw.exceptions.ConflictException;
import es.upm.miw.exceptions.NotFoundException;
import es.upm.miw.repositories.ProductRepository;
//import es.upm.miw.repositories.FamilyArticleRepository;
//import es.upm.miw.repositories.FamilyCompositeRepository;
//import es.upm.miw.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    //@Autowired
    //private ProviderRepository providerRepository;

    //@Autowired
    //private DatabaseSeederService databaseSeederService;

    /*@Autowired
    private FamilyArticleRepository familyArticleRepository;

    @Autowired
    private FamilyCompositeRepository familyCompositeRepository;*/

    public List<ProductSearchOutputDto> readAll() {
        List<ProductSearchOutputDto> productSearchDtoList = new ArrayList<>();

        for (Product product : this.productRepository.findAll()) {
            productSearchDtoList.add(new ProductSearchOutputDto(product));
        }
        return productSearchDtoList;
    }

    public List<ProductMinimumDto> readProductsMinimum() {
        List<Product> products = productRepository.findAll();
        List<ProductMinimumDto> dtos = new ArrayList<>();
        for (Product product : products) {
            dtos.add(new ProductMinimumDto(product));
        }
        return dtos;
    }

    public ProductDto readProduct(String code) {
        return new ProductDto(this.productRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Product code (" + code + ")")));
    }

    public List<ProductSearchOutputDto> readProducts(String description, Integer stock, BigDecimal minPrice, BigDecimal maxPrice) {
        String minPriceStr;
        String maxPriceStr;
        minPriceStr = minPrice == null ? null : minPrice.toString();
        maxPriceStr = maxPrice == null ? null : maxPrice.toString();

        return this.productRepository.findByDescriptionAndStockAndPriceNullSafe
                (description, stock, minPriceStr, maxPriceStr);
    }

    /*public List<ProductSearchOutputDto> readProducts() {
        return this.productRepository.findByReferenceNullAndProviderNull();
    }*/

    /*public ProductDto createProduct(ProductDto productDto) {
        String code = productDto.getCode();
        if (code == null || code.equals("")) {
            // code = this.databaseSeederService.nextCodeEan();
        }
        if (this.productRepository.findById(code).isPresent()) {
            throw new ConflictException("Product code (" + code + ")");
        }
        Product product = prepareProduct(productDto, code);
        this.productRepository.save(product);
        return new ProductDto(product);
    }*/

    /*public ProductDto update(String code, ProductDto productDto) {
        Product product = prepareProduct(productDto, code);
        this.productRepository.save(product);
        return new ProductDto(product);
    }*/

    /*private Product prepareProduct(ProductDto productDto, String code) {

        int stock = (productDto.getStock() == null) ? 10 : productDto.getStock();
        Provider provider = null;
        if (productDto.getProvider() != null) {
            provider = this.providerRepository.findById(productDto.getProvider())
                    .orElseThrow(() -> new NotFoundException("Provider (" + productDto.getProvider() + ")"));
        }

        return Product.builder(code).description(productDto.getDescription()).price(productDto.getPrice())
                .reference(productDto.getReference()).stock(stock).provider(provider).build();
    }*/

    public void delete(String code) {
        Optional<Product> product = this.productRepository.findById(code);

        if (product.isPresent()) {
            this.productRepository.delete(product.get());
        }

    }
}
