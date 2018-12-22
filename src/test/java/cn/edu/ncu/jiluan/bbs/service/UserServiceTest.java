package cn.edu.ncu.jiluan.bbs.service;

import cn.edu.ncu.jiluan.bbs.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userServiceUnderTest;
    @Test
    public void findUserByEmail() {
        final String email = "1234";

        // Run the test
        final User result = userServiceUnderTest.findUserByEmail(email);

        // Verify the results
        assertEquals(email, result.getEmail());
    }
}