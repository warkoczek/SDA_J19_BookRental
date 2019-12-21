package pl.awarkoczewski.friends.repository;

import org.junit.Assert;
import org.junit.Test;
import pl.awarkoczewski.friends.model.Friend;


public class InMemoryFriendRepositoryTest {

    FriendRepository friendRepository = new InMemoryFriendRepository();

    @Test
    public void addNewFriendShouldPlaceNewFriendAtIndex5() {

        //given
        Friend friend = new Friend(5L, "Darek", "Barunak", "abarunak@yahoo.com");
        Long expectedResult = 5l;

        //when
        friendRepository.addNewFriend(friend);
        Friend result = friendRepository.findById(friend.getId());

        Assert.assertEquals(expectedResult,result.getId());

    }

    @Test
    public void updateShouldUpdateExistingFriendsEmail() {

        //given
        Friend toUpdateFriend = new Friend(3l,"Przemek","Rajgulak","frajgulak@yahoo.com");
        Friend updatedFriend = new Friend(3l,"Przemek", "Rajgulak", "prajgulak@yahoo.com");
        String expectedResult = "prajgulak@yahoo.com";

        //when
        Friend result = friendRepository.update(updatedFriend);

        //then
        Assert.assertEquals(expectedResult,result.getEmail());
    }

    //TODO test for  delete method


    @Test
    public void findByIdShouldReturnLastNameKsztuśForId5() {

        //given
        Long id = 4l;
        String expectedLastName = "Ksztuś";

        //when
        Friend resultFriendById = friendRepository.findById(id);

        //then
        Assert.assertEquals(expectedLastName,resultFriendById.getLastName());


    }

    @Test
    public void findByNameShouldReturnFriendWithId1() {

        //given
        final String fullName = "Adam Warkoczewski";
        final Long expectedResult = 1l;

        //when
        Friend result = friendRepository.findByName(fullName);

        //then
        Assert.assertEquals(expectedResult,result.getId());
    }

}