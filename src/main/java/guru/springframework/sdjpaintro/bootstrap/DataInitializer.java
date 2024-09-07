package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        Book szindbadHazamegy = new Book("Szindbád hazamegy", "123", "Helikon");
        bookRepository.save(szindbadHazamegy);
        Book vegtelenTrefa = new Book("Végtelen tréfa", "654", "Jelenkor");
        bookRepository.save(vegtelenTrefa);
    }

}
