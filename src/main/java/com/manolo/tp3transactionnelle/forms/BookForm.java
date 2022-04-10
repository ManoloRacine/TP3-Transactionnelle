package com.manolo.tp3transactionnelle.forms;

import com.manolo.tp3transactionnelle.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookForm {
    private String name ;
    private String author ;
    private int releaseYear ;
    private int nbAvailable ;
    private String genre ;
    private int nbOfPages ;

    public BookForm(){

    }

    public BookForm(Book book) {
        this.name = book.getName() ;
        this.author = book.getAuthor() ;
        this.releaseYear = book.getReleaseYear() ;
        this.nbAvailable = book.getNbAvailable() ;
        this.genre = book.getGenre() ;
        this.nbOfPages = book.getNbOfPages() ;
    }

    public Book toBook() {
        return Book.builder().name(name).author(author).releaseYear(releaseYear).nbAvailable(nbAvailable).
                genre(genre).nbOfPages(nbOfPages).build() ;
    }
}
