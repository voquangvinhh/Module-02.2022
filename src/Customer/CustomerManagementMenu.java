package Customer;
import java.util.Formattable;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerManagementMenu {
    Scanner sc = new Scanner(System.in);
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
    public CustomerManagementMenu() {
    }
    String id;
    public void Menu() {
        customerManagement.readFromFile();
        int choice = 0;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Thêm khách hàng" + "\n" +
                    "2. Xoá khách hàng" + "\n" +
                    "3. Thay đổi thông tin khách hàng" + "\n" +
                    "4. Tìm kiếm khách hàng" + "\n" +
                    "5. Hiện thị danh khách sách hàng" + "\n" +
                    "6. Đọc file" + "\n" +
                    "0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1-> add();
                case 2 -> remove();
                case 3 -> fix();
                case 4 -> search();
                case 5 -> display();
                case 6 -> customerManagement.readFromFile();
                default -> System.out.println("Lựa chọn của bạn không hợp lệ! ");
            }
        } while (choice!= 0);
    }
    public void add(){
        System.out.println("Thêm ID: ");
        String id = sc.nextLine();
        while (customerManagement.checkID(id)){
            System.out.println("ID đã tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println("Thêm mới tên: ");
        String name = sc.nextLine();
        System.out.println("Thêm mới tuổi: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.println("Thêm mới số điện thoại: ");
        String phone = sc.nextLine();
        while (!Phone.p.matcher(phone).find()){
            System.out.println("Số điện thoại của bạn chưa khớp định dạng!" + "\n" +
                    "Vui lòng nhập đúng định dạng với 10 số và bắt đầu bằng các số: 09x.xxx.xxxx hoặc 08x.xxx.xxxx hoặc " +
                    "07x.xxx.xxxx hoặc 03x.xxx.xxxx" + "\n" + "VD: 0915555999");
            System.out.println("Vui lòng nhập lại: ");
            phone = sc.nextLine();
        }
        System.out.println("Thêm mới địa chỉ: ");
        String address = sc.nextLine();

        Customer customer = new Customer(id, name, age, phone, address);
        customerManagement.add(customer);
    }
    public void remove(){
        System.out.println("Nhập ID bạn muốn xóa");
        String id = sc.nextLine();
        while (!customerManagement.checkID(id)){
            System.out.println("ID không tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }

        System.out.println(customerManagement.search(id));
        System.out.println("Bạn chắc chắn muốn xóa không? " +
                " Nhấn Y nếu đồng ý, nhân N để hủy.");
        String choice = sc.nextLine().toUpperCase();
        if (choice.equals("Y")){
            customerManagement.remove(id);
            if (!customerManagement.checkID(id)){
                System.out.println("Đã xóa thành công");
                customerManagement.saveFile();
            }
        } else if (choice.equals("N")){
            System.out.println("Đã hủy");
        } else {
            System.out.println("Lựa chọn của bạn không hợp lệ!");
        }
    }

    public void search(){
        System.out.println("Nhập ID muốn tìm kiếm: ");
        String id = sc.nextLine();
        while (!customerManagement.checkID(id)){
            System.out.println("ID không tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println(customerManagement.search(id));
    }

    public void display(){
        customerManagement.display();
    }


    public void fix(){
        System.out.println("Nhập ID khách hàng muốn thay đổi: ");
        id = sc.nextLine();
        while (!customerManagement.checkID(id)){
            System.out.printf("ID không tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        menufix();
    }

    public void menufix(){
        int choice = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----Menu Sửa-----");
            System.out.println("1. Sửa tên" + "\n" +
                    "2. Sửa số điện thoại." + "\n" +
                    "3. Sửa địa chỉ" + "\n"+
                    "0. Thoát");
            System.out.println("Vui lòng lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1 -> {
                    System.out.println("Nhập tên mới: ");
                    String name = sc.nextLine();
                    customerManagement.fixName(id, name);
                    customerManagement.saveFile();
                }
                case 2 -> {
                    System.out.println("Nhập số điện thoại mới: ");
                    String phone = sc.nextLine();
                    customerManagement.fixPhone(id, phone);
                    customerManagement.saveFile();
                }
                case 3 -> {
                    System.out.println("Nhập đỉa chỉ mới: ");
                    String address = sc.nextLine();
                    customerManagement.fixAddress(id, address);
                    customerManagement.saveFile();
                }
                default -> System.out.println("Lựa chọn của bạn không hợp lệ!");
            }
        }while (choice != 0);
    }
}