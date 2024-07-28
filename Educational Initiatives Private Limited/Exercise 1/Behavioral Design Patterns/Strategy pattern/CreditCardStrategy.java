class CreditCardStrategy implements PaymentStrategy {
    public CreditCardStrategy(String cardNumber) {
    }

    public void pay(int amount) {
        System.out.println(amount + " paid with credit card.");
    }
}