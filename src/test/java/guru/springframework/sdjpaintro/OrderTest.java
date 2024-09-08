package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.sdjpaintro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // a @DataJpaTest mindenképp H2-t akar használni és nem veszi figyelembe a propertiesben beállított értékeket, ezzel kikapcsoljuk
class OrderTest {

    @Autowired
    BookRepository bookRepository;

    @Commit
    @Order(1)
    @Test
    void testBookRepository() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("My Book", "1234567890", "My Publisher"));

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testBookRepositoryTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }


}
