package model;

import controller.AccountsController;

import java.time.LocalDate;

public class Loan {
    private int amount;
    private final int step;
    private LocalDate lastPaid;
    private final LoanKind kind;

    public Loan(int amount,LoanKind kind){
        this.kind = kind;
        step = amount/10;
        amount = step*10;
        lastPaid = LocalDate.now();
        this.amount = amount;
    }

    public void pay(Account account){
        if (amount == 0)
            return;
        if (kind.equals(LoanKind.DAILY)){
            while(lastPaid.plusDays(1).compareTo(LocalDate.now()) < 1){
                lastPaid = lastPaid.plusDays(1);
                AccountsController.payReceipt(account,step);
                amount -= step;
            }
        }
        if (kind.equals(LoanKind.WEEKLY)){
            while(lastPaid.plusWeeks(1).compareTo(LocalDate.now()) < 1){
                lastPaid = lastPaid.plusWeeks(1);
                AccountsController.payReceipt(account,step);
                amount -= step;
            }
        }
        if (kind.equals(LoanKind.MONTHLY)){
            while(lastPaid.plusMonths(1).compareTo(LocalDate.now()) < 1){
                lastPaid = lastPaid.plusMonths(1);
                AccountsController.payReceipt(account,step);
                amount -= step;
            }
        }
    }

}
