package ru.netology.manager;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductManager {

    protected ProductRepository repository;
    public ProductManager(ProductRepository repo){
        this.repository = repo;
    }
    public void add(Product product){
        repository.save(product);
    }

    public Product[] findAll(){
        Product[] items = repository.findAll();
        return items;
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++){
                    tmp[i] = result[i];
                }
                tmp[tmp.length-1] = product;
                result = tmp;

            }
        }
        return result;
    }


    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

    }
}