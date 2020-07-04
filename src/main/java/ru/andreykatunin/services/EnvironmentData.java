package ru.andreykatunin.services;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class EnvironmentData {
    private final Environment environment;

    public String hostIP;
    public String hostPort;


    public EnvironmentData(Environment environment) {
        this.environment = environment;
        try {
            hostIP = InetAddress.getLocalHost().getHostAddress();
            hostPort = environment.getProperty("server.port");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
