package xyz.rpolnx.design_patterns_gof.creational_patterns.factory.abstract_f;


import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
abstract class Card {
    protected String number;
    protected String cardHolderName;
    protected String securityCode;
    protected LocalDate dueDate;
}

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
abstract class CreditCard extends Card {
    protected BigDecimal maxLimit;
    protected BigDecimal currentLimit;

    public CreditCard(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        super(number, cardHolderName, securityCode, dueDate);
    }

    abstract BigDecimal getCurrentLimit();
}

abstract class DebitCard extends Card {
    protected BigDecimal balance;

    public DebitCard(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        super(number, cardHolderName, securityCode, dueDate);
    }

    abstract BigDecimal getBalance();
}

class CreditMastercard extends CreditCard {
    public CreditMastercard(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        super(number, cardHolderName, securityCode, dueDate);
    }

    @Override
    BigDecimal getCurrentLimit() {
        System.out.println("Mastercard credit api current limit");
        return BigDecimal.valueOf(Math.random() * 10000).setScale(2, RoundingMode.HALF_UP);
    }
}

class DebitMastercard extends DebitCard {
    public DebitMastercard(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        super(number, cardHolderName, securityCode, dueDate);
    }

    @Override
    BigDecimal getBalance() {
        System.out.println("Mastercard debit api balance");

        return BigDecimal.valueOf(Math.random() * 10000).setScale(2, RoundingMode.HALF_UP);
    }
}

class VisaCreditCard extends CreditCard {
    public VisaCreditCard(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        super(number, cardHolderName, securityCode, dueDate);
    }

    @Override
    BigDecimal getCurrentLimit() {
        System.out.println("Visa credit api current limit");
        return BigDecimal.valueOf(Math.random() * 7000).setScale(2, RoundingMode.HALF_UP);
    }
}

class VisaDebitCard extends DebitCard {
    public VisaDebitCard(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        super(number, cardHolderName, securityCode, dueDate);
    }

    @Override
    BigDecimal getBalance() {
        System.out.println("Visa debit api balance");
        return BigDecimal.valueOf(Math.random() * 7000).setScale(2, RoundingMode.HALF_UP);
    }
}

interface CardFactory {
    DebitCard createDebitCard(String number, String cardHolderName, String securityCode, LocalDate dueDate);

    CreditCard createCreditCard(String number, String cardHolderName, String securityCode, LocalDate dueDate);
}

class VisaCardFactory implements CardFactory {
    @Override
    public DebitCard createDebitCard(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        return new VisaDebitCard(number, cardHolderName, securityCode, dueDate);
    }

    @Override
    public CreditCard createCreditCard(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        return new VisaCreditCard(number, cardHolderName, securityCode, dueDate);
    }
}

class MastercardFactory implements CardFactory {
    @Override
    public DebitCard createDebitCard(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        return new DebitMastercard(number, cardHolderName, securityCode, dueDate);
    }

    @Override
    public CreditCard createCreditCard(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        return new CreditMastercard(number, cardHolderName, securityCode, dueDate);
    }
}

public class AbstractFactoryRunner {
    public static void main(String[] args) {
        CardFactory mastercardFactory = new MastercardFactory();
        CardFactory visaCardFactory = new VisaCardFactory();

        CreditCard masterCardCredit = mastercardFactory.createCreditCard("12345678",
                "Mastercard Credit", "000", LocalDate.now().plusYears(5));
        DebitCard masterCardDebit = mastercardFactory.createDebitCard("1234",
                "Mastercard Debit", "000", LocalDate.now().plusYears(5));

        CreditCard visaCardCredit = visaCardFactory.createCreditCard("1234", "Visa Credit",
                "000", LocalDate.now().plusYears(5));
        DebitCard visaCardDebit = visaCardFactory.createDebitCard("1234", "Visa Debit",
                "000", LocalDate.now().plusYears(5));

        List<Card> cards = List.of(masterCardCredit, masterCardDebit, visaCardCredit, visaCardDebit);

        masterCardCredit.getCurrentLimit();
        visaCardCredit.getCurrentLimit();

        System.out.println();

        masterCardDebit.getBalance();
        visaCardDebit.getBalance();

        cards.stream().map(Card::getCardHolderName).forEach(System.out::println);
    }
}
