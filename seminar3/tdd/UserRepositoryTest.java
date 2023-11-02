package seminar3.tdd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserRepositoryTest {

    @Test
    public void testLogoutAllNonAdminUsers() {
        User adminUser = new User("admin", "adminpass", true);
        User regularUser1 = new User("user1", "userpass1", false);
        User regularUser2 = new User("user2", "userpass2", false);

        adminUser.authenticate("admin", "adminpass");
        regularUser1.authenticate("user1", "userpass1");
        regularUser2.authenticate("user2", "userpass2");

        UserRepository userRepository = new UserRepository();

        userRepository.addUser(adminUser);
        userRepository.addUser(regularUser1);
        userRepository.addUser(regularUser2);

        userRepository.logoutAllNonAdminUsers();

        assertTrue(adminUser.isAuthenticate);
        assertFalse(regularUser1.isAuthenticate);
        assertFalse(regularUser2.isAuthenticate);
    }
}
