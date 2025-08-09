package com.example.musterPruefung.Bank;


//ToString

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;

public abstract class Konto {

    protected final String accountNumber;
    protected Integer kontostand;
    private static final Set<String> ACC_NUMS = new HashSet<>();

    private Stack<Map<String, Integer>> history = new Stack<>();

    public Konto(Integer kontostand){
        accountNumber = generateUniqueAccNum();
        this.kontostand = kontostand;
    }

    private String generateUniqueAccNum() {
        String nextId = UUID.randomUUID().toString().substring(0, 7);
        while (ACC_NUMS.contains(nextId)) {
            nextId = UUID.randomUUID().toString().substring(0, 7);
        }
        ACC_NUMS.add(nextId);
        return nextId;
    }


    public Integer getKontostand() {
        return kontostand;
    }

    public void setKontostand(Integer kontostand) {
        this.kontostand = kontostand;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public void minus(Integer howmuch){
        kontostand-= howmuch;
        history.push(Map.of("minus", howmuch));
    }
    public void plus(Integer howmuch){
        kontostand+= howmuch;
        history.push(Map.of("plus", howmuch));
    }


    public void undoLastOperation(){
        Map<String, Integer> lastOperation = history.pop();
        if (lastOperation.get("minus") != null) {
            plus(lastOperation.get("minus"));
        } else if (lastOperation.get("plus") != null) {
            minus(lastOperation.get("plus"));
        } else {
            throw new RuntimeException("Unknown operation " + lastOperation.keySet());
        }
    }





}
