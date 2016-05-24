package com.example;

import com.example.model.Author;
import com.example.model.Book;
import com.example.repository.AuthorRepository;
import com.example.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AuthorsApplication.class)
public class AuthorRepositoryTest {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	@Before
	public void setUp() throws Exception {
		authorRepository.deleteAllInBatch();
		bookRepository.deleteAllInBatch();
	}

	@Test
	public void saveShouldPersistAuthor() throws Exception {
		Author author = new Author("Ruben");
		author.addBook(new Book("Enterprise Application Patterns"));
		author.addBook(new Book("Refactoring"));

		authorRepository.save(author);

		assertEquals(1, authorRepository.findAll().size());
		assertEquals(2, bookRepository.findAll().size());
	}
}
