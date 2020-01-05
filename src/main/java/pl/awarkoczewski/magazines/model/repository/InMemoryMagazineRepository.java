package pl.awarkoczewski.magazines.model.repository;

import pl.awarkoczewski.books.model.Genre;
import pl.awarkoczewski.magazines.model.IssueFrequency;
import pl.awarkoczewski.magazines.model.Magazine;

public class InMemoryMagazineRepository implements MagazineRepository {
    @Override
    public Magazine insertMagazine(Magazine magazine) {
        return null;
    }

    @Override
    public void deleteMagazine(Magazine magazine) {

    }

    @Override
    public Magazine updateMagazine(Magazine magazine) {
        return null;
    }

    @Override
    public Magazine findMagazineById(Long id) {
        return null;
    }

    @Override
    public Magazine findMagazineByGenre(Genre genre) {
        return null;
    }

    @Override
    public Magazine findMagazineByIssueFrequency(IssueFrequency issueFrequency) {
        return null;
    }
}
