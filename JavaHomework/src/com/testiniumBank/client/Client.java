package com.testiniumBank.client;

import java.util.HashMap;
import java.util.Map;

public class Client {
    private String nameAndSurname;
    private long tcNumber;
    private String bankClientNumber;
    private Map<String, Object> clients= new HashMap<>();
    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public long getTcNumber() {
        return tcNumber;
    }

    public void setTcNumber(long tcNumber) {
        this.tcNumber = tcNumber;
    }

    public String getBankClientNumber() {
        return bankClientNumber;
    }

    public void setBankClientNumber(String bankClientNumber) {
        this.bankClientNumber = bankClientNumber;
    }

    public Map<String, Object> getClients() {
        return clients;
    }

    public void setClients(Map<String, Object> clients) {
        this.clients = clients;
    }
}
