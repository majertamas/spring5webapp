package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        bookRepository.deleteAll();
        Book szindbadHazamegy = new Book("Szindbád hazamegy", "123", "Helikon", null);
        bookRepository.save(szindbadHazamegy);
        Book vegtelenTrefa = new Book("Végtelen tréfa", "654", "Jelenkor", null);
        bookRepository.save(vegtelenTrefa);
    }

}
