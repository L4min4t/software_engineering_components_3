package lab1;

public interface IRecordBook {
    String getName();
    String getSurname();
    String getPatronymic();
    String getPhone();

    void setName(String name);
    void setSurname(String surname);
    void setPatronymic(String patronymic);
    void setPhone(String phone);

    String daysToBirthday();
}
