package game.utility;

import java.util.function.UnaryOperator;

public class Pair<A, B> {
    private final A a;
    private final B b;

    public Pair(final A a, final B b) {
        this.a = a;
        this.b = b;
    }

    public Pair<A, B> copy(final UnaryOperator<A> copyA, final UnaryOperator<B> copyB) {
        return new Pair<>(copyA.apply(this.a), copyB.apply(this.b));
    }

    public Pair<A, B> copy() {
        return new Pair<>(this.a, this.b);
    }

    public A getA() {
        return this.a;
    }

    public B getB() {
        return this.b;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((a == null) ? 0 : a.hashCode());
        result = prime * result + ((b == null) ? 0 : b.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        if (a == null) {
            if (other.a != null) {
                return false;
            }
        } else if (!a.equals(other.a)) {
            return false;
        }
        if (b == null && other.b != null) {
            return false;
        }
        return b != null && b.equals(other.b);
    }

    @Override
    public String toString() {
        return "Pair [a=" + a + ", b=" + b + "]";
    }

}
