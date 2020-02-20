package edu.eci.arsw.exams.moneylaunderingapi.service;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MoneyLaunderingServiceStub implements MoneyLaunderingService {


    private List<SuspectAccount> suspectAccounts;

    public MoneyLaunderingServiceStub(){
        suspectAccounts= new ArrayList<>();
        SuspectAccount sp1 = new SuspectAccount();
        sp1.setAccountId("1");


    }

    @Override
    public SuspectAccount updateAccountStatus(SuspectAccount suspectAccount) {
        if(validUpdateAccount(suspectAccount)) return suspectAccount ;
        return suspectAccount;
    }

    private boolean validUpdateAccount(SuspectAccount suspectAccount){
        try{
            SuspectAccount suspectAccount1 = findAccountStatus(suspectAccount.getAccountId());
            return  false;
        }catch (Exception e){
            suspectAccounts.add(suspectAccount);
            return  true;
        }
    }

    public SuspectAccount findAccountStatus(String accountId) throws Exception {
        for (SuspectAccount i : suspectAccounts) {
            if (i.getAccountId().equals(accountId)) {
                return i;
            }
        }
        throw new Exception("accountId {"+accountId +"} does not exist");
    }
    @Override
    public SuspectAccount getAccountStatus(SuspectAccount accountId) throws Exception {
        for (SuspectAccount i : suspectAccounts) {
            if (i.getAccountId().equals(accountId)) {
                return i;
            }
        }throw new Exception("accountId {"+accountId +"} does not exist");
    }
    @Override
    public List<SuspectAccount> getSuspectAccounts() {
        return suspectAccounts;
    }
}