package model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Library {
    @Id
    @GeneratedValue
    private long id ;

    @OneToMany(mappedBy = "library")
    private List<Document> documents = new ArrayList<>();

    public List<Document> researchDocumentByTitle(String title) {
        List<Document> documentsByTitle = new ArrayList<>() ;
        for (Document document : documents) {
            if (document.getName().contains(title)) {
                documentsByTitle.add(document) ;
            }
        }
        return documentsByTitle ;
    }

    public List<Document> researchDocumentByAuthor(String author) {
        List<Document> documentsByAuthor = new ArrayList<>() ;

        for (Document document : documents) {
            if (document.getAuthor().equals(author)) {
                documentsByAuthor.add(document) ;
            }
        }

        return documentsByAuthor ;
    }

    public List<Document> researchDocumentByYear(int year) {
        List<Document> documentsByYear = new ArrayList<>() ;
        for (Document document : documents) {
            if (document.getReleaseYear() == year) {
                documentsByYear.add(document) ;
            }
        }
        return documentsByYear ;
    }

    public List<Book> researchBookByCategory(String genre) {
        List<Book> booksByCategory = new ArrayList<>() ;
        for (Document document : documents) {
            if (document instanceof Book) {
                Book book = (Book) document ;
                if (book.getGenre().equals(genre)) {
                    booksByCategory.add(book) ;
                }
            }
        }
        return booksByCategory ;
    }

    public Document researchDocumentById(long id) {
        for (Document document : documents) {
            if (document.getId() == id) {
                return document ;
            }
        }
        return null ;
    }
}
