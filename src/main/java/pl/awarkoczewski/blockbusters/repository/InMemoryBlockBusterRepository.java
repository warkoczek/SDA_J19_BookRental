package pl.awarkoczewski.blockbusters.repository;

import pl.awarkoczewski.blockbusters.model.Blockbuster;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBlockBusterRepository implements BlockbusterRepository{

    List<Blockbuster> blockbusterList;
    Long nextId;

    public InMemoryBlockBusterRepository() {

        blockbusterList = new ArrayList<>();

        blockbusterList.add(new Blockbuster(1L,1L,1L));
        nextId = Long.valueOf(blockbusterList.size());

    }

    @Override
    public boolean isBlockbuster(Blockbuster blockbuster) {

        return blockbuster.getRentalCount()>300 ? true : false;
    }
}
