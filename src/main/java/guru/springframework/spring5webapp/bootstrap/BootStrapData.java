package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.reositories.AuthorRepository;
import guru.springframework.spring5webapp.reositories.BookRepository;
import guru.springframework.spring5webapp.reositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootStrapData(
      AuthorRepository authorRepository,
      BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    Publisher pearson = new Publisher();
    pearson.setAddressline1("Patel Nagar");
    pearson.setCity("New Delhi");
    pearson.setName("Pearson Books");
    pearson.setState("Delhi");
    pearson.setZip("110027");
    publisherRepository.save(pearson);

    Author eric = new Author("Eric", "Evans");
    Book domainDrivenDesign = new Book("Domain Driven Design", "12121212");
    eric.getBooks().add(domainDrivenDesign);
    domainDrivenDesign.getAuthors().add(eric);
    domainDrivenDesign.setPublisher(pearson);
    pearson.getBooks().add(domainDrivenDesign);
    authorRepository.save(eric);
    bookRepository.save(domainDrivenDesign);
    publisherRepository.save(pearson);

    Author josh = new Author("Joush", "Bloch");
    Book effecitveJava = new Book("Effective Java", "232424232");
    josh.getBooks().add(effecitveJava);
    effecitveJava.getAuthors().add(josh);
    effecitveJava.setPublisher(pearson);
    pearson.getBooks().add(effecitveJava);
    authorRepository.save(josh);
    bookRepository.save(effecitveJava);
    publisherRepository.save(pearson);

    System.out.println("Started in Bootstrap");
    System.out.println("Number of Books: " + bookRepository.count());
    System.out.println("Number of publishers :" + publisherRepository.count());
    System.out.println("Publisher Book Size : " + pearson.getBooks().size());
  }
}
