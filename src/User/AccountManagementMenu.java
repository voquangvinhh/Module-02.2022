package User;

import Customer.CustomerManagement;
import Product.ProductManagement;

import java.util.Scanner;
import java.util.WeakHashMap;

public class AccountManagementMenu {
    Scanner sc = new Scanner(System.in);

    AccountManagement accountManagement = AccountManagement.getAccountManagement();
    ProductManagement productManagement = ProductManagement.getProductManagement();

    public AccountManagementMenu() {
    }

    public void menu(){
        int choice = 0;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Đăng nhập" + "\n" +
                    "2. Đăng ký" + "\n" +
                    "0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1 -> LogIn();
                case 2 -> Registration();
                default -> System.out.println("Lựa chọn của bạn không hợp lệ");
            }
        }while (choice != 0);
    }

    public void LogIn(){
        System.out.println("Nhập tài khoản: ");
        String user = sc.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = sc.nextLine();
        while (true){
            if (!accountManagement.checkUser(user) && !accountManagement.checkPass(password)){
                System.out.println("Tài khoản hoặc mật khẩu của bạn nhập chưa đúng! Vui lòng nhập lại!");
                System.out.println("Nhập tài khoản: ");
                user = sc.nextLine();
                System.out.println("Nhập mật khẩu: ");
                password = sc.nextLine();
            } else if (!accountManagement.checkPass(password)){
                System.out.println("Mật khẩu bạn nhập chưa đúng vui lòng nhập lại!");
            } else
                menuUser();
                break;
        }
    }

    private void menuUser() {
        int choice = 0;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Hiện thị danh sách sản phẩm tại cửa hàng" + "\n" +
                    "2. Tìm kiếm sản phẩm" + "\n" +
                    "0. Thoát");
            switch (choice) {
                case 1 -> displayProduct();
                case 2 -> searchProduct();
                default -> System.out.println("Lựa chọn của bạn không hợp lệ!");
            }
        }while (choice != 0);
    }

    public void Registration(){
        System.out.println("Nhập tài khoản: ");
        String user = sc.nextLine();
        System.out.println("Mật khẩu phải có ít nhất một ký tự là số hoặc chữ cái in hoa, chữ cái đầu tiên luôn là chữ " +
                "in hoa, không có ký tự đặc biệt và có độ dài từ 8 đến 31 ký tự" + "VD: 18quangvinh, Vinhh1999 ");
        System.out.println("Nhập mật khẩu: ");
        String password = sc.nextLine();
        while (!Password.p.matcher(password).find()){
            System.out.println("Mật khẩu chưa khớp với định dạng!" + "\n" +
                    "Vui lòng nhập lại: ");
            password = sc.nextLine();
        }

        Account account = new Account(user, password);
        accountManagement.add(account);
    }

    private void displayProduct(){
        productManagement.display();
        int choice = 0;
        do {
            System.out.println("Nhập Id sản phẩm bạn muốn mua: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1: {
                    if (!productManagement.checkIDProduct("1")){
                        System.out.println("Sản phẩm hiện tại không tồn tại!");
                        break;
                    } else {
                        System.out.println(productManagement.checkIDProduct("1"));
                        System.out.println("Bạn có muốn mua sản phẩm này không? " + "\n" +
                                "Nhấn Y nếu đồng ý, nhân N để hủy!");
                        String chooseBy = sc.nextLine().toUpperCase();
                        if (chooseBy.equals("Y")){

                        }
                    }
                }
            }
        } while (choice != 0);
    }
//Chưa xong
    private void searchProduct(){
        System.out.println("Nhập id sản phẩm: ");
        String id = sc.nextLine();
        while (!productManagement.checkIDProduct(id)){
            System.out.println("ID sản phẩm không tồn tại" + "\n" +
                    "Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println(productManagement.search(id));
    }


}
