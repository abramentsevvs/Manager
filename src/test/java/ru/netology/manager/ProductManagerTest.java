package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import ru.netology.manager.ProductManager;

public class ProductManagerTest{
    Product book = new Book(1, "Birch", 100, "Esenin S.A.");
    Product smph = new Smartphone(2, "10 Pro", 22990, "Realme");
    Product book1 = new Book(3, "Dead Souls", 300, "Gogol N.V.");
    Product smph2 = new Smartphone(4, "12 Pro", 69990, "Iphone");
    @Test
    public  void test(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book);
        manager.add(smph);
        manager.add(book1);
        manager.add(smph2);
        manager.findAll();

        Product[] actual = manager.searchBy("Bi");
        Product[] expected = {book};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void test1(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book);
        manager.add(smph);
        manager.add(book1);
        manager.add(smph2);
        manager.findAll();

        Product[] actual = manager.searchBy("ov");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void test2(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book);
        manager.add(smph);
        manager.add(book1);
        manager.add(smph2);
        manager.findAll();

        Product[] actual = manager.searchBy("Pro");
        Product[] expected = {smph2, smph};
        Assertions.assertArrayEquals(expected, actual);
    }

}