package task3;

class TestClass {
    public double method(double a) {
        return Math.exp(-Math.abs(a)) * Math.sin(a);
    }

    public double method(double a, int x) {
        return Math.exp(-Math.abs(a) * x) * Math.sin(x);
    }
}
