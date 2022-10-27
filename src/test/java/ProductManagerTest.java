import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Война и мир", 5, "Толстой");
    Product book1 = new Book(2, "Танатонавты", 300, "Вербер");
    Product book2 = new Book(3, "Первому игроку приготовиться", 0, "Кляйн");
    Product book3 = new Book(3, "Первому игроку приготовиться", 0, "Кляйн");

    @Test
    public void addTest() {
        manager.add(book);
        manager.add(book1);
        manager.add(book3);
        Product[] actual = {book, book1, book3};
        Product[] expect = repository.allMass();

        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void searchByTest() {
        manager.add(book);
        manager.add(book1);
        manager.add(book2);
        Product[] actual = {book1};
        Product[] expect = manager.searchBy("Танатонавты");

        Assertions.assertArrayEquals(expect, actual);
    }
    @Test
    public void searchByTwoResultTest() {
        manager.add(book);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = {book2,book3};
        Product[] expect = manager.searchBy("Первому игроку приготовиться");

        Assertions.assertArrayEquals(expect, actual);
    }
    @Test
    public void RemoveIncorrectId() {
        manager.add(book);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = {};
        Product[] expect = manager.searchBy("Первому игроку приготовиться");
        Assertions.assertArrayEquals(expect, actual);
    }


}
