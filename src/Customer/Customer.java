package Customer;

public class Customer {
    private String id;
    private String name;
    private int age;
    private String phone;
    private String address;

    public Customer() {
    }

    public Customer(String id, String name, int age, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "----Customer----" + "\n" +
                "ID: " + id + "\n" +
                "Tên: " + name + "\n" +
                "Tuổi: " + age + "\n" +
                "Số điện thoại: " + phone + "\n" +
                "Địa chỉ: " + address + "\n";
    }

    public String tofile() {
        return id +  "," + name + "," + age + "," + phone + "," + address;
    }
}