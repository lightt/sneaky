package com.ficture.sneaky.service;

import com.ficture.sneaky.thrift.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;


public class SneakyService implements Sneaky.Iface {
    private static final Logger logger = LoggerFactory.getLogger(SneakyService.class);

    public void ping() {}

    public User putUser(User u) {
        return null;
    }

    public void deleteUser(User u) {

    }

    public Account putAccount(Account a) {
        return null;
    }

    public void deleteAccount(Account a) {

    }

    public List<Account> getAssociatedAccounts(User u) {
        return new LinkedList<Account>();
    }

    public void scrape(Account a) {

    }
}
