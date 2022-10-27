import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

    class RepositoryTest {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        Product book = new Book(1, "Война и мир", 5, "Толстой");
        Product book1 = new Book(2, "Танатонавты", 300, "Вербер");
        Product book2 = new Book(3, "Первому игроку приготовиться", 0, "Кляйн");

        @Test
        public void removeByIdTest() {
            manager.add(book);
            manager.add(book1);
            manager.add(book2);
            Product[] actual = {book1, book2};
            Product[] expect = repository.removeById(1);
            Assertions.assertArrayEquals(expect, actual);

        }

}
