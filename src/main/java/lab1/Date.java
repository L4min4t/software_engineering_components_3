package lab1;

public class Date {
    private int day;
    private int month;
    private int year;

//    public Date() {
//
//    }

    public Date(int d, int m, int y) {
        this.setDay(d);
        this.setMonth(m);
        this.setYear(y);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) throws IllegalArgumentException {
        if(day >= 1 && day <= 31){
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid day number");
        }
    }

    public void setMonth(int month) throws IllegalArgumentException {
        if(month >= 1 && month <= 12) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid month number");
        }
    }

    public void setYear(int year) throws IllegalArgumentException {
        if(year != 0) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid year number");
        }
    }

    @Override
    public String toString(){
        return day + "." + month + "." + year;
    }
}
