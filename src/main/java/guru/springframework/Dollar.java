package guru.springframework;

public class Dollar {

    public int amount;

    public Dollar() {
    }

    public Dollar(int amount) {
        this.amount = amount;
    }

    public void times(int t) {

        this.amount *= t;
    }
}
