class PayPalStrategy implements PaymentStrategy {
    public PayPalStrategy(String emailId) {
    }

    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal.");
    }
}