package pl.awarkoczewski.magazines.model.repository;

import pl.awarkoczewski.books.model.Genre;
import pl.awarkoczewski.magazines.model.IssueFrequency;
import pl.awarkoczewski.magazines.model.Magazine;

public interface MagazineRepository {

    Magazine insertMagazine(Magazine magazine);

    void deleteMagazine(Magazine magazine);

    Magazine updateMagazine(Magazine magazine);

    Magazine findMagazineById(Long id);

    Magazine findMagazineByGenre(Genre genre);

    Magazine findMagazineByIssueFrequency(IssueFrequency issueFrequency);
}
