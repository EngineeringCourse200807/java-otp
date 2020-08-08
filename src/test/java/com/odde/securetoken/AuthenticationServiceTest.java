package com.odde.securetoken;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    @Test
    public void is_valid_test() {
        Logger mockLogger = mock(Logger.class);
        RsaTokenDao stubRsaTokenDao = mock(RsaTokenDao.class);
        AuthenticationService target = new AuthenticationService(mockLogger, stubRsaTokenDao);
        when(stubRsaTokenDao.getRandom("joey")).thenReturn("111111");

        boolean actual = target.isValid("joey", "91000000");

        assertFalse(actual);
        verify(mockLogger).output("login failed");
    }

}
