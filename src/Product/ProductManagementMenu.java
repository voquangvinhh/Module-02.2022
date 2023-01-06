package Product;

import User.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductManagementMenu {
    Scanner sc = new Scanner(System.in);

    ProductManagement productManagement = ProductManagement.getProductManagement();


    public ProductManagementMenu(){
    }
    String id;

    public void Menu(){
        productManagement.readFromFile();
        int choice = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----MENU-----");
            System.out.println("1. Thêm sản phẩm" + "\n" +
                    "2. Xóa sản phẩm" + "\n" +
                    "3. Thay đổi thông tin sản phẩm" + "\n" +
                    "4. Tìm kiếm sản phẩm" + "\n" +
                    "5. Hiển thị danh sách sản phẩm" + "\n" +
                    "6. Sắp xếp theo giá tăng dần" + "\n" +
                    "7. Sắp xếp theo giá giảm dần" + "\n" +
                    "8. Đọc file" + "\n" +
                    "0. Thoát");
            System.out.println("Vui lòng lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addProduct();
                case 2 -> removeProduct();
                case 3 -> fixProduct();
                case 4 -> searchByIdProduct();
                case 5 -> displayListProduct();
                case 6 -> SortAscendingByPrice();
                case 7 -> SortDescendingByPrice();
                case 8 -> Read();
                default -> System.out.println("Lựa chọn của bạn không tồn tại!");
            }
        } while (choice != 0);
    }


    private void addProduct(){
        System.out.println("Nhập ID sản phẩm: ");
        String id = sc.nextLine();
        while (productManagement.checkIDProduct(id)){
            System.out.println("ID đã tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println("Nhập Hãng: ");
        String trademark = sc.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.println("Nhập kích cỡ: ");
        Double size = sc.nextDouble(); sc.nextLine();
        System.out.println("Nhập màu: ");
        String color = sc.nextLine();
        System.out.println("Nhập số lượng: ");
        int amount = sc.nextInt(); sc.nextLine();
        System.out.println("Nhập giá: ");
        Double price = sc.nextDouble(); sc.nextLine();

        Product product = new Product(id, trademark, name, size, color, amount, price);
        productManagement.add(product);
        productManagement.saveFile();
    }

    private void removeProduct(){
        System.out.println("Nhập ID sản phẩm bạn muốn xóa: ");
        String id = sc.nextLine();
        while (!productManagement.checkIDProduct(id)){
            System.out.println("ID không tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println("Bạn chắc chắn muốn xóa không? " +
                " Nếu đồng ý nhấn Y, nhấn N để hủy bỏ");
        String choice = sc.nextLine().toUpperCase();
            if (choice.equals("Y")){
                productManagement.remove(id);
                if (!productManagement.checkIDProduct(id)){
                    System.out.println("Đã xóa thành công");
                    productManagement.saveFile();
                } else {
                    System.out.println("File chưa thể xóa");
                }
            } else if (choice.equals("N")){
                System.out.println("Đã hủy");
            } else {
                System.out.println("Lựa chọn của bạn không hợp lệ");
            }
    }

    private void searchByIdProduct(){
        System.out.println("Nhập ID sản phẩm bạn muốn tìm kiếm: ");
        id = sc.nextLine();
        while (!productManagement.checkIDProduct(id)){
            System.out.println("ID sản phẩm không tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        System.out.println(productManagement.search(id));
    }

    private void displayListProduct(){
        productManagement.display();
    }

    private void fixProduct(){
        System.out.println("Nhập ID sản phẩm muốn thay đổi: ");
        id = sc.nextLine();
        while (!productManagement.checkIDProduct(id)){
            System.out.println("ID không tồn tại! Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        MenuFixProduct();
    }

    private void MenuFixProduct(){
        int choice = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("----- Menu -----");
            System.out.println("1. Thay đổi tên sản phẩm" + "\n" +
                    "2. Thay đổi Size" + "\n" +
                    "3. Thay đổi số lượng" + "\n" +
                    "4. Thay đổi giá" + "\n" +
                    "0. Thoát");
            System.out.println("Vui lòng lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 -> {
                    System.out.println("Nhập tên mới: ");
                    String name = sc.nextLine();
                    productManagement.fixName(id, name);
                    productManagement.saveFile();
                }
                case 2 -> {
                    System.out.println("Nhập Size mới: ");
                    Double size = sc.nextDouble(); sc.nextLine();
                    productManagement.fixSize(id, size);
                    productManagement.saveFile();
                }
                case 3 -> {
                    System.out.println("Nhập số lượng thay đổi: ");
                    int amount = sc.nextInt(); sc.nextLine();
                    productManagement.fixAmount(id, amount);
                    productManagement.saveFile();
                }
                case 4 -> {
                    System.out.println("Nhập giá bạn thay đổi");
                    Double price = sc.nextDouble(); sc.nextLine();
                    productManagement.fixPrice(id, price);
                    productManagement.saveFile();
                }
                default -> System.out.println("Lựa chọn của bạn không tồn tại ");
            }
        } while (choice != 0);
    }

    private void SortAscendingByPrice(){
        productManagement.sortUpAscending();
    }

    private void SortDescendingByPrice(){
        productManagement.sortDescending();
    }

    private void Read(){
        productManagement.readFromFile();
    }

}
