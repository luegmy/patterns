package com.demo.pattern.chain.bank;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class Manager implements Approve{
    private Approve next;

    @Override
    public void loanApplication(double amount) {
        if (amount > 50000 && amount <= 100000) log.info("Atiende administrador {}", Manager.class.getName());
        else if (next != null) next.loanApplication(amount);
    }


}
