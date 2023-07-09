package ATM.model.score;

import ATM.model.account.Account;
import ATM.model.constants.Constants;
import ATM.model.money.Money;

public class DebetScore extends Score {
    private CreditScore creditScore;

    public DebetScore(Money balance, Account owner, Integer
            number, CreditScore creditScore) {
        super(balance, owner, number);
        this.creditScore = creditScore;
    }

    public void addMoney(Money money) {

        if (creditScore.getBalance().getValue() < Constants.BLOCKING_BALANCE) {
            System.out.println("Account blocked!");
            return;
        } else {
            double usdValueIn = money.getValue() * money.getCurrency().getUsdCource();
            double usdValueThis = getBalance().getValue() * getBalance().getCurrency().getUsdCource();
            getBalance().setValue(usdValueIn + usdValueThis);
        }
    }

    public Money getMoney(double balanceLess) {
        
        if (creditScore.getBalance().getValue() < Constants.BLOCKING_BALANCE) {
            System.out.println("Account blocked!");
            return getBalance();
        } else {
            if (balanceLess > 30000) {
                throw new IllegalArgumentException("Wrong balance less!");
            }
            getBalance().setValue(getBalance().getValue() - balanceLess);

            return getBalance();
        }
    }
}