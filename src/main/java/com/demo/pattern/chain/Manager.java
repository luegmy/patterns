package com.demo.pattern.chain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Manager implements Approve{
    private Approve next;

    @Override
    public void loanApplication(double amount) {
        if (amount > 50000 && amount <= 100000) log.info("Atiende administrador {}", Manager.class.getName());
        else next.loanApplication(amount);
    }


}
