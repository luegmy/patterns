package com.demo.pattern.chain.bank;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Director implements Approve {

    private Approve next;

    @Override
    public void loanApplication(double amount) {
        if (amount > 100000) log.info("Atiende el director {}", Director.class.getName());
        else if (next != null) next.loanApplication(amount);
    }


}
