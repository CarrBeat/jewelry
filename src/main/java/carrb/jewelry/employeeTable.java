package carrb.jewelry;

public class employeeTable {
    String idEmployee;
    String phone;
    String surname;
    String name;
    String secondName;
    String birthdate;
    String passData;
    String INN;
    String SNILS;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public employeeTable (String idEmployee, String phone, String surname, String name, String secondName, String birthdate,
                          String passData, String INN, String SNILS){
        this.idEmployee = idEmployee;
        this.phone = phone;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.birthdate = birthdate;
        this.passData = passData;
        this.INN = INN;
        this.SNILS = SNILS;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassData() {
        return passData;
    }

    public void setPassData(String passData) {
        this.passData = passData;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getSNILS() {
        return SNILS;
    }

    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
    }

}
