package pl.awarkoczewski.friends;

import lombok.AllArgsConstructor;
import pl.awarkoczewski.friends.model.Friend;
import pl.awarkoczewski.friends.repository.FriendRepository;

@AllArgsConstructor
public class FriendFacade {

    private FriendRepository friendRepository;

    public Friend saveNewFriend(Friend friend){
        return friendRepository.addNewFriend(friend);
    }

    public void cancelFriend(Friend friend){

        friendRepository.delete(friend);
    }

    public Friend updateFriend(Friend friend){

        return friendRepository.update(friend);
    }

    public Friend getFriendByFullName(String name){

        return friendRepository.findByName(name);
    }


}
