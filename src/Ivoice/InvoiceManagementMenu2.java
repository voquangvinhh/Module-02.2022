package Ivoice;

import Customer.CustomerManagement;
import Product.Product;
import Product.ProductManagement;

import java.util.Date;
import java.util.Scanner;

public class InvoiceManagementMenu2 {
    Scanner sc = new Scanner(System.in);
    InvoiceManagement2 invoiceManagement2 = InvoiceManagement2.getInvoiceManagement2();
    ProductManagement productManagement = ProductManagement.getProductManagement();
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();

    public InvoiceManagementMenu2(){
    }

    public void menu(){
        int choice = 0;
        do {
            System.out.println("-----Menu Invoice-----");
            System.out.println("1. Thêm hóa đơn " + "\n" +
                    "2. Xóa hóa đơn" + "\n" +
                    "3. Tìm hóa đơn theo ID" + "\n" +
                    "4. Tìm hóa đơn theo ngày" + "\n" +
                    "5. Hiển thị danh sách hóa đơn" + "\n" +
                    "6. Đọc file" + "\n" +
                    "0. Thoát");
            System.out.println("vui lòng lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 -> addInvoice();
                case 2 -> remove();
                case 3 -> search();
                case 4 -> searchInvoiceByDate();
                case 5 -> display();
                case 6 -> invoiceManagement2.readFromFileInvoice();
                default -> System.out.println("Lựa chọn của bạn không tồn tại! ");
            }
        }while (choice != 0);
    }

    private void addInvoice(){
        System.out.println("Nhập ID hóa đơn: ");
        String idInvoice = sc.nextLine();
        while (invoiceManagement2.checkIdInvoice(idInvoice)){
            System.out.println("ID hóa đơn đã tồn tại! Vui lòng nhập lại: ");
            idInvoice = sc.nextLine();
        }
        System.out.println("Nhập Id Khách hàng: ");
        String idCustomer = sc.nextLine();
        while (!customerManagement.checkID(idCustomer)){
            System.out.println("ID khách hàng không tồn tại! Vui lòng nhập lại: ");
            idCustomer = sc.nextLine();
        }
        Date createdDay = new Date();
        Invoice2 newInvoice = new Invoice2(idInvoice, createdDay, idCustomer);
        int choice = -1;

        while (choice != 0) {
            System.out.println("Nhập ID sản phẩm: ");
            String idProduct = sc.nextLine();
            Product product = productManagement.search(idProduct);
            while (!productManagement.checkIDProduct(idProduct)) {
                System.out.println("ID sản phẩm không tồn tại! Vui lòng nhập lại: ");
                idProduct = sc.nextLine();
            }
            System.out.println("Nhập số lượng muốn mua: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            if (product.getAmount() - quantity > 0 || product.getAmount() - quantity == 0) {
                product.setAmount(product.getAmount() - quantity);
                newInvoice.addProduct(idProduct, product.getName(), quantity);
                productManagement.saveFile();
            } else {
                System.out.println("Sản phẩm này hiện tại đã hết hàng!");
            }
            System.out.println("1. Bạn muốn mua thêm không?");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            sc.nextLine();
        }
        invoiceManagement2.addInvoice(newInvoice);
        invoiceManagement2.saveFile();
    }


    public void remove(){
        System.out.println("Nhập ID hóa đơn bạn muốn xóa: ");
        String idInvoice = sc.nextLine();
        while (invoiceManagement2.searchById(idInvoice) == null){
            System.out.println("ID hóa đơn không tồn tại! vui lòng nhập lại: ");
            idInvoice = sc.nextLine();
        }
        invoiceManagement2.searchById(idInvoice);
        System.out.println("Bạn chắc chắn muốn xóa không? " +
                " Nhấn Y nếu đồng ý, nhân N để hủy.");
        String choice = sc.nextLine().toUpperCase();
        if (choice.equals("Y")){
            invoiceManagement2.remove(idInvoice);
            if (invoiceManagement2.searchById(idInvoice) == null){
                System.out.println("Đã xóa thành công");
                invoiceManagement2.saveFile();
            }
        } else if (choice.equals("N")){
            System.out.println("Đã hủy");
        } else {
            System.out.println("Lựa chọn của bạn không hợp lệ! ");
        }
    }

    public void search(){
        System.out.println("Nhập ID hóa đơn: ");
        String id = sc.nextLine();
        if (invoiceManagement2.searchById(id)!= null){
            System.out.println(invoiceManagement2.searchById(id));
        } else
            System.out.println("ID không tồn tại! ");
    }
    public void searchInvoiceByDate(){
        System.out.println("Nhập ngày hóa đơn: ");
        String date = sc.nextLine();
        if (invoiceManagement2.searhInvoiceByDate(date) != null){
            System.out.println(invoiceManagement2.searhInvoiceByDate(date));
        } else {
            System.out.println("Ngày không tìm thấy! ");
        }
    }

    public void display(){
        System.out.println(invoiceManagement2.displayInvoice());
    }
}
