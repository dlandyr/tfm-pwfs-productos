package es.upm.miw.data_services;

import es.upm.miw.documents.Product;
import es.upm.miw.documents.Provider;

import java.util.ArrayList;
import java.util.List;

public class DatabaseGraph {

    private List<Product> productList;
    private List<Provider> providerList;

    public DatabaseGraph() {

        this.productList = new ArrayList<>();
        this.providerList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Provider> getProviderList() {
        return providerList;
    }

    public void setProviderList(List<Provider> providerList) {
        this.providerList = providerList;
    }

}
