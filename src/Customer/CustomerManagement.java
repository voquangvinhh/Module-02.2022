package Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CustomerManagement {

    private List<Customer> customerList;

    private CustomerManagement() {
        customerList = new ArrayList<>();
    }

    private static final CustomerManagement customerManagement = new CustomerManagement();

    public static CustomerManagement getCustomerManagement() {
        return customerManagement;
    }


    public void add(Customer customer){
        customerList.add(customer);
        saveFile();
    }

    public boolean remove(String id){
        for (Customer customer : customerList){
            if (customer.getId().equals(id)){
                customerList.remove(customer);
                return true;
            }
        }
        return false;
    }

    public String getCustomer(String id){
        for (Customer customer : customerList){
            if (customer.getId().equals(id)){
                return customer.getName();
            }
        }
        return null;
    }

    public Customer search(String id){
        for (Customer customer : customerList){
            if (customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }

    public Customer fixName(String id, String name){
        for (Customer customer: customerList){
            if (customer.getId().equals(id)){
                customer.setName(name);
            }
        }
        return null;
    }

    public Customer fixPhone(String id, String phone){
        for (Customer customer: customerList){
            if (customer.getId().equals(id)){
                customer.setPhone(phone);
            }
        }
        return null;
    }

    public Customer fixAddress(String id, String address){
        for (Customer customer: customerList){
            if (customer.getId().equals(id)){
                customer.setAddress(address);
            }
        }
        return null;
    }

    public void display(){
        System.out.println(customerList);
    }

    public boolean checkID(String id){
        for (Customer customer : customerList){
            if (customer.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public void saveFile(){
        try {
            FileWriter fileWriter = new FileWriter("customer.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer c : customerList){
                bufferedWriter.write(c.tofile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void readFromFile(){
        customerList.clear();
        try {
            FileReader fileReader = new FileReader("customer.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                Customer customer = handleLine(line);
                customerList.add(customer);
                System.out.println(customer);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private Customer handleLine(String line) {
        String[] strings = line.split(",");
        return new Customer(strings[0], strings[1], Integer.parseInt(strings[2]) , strings[3], strings[4]);
    }

    @Override
    public String toString() {
        return "CustomerManagement{" +
                "customerList=" + customerList +
                '}';
    }
}