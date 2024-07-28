class MochaDecorator extends CoffeeDecorator {
    public MochaDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Mocha";
    }

    public double cost() {
        return coffee.cost() + 2.00;
    }
}