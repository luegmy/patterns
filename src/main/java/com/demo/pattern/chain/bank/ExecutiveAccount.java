package com.demo.pattern.chain.bank;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class ExecutiveAccount implements Approve {

    private Approve next;

    @Override
    public void loanApplication(double amount) {
        if (amount <= 10000) log.info("Atiende ejecutivo de cuentas {}", ExecutiveAccount.class.getName());
        else if (next != null) next.loanApplication(amount);
    }


}
