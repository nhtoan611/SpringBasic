package com.nhtoan611.aopdemo.dao;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + "DB work: add account");
    }

    @Override
    public List<Integer> getAccountId() {
        return Arrays.asList(1, 2, 3);
    }

    @Override
    public void getAccountById() {
        System.out.println("Return account id");
        throw new RuntimeException("Exception go here");
    }
}
