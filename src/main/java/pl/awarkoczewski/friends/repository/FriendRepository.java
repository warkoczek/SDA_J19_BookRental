package pl.awarkoczewski.friends.repository;

import pl.awarkoczewski.friends.model.Friend;

public interface FriendRepository {

    Friend addNewFriend(Friend friend);

    Friend update(Friend friend);

    void delete(Friend friend);

    Friend findById(Long id);

    Friend findByName(String name);
}
