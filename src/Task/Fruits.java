package Task;

public final class Fruits implements FruitSum{
    public String type;
    private String color;
    public int amount;

    public Fruits() {
    }

    public Fruits(String type, String color, int amount) {
        this.type = type;
        this.color = color;
        this.amount = amount;
    }

    public Fruits(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setTypeAndAmount(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int sum(int arrived) {
        return amount+=arrived;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", amount=" + amount +
                '}';
    }
}
