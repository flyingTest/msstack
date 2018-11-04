package com.grydtech.msstack.core.connectors.serviceregistry;

public class Member {

    private String id;
    private String name;
    private String host;
    private int port;

    public String getId() {
        return id;
    }

    public Member setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public String getHost() {
        return host;
    }

    public Member setHost(String host) {
        this.host = host;
        return this;
    }

    public int getPort() {
        return port;
    }

    public Member setPort(int port) {
        this.port = port;
        return this;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", databaseName='" + name + '\'' +
                ", host='" + host + '\'' +
                ", databasePort=" + port +
                '}';
    }
}
