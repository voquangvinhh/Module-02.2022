package User;

import Product.Product;

import java.util.ArrayList;
import java.util.List;

public class AccountManagement {
    private List<Account> accountList;
    private AccountManagement(){
        accountList = new ArrayList<>();
    }

    private static AccountManagement accountManagement = new AccountManagement();

    public static AccountManagement getAccountManagement(){
        return accountManagement;
    }

    public void add(Account account){
        accountList.add(account);
    }

    public boolean checkUser(String user){
        for (Account account : accountList){
            if (account.getUser().equals(user)){
                return true;
            }
        }
        return false;
    }

    public boolean checkPass(String password){
        for (Account account : accountList){
            if (account.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void AddProductBy(Product product){

    }

}
