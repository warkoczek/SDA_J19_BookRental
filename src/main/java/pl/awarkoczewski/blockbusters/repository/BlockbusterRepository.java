package pl.awarkoczewski.blockbusters.repository;

import pl.awarkoczewski.blockbusters.model.Blockbuster;

public interface BlockbusterRepository {

    boolean isBlockbuster(Blockbuster blockbuster);
}
