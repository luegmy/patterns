package com.demo.pattern.chain;

import lombok.Setter;

@Setter
public class Bank implements Approve {
    private Approve next;

    @Override
    public void loanApplication(double amount) {

        Director director = new Director(next);
        Manager manager = new Manager(director);
        ExecutiveTeamLeader teamLeader = new ExecutiveTeamLeader(manager);
        ExecutiveAccount executiveAccount = new ExecutiveAccount(teamLeader);
        setNext(executiveAccount);

        next.loanApplication(amount);

    }
}
