package com.demo.pattern.chain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class ExecutiveTeamLeader implements Approve{
    private Approve next;

    @Override
    public void loanApplication(double amount) {
        if (amount > 10000 && amount <= 50000) log.info("Atiende ejecutivo de lider equipo {}", ExecutiveTeamLeader.class.getName());
        else next.loanApplication(amount);
    }

}
