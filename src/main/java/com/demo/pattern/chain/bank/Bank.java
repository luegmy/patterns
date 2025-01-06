package com.demo.pattern.chain.bank;

import lombok.Setter;

@Setter
public class Bank implements Approve {
    private Approve next;

    @Override
    public void loanApplication(double amount) {

        ExecutiveAccount executiveAccount = new ExecutiveAccount();
        this.setNext(executiveAccount);

        ExecutiveTeamLeader teamLeader = new ExecutiveTeamLeader();
        executiveAccount.setNext(teamLeader);

        Manager manager = new Manager();
        teamLeader.setNext(manager);

        Director director = new Director();
        manager.setNext(director);

        if (next != null) {
            next.loanApplication(amount);
        }

    }
}
