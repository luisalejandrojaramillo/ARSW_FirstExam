package edu.eci.arsw.exams.moneylaunderingapi;


import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import edu.eci.arsw.exams.moneylaunderingapi.service.MoneyLaunderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.coyote.Response;

import java.util.List;

@RestController
public class MoneyLaunderingController {

    @Autowired
    MoneyLaunderingService moneyLaunderingService;

    @RequestMapping(value="/fraud-bank-accounts",method = RequestMethod.GET)
    public ResponseEntity<?> getOffendingAccounts(){
        try{
            return new ResponseEntity<>(moneyLaunderingService.getSuspectAccounts(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/fraud-bank-accounts",method = RequestMethod.GET)
    public ResponseEntity<?> postOffendingAccounts(@RequestBody SuspectAccount suspectAccount ){
        try{
            return new ResponseEntity<>(moneyLaunderingService.updateAccountStatus(suspectAccount), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(path = "/fraud-bank-accounts/{accountId}",method = RequestMethod.GET)
    public ResponseEntity<?> getAccountStatusId(@RequestBody SuspectAccount accountId){
        try{
            return new ResponseEntity<>(moneyLaunderingService.getAccountStatus(accountId), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/fraud-bank-accounts/{accountId}")
    public ResponseEntity<?> putAccountStatusId(@RequestBody SuspectAccount accountId){
        try{
            return new ResponseEntity<>(moneyLaunderingService.updateAccountStatus(accountId), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


//curl -i -X POST -HContent-Type:application/json -HAccept:application/json http://localhost:8080/primes -d "{"""user""":"""wilson""","""prime""":"""69"""}"
