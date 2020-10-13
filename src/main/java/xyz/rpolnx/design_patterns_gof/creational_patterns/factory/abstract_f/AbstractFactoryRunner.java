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

class MastercardCredit extends CreditCard {
    public MastercardCredit(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        super(number, cardHolderName, securityCode, dueDate);
    }

    @Override
    BigDecimal getCurrentLimit() {
        System.out.println("Mastercard credit api current limit");
        return BigDecimal.valueOf(Math.random() * 10000).setScale(2, RoundingMode.HALF_UP);
    }
}

class MastercardDebit extends DebitCard {
    public MastercardDebit(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        super(number, cardHolderName, securityCode, dueDate);
    }

    @Override
    BigDecimal getBalance() {
        System.out.println("Mastercard debit api balance");

        return BigDecimal.valueOf(Math.random() * 10000).setScale(2, RoundingMode.HALF_UP);
    }
}

class VisaCredit extends CreditCard {
    public VisaCredit(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        super(number, cardHolderName, securityCode, dueDate);
    }

    @Override
    BigDecimal getCurrentLimit() {
        System.out.println("Visa credit api current limit");
        return BigDecimal.valueOf(Math.random() * 7000).setScale(2, RoundingMode.HALF_UP);
    }
}

class VisaDebit extends DebitCard {
    public VisaDebit(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        super(number, cardHolderName, securityCode, dueDate);
    }

    @Override
    BigDecimal getBalance() {
        System.out.println("Visa debit api balance");
        return BigDecimal.valueOf(Math.random() * 7000).setScale(2, RoundingMode.HALF_UP);
    }
}

interface CardFactory {
    Card create(String number, String cardHolderName, String securityCode, LocalDate dueDate);
}

interface DebitCardFactory extends CardFactory {
    @Override
    DebitCard create(String number, String cardHolderName, String securityCode, LocalDate dueDate);
}

interface CreditCardFactory extends CardFactory {
    @Override
    CreditCard create(String number, String cardHolderName, String securityCode, LocalDate dueDate);
}

class VisaCreditCardFactory implements CreditCardFactory {
    @Override
    public CreditCard create(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        return new VisaCredit(number, cardHolderName, securityCode, dueDate);
    }
}

class MastercardCreditCardFactory implements CreditCardFactory {
    @Override
    public CreditCard create(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        return new MastercardCredit(number, cardHolderName, securityCode, dueDate);    }
}

class VisaDebitCardFactory implements DebitCardFactory {
    @Override
    public DebitCard create(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        return new VisaDebit(number, cardHolderName, securityCode, dueDate);    }
}

class MastercardDebitCardFactory implements DebitCardFactory {
    @Override
    public DebitCard create(String number, String cardHolderName, String securityCode, LocalDate dueDate) {
        return new MastercardDebit(number, cardHolderName, securityCode, dueDate);    }
}

public class AbstractFactoryRunner {
    public static void main(String[] args) {
        CreditCard masterCardCredit = new MastercardCreditCardFactory()
                .create("12345678", "Mastercard Credit", "000", LocalDate.now().plusYears(5));
        DebitCard masterCardDebit = new MastercardDebitCardFactory()
                .create("1234", "Mastercard Debit", "000", LocalDate.now().plusYears(5));
        CreditCard visaCardCredit = new VisaCreditCardFactory()
                .create("1234", "Visa Credit", "000", LocalDate.now().plusYears(5));
        DebitCard visaCardDebit = new VisaDebitCardFactory()
                .create("1234", "Visa Debit", "000", LocalDate.now().plusYears(5));

        List<Card> cards = List.of(masterCardCredit, masterCardDebit, visaCardCredit, visaCardDebit);

        masterCardCredit.getCurrentLimit();
        visaCardCredit.getCurrentLimit();

        System.out.println();

        masterCardDebit.getBalance();
        visaCardDebit.getBalance();

        cards.stream().map(Card::getCardHolderName).forEach(System.out::println);
    }
}
