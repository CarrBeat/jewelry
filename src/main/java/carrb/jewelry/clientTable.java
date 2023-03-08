package carrb.jewelry;

public class clientTable {
    String idClient, phone, surname, name, secondName, birthDate, email, totalOrderSum, discountLevel;

    public clientTable(String idClient, String phone, String surname, String name, String secondName, String birthDate,
                       String email, String totalOrderSum, String discountLevel){
        this.idClient = idClient;
        this.phone = phone;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.email = email;
        this.totalOrderSum = totalOrderSum;
        this.discountLevel = discountLevel;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTotalOrderSum() {
        return totalOrderSum;
    }

    public void setTotalOrderSum(String totalOrderSum) {
        this.totalOrderSum = totalOrderSum;
    }

    public String getDiscountLevel() {
        return discountLevel;
    }

    public void setDiscountLevel(String discountLevel) {
        this.discountLevel = discountLevel;
    }




}
