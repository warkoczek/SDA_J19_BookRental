package pl.awarkoczewski.books.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Genre {

    SF("SF"), CRIMINAL("CRIMINAL"), ADVENTURE("ADVENTURE"), SCIENCE("SCIENCE");

    private String name;
}
