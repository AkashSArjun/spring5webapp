package ak.springframework.spring5webapp.bootstrap;

import ak.springframework.spring5webapp.model.Author;
import ak.springframework.spring5webapp.model.Book;
import ak.springframework.spring5webapp.repositories.AuthorRepository;
import ak.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();

    }

    private void initData()
    {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Dreven Design", "1234", "Harper Collis");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        //Rob
        Author rob = new Author("Rob", "Jonson");
        Book book1 = new Book("Developers Concept", "2345", "Ak SAr");
        rob.getBooks().add(book1);
        book1.getAuthors().add(rob);

        authorRepository.save(rob);
        bookRepository.save(book1);
    }

}
