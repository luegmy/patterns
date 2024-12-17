package com.demo.pattern.chain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Director implements Approve {

    private Approve next;

    @Override
    public void loanApplication(double amount) {
        if (amount > 100000) log.info("Atiende el director {}", Director.class.getName());
        else next.loanApplication(amount);
    }


}
