package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductRepositoryTest{
    Product book = new Book(1, "Birch", 100, "Esenin S.A.");
    Product smph = new Smartphone(2, "10 Pro", 22990, "Realme");
    Product book1 = new Book(3, "Death Souls", 300, "Gogol N.V.");
    Product smph2 = new Smartphone(4, "12 Pro", 69990, "Iphone");


    @Test
    public  void test1(){
        ProductRepository repo = new ProductRepository();

        repo.save(book);
        repo.save(smph);
        repo.save(book1);
        repo.save(smph2);

    }

}