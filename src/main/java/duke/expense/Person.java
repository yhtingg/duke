package duke.expense;

public class Person {
    private String name;
    private double amountOwed;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, double amountOwed) {
        this.name = name;
        this.amountOwed = amountOwed;
    }

    public String getName() {
        return this.name;
    }

    public double getAmountOwed() {
        return this.amountOwed;
    }

    public double getAmountLent() {
        return this.amountOwed * -1;
    }

    public void receive(double amount) {
        this.amountOwed += amount;
    }

    public void pay(double amount) {
        this.amountOwed -= amount;
    }

    public boolean owesYouMoney() {
        return this.amountOwed < 0;
    }

    public boolean lentYouMoney() {
        return this.amountOwed > 0;
    }

    public boolean hasNoMoreTransactions() {
        return this.amountOwed == 0;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o instanceof Person && this.name.equals(((Person) o).name);
    }

    @Override
    public String toString() {
        String verb = amountOwed > 0 ? "owe" : "lent";
        return String.format("You %s %s $%.2f.", verb, name, amountOwed);
    }
}
