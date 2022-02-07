package lab1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public interface IRecordBook {
    public String getName();
    public String getSurname();
    public String getPatronymic();
    public String getPhone();

    public void setName(String name);
    public void setSurname(String surname);
    public void setPatronymic(String patronymic);
    public void setPhone(String phone);

    public String daysToBirthday();
}
