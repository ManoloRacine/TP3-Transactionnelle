package com.manolo.tp3transactionnelle.forms;

import com.manolo.tp3transactionnelle.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class BookForm {

    @NotEmpty
    @NotBlank
    private String name ;

    @NotEmpty
    @NotBlank
    private String author ;

    @NotNull
    private int releaseYear ;

    @Min(1)
    private int nbAvailable ;

    @NotEmpty
    @NotBlank
    private String genre ;

    @Min(1)
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
