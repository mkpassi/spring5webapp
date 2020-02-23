package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.reositories.AuthorRepository;
import guru.springframework.spring5webapp.reositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;

  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author("Eric", "Evans");
    Book domainDrivenDesign = new Book("Domain Driven Design", "12121212");
    eric.getBooks().add(domainDrivenDesign);
    domainDrivenDesign.getAuthors().add(eric);
    authorRepository.save(eric);
    bookRepository.save(domainDrivenDesign);

    Author josh = new Author("Joush", "Bloch");
    Book effecitveJava = new Book("Effective Java", "232424232");
    josh.getBooks().add(effecitveJava);
    effecitveJava.getAuthors().add(josh);
    authorRepository.save(josh);
    bookRepository.save(effecitveJava);

    System.out.println(bookRepository.count());
    System.out.println(authorRepository.count());
    System.out.println("|" + bookRepository.findAll() + "|");
  }
}
