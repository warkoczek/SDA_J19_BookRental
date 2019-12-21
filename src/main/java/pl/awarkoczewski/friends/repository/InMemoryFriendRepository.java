package pl.awarkoczewski.friends.repository;

import pl.awarkoczewski.friends.model.Friend;
import pl.awarkoczewski.friends.model.FriendNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryFriendRepository implements FriendRepository{

    private List<Friend> friendList;
    private Long nextId;

    public InMemoryFriendRepository() {

        friendList = new ArrayList<>();
        friendList.add(new Friend(1l, "Adam", "Warkoczewski", "awarkoczewski@yahoo.com"));
        friendList.add(new Friend(2l, "Filip", "Gondulek", "fgondulek@yahoo.com"));
        friendList.add(new Friend(3l, "Przemek", "Rajgulak", "frajgulak@yahoo.com"));
        friendList.add(new Friend(4l, "Maciej", "Ksztuś", "mksztuś@yahoo.com"));
        nextId = Long.valueOf(friendList.size()+1);
    }

    @Override
    public Friend addNewFriend(Friend friend) {
        friend.setId(nextId);
        friendList.add(friend);
        return friend;
    }

    @Override
    public Friend update(Friend friend) {

        Friend friendToUpdate = friendList.stream()
                .filter(friend1 -> friend1.getId().equals(friend.getId()))
                .findFirst().orElseThrow(() -> new FriendNotFoundException("Friend does not exist"));

        friendToUpdate.setEmail(friend.getEmail());

        return friendToUpdate;
    }

    @Override
    public void delete(Friend friend) {
        friendList.remove(friend);
    }

    @Override
    public Friend findById(Long id) {

        return friendList.stream()
                .filter(friend -> id.equals(friend.getId()))
                .findFirst().orElseThrow(()-> new FriendNotFoundException("Friend does not exist in our database"));
    }

    @Override
    public Friend findByName(String name) {

        return friendList.stream()
                .filter(friend -> friend.getFullName().equalsIgnoreCase(name))
                .findFirst().orElseThrow(()-> new FriendNotFoundException("Such a friend does not exist"));
    }
}
