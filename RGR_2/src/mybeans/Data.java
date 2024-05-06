package mybeans;

public class Data {

    private String date;
    private double x;
    private double y;

    public Data() {
    }

    public Data(double y, double x, String date) {
        this.y = y;
        this.x = x;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Data{" +
                "date='" + date + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}