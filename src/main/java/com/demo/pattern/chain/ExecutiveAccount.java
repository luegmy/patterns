package com.demo.pattern.chain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class ExecutiveAccount implements Approve {

    private Approve next;

    @Override
    public void loanApplication(double amount) {
        if (amount <= 10000) log.info("Atiende ejecutivo de cuentas {}", ExecutiveAccount.class.getName());
        else next.loanApplication(amount);
    }


}
