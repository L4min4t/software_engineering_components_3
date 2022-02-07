package lab1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public final class RecordBook extends lab1.Date implements IRecordBook{
    private String name;
    private String surname;
    private String patronymic;
    private String phone;

    public RecordBook (String n, String s, String p, String ph, int d, int m, int y){
        super(d, m, y);
        this.setName(n);
        this.setSurname(s);
        this.setPatronymic(p);
        this.setPhone(ph);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) throws IllegalArgumentException {
        if(!name.isBlank()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name can not be empty");
        }

    }

    public void setSurname(String surname) throws IllegalArgumentException {
        if(!surname.isBlank()){
            this.surname = surname;
        } else {
            throw new IllegalArgumentException("Surname can not be empty");
        }
    }

    public void setPatronymic(String patronymic) throws IllegalArgumentException {
        if(!patronymic.isBlank()){
            this.patronymic = patronymic;
        } else {
            throw new IllegalArgumentException("Patronymic can not be empty");
        }
    }

    public void setPhone(String phone) throws IllegalArgumentException {
        if(Pattern.matches("^(?:\\+380)\\d{9}$", phone)) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Incorrect phone number");
        }
    }

    @CallMethod
    public String daysToBirthday() {
        Calendar dateOfBirth = new GregorianCalendar(getYear(), getMonth() - 1, getDay());
        int yearDayOfBirth = dateOfBirth.get(Calendar.DAY_OF_YEAR);
        int yearToday = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);

        if (yearToday == yearDayOfBirth){
            return "birthday today";
        } else if(yearToday < yearDayOfBirth) {
            return "birthday in " + (yearDayOfBirth-yearToday) + " day(s)";
        } else {
            return "birthday in " + (365+yearDayOfBirth-yearToday) + " day(s)";
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nSurname: %s\nPatronymic: %s\nPhone: %s\nDate of birth: %d.%d.%d",
                name, surname, patronymic, phone, getDay(), getMonth(), getYear());
    }
}
