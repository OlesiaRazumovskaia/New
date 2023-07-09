package ATM.model.score;

import ATM.model.account.Account;
import ATM.model.money.Money;

public class CreditScore extends Score {
    public CreditScore(Money balance, Account owner, Integer
            number) {
        super(balance, owner, number);
    }
}
