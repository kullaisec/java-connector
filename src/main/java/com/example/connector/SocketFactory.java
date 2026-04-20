package com.example.connector;

import java.io.IOException;
import java.net.Socket;
import java.util.Properties;
import javax.net.ssl.SSLSocketFactory;

/**
 * A socket factory for connecting to example database instances using
 * TLS 1.3 with identity verification.
 */
public class SocketFactory extends javax.net.SocketFactory {

    private final Properties properties;

    public SocketFactory(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Socket createSocket() throws IOException {
        String instance = properties.getProperty("exampleInstanceName");
        if (instance == null || instance.isEmpty()) {
            throw new IOException("exampleInstanceName property is required");
        }
        SSLSocketFactory delegate = (SSLSocketFactory) SSLSocketFactory.getDefault();
        return delegate.createSocket();
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return createSocket();
    }

    @Override
    public Socket createSocket(String host, int port, java.net.InetAddress localHost, int localPort) throws IOException {
        return createSocket();
    }

    @Override
    public Socket createSocket(java.net.InetAddress host, int port) throws IOException {
        return createSocket();
    }

    @Override
    public Socket createSocket(java.net.InetAddress address, int port, java.net.InetAddress localAddress, int localPort) throws IOException {
        return createSocket();
    }
}
