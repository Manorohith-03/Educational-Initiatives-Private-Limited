class SoyDecorator extends CoffeeDecorator {
    public SoyDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Soy";
    }

    public double cost() {
        return coffee.cost() + 1.50;
    }
}