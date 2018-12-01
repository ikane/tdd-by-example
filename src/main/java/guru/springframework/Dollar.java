package guru.springframework;

public class Dollar {

    int amount;

    public Dollar() {
    }

    public Dollar(int amount) {
        this.amount = amount;
    }

    public void times(int multiplier) {

        this.amount *= multiplier;
    }

}
