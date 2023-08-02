package game.shared;

public class Pair<A, B> {
    private final A a;
    private final B b;

    public Pair(final A a, final B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return this.a;
    }

    public B getB() {
        return this.b;
    }

    @Override
    public String toString() {
        return "Pair [a=" + a + ", b=" + b + "]";
    }

}
