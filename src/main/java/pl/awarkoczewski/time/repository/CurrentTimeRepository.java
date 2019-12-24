package pl.awarkoczewski.time.repository;

import java.time.LocalDate;

public class CurrentTimeRepository implements TimeRepository {

    @Override
    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
