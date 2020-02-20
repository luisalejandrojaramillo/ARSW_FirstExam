package edu.eci.arsw.exams.moneylaunderingapi.model;

import org.springframework.stereotype.Component;

@Component
public class SuspectAccount {

    public String accountId;

    public SuspectAccount(){ }
    public String getAccountId(){
        return accountId;
    }
    public void setAccountId( String prime )
    {
        this.accountId = accountId;
    }}
