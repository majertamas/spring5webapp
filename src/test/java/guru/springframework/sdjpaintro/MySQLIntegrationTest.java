package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.sdjpaintro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // a @DataJpaTest mindenképp H2-t akar használni, ezzel kikapcsoljuk
class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testBookRepositoryTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
    }

}
