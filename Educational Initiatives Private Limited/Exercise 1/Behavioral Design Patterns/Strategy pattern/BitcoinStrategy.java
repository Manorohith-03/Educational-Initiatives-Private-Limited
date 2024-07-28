class BitcoinStrategy implements PaymentStrategy {
    public BitcoinStrategy(String bitcoinAddress) {
    }

    public void pay(int amount) {
        System.out.println(amount + " paid using Bitcoin.");
    }
}