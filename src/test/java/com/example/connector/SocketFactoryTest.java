package com.example.connector;

import org.junit.jupiter.api.Test;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.*;

class SocketFactoryTest {

    @Test
    void createSocketThrowsWithoutInstanceName() {
        SocketFactory factory = new SocketFactory(new Properties());
        assertThrows(java.io.IOException.class, factory::createSocket);
    }
}
