package Ivoice;

import Customer.CustomerManagement;
import Product.Product;
import Product.ProductManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Invoice2 {
    private String idInvoice;
    private String idCustomer;
    private String IDProduct;
    private String nameCustomer;
    private Date date;

    private Map<String, Integer> hashMap;

    public Invoice2() {
    }

    ProductManagement productManagement = ProductManagement.getProductManagement();
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();

    public Invoice2(String idInvoice, String idCustomer, String IDProduct, String nameCustomer, Date date, Map<String, Integer> hashMap) {
        this.idInvoice = idInvoice;
        this.idCustomer = idCustomer;
        this.IDProduct = IDProduct;
        this.nameCustomer = nameCustomer;
        this.date = date;
        this.hashMap = hashMap;
    }

    public Invoice2(String idInvoice, Date date, String idCustomer) {
        this.idInvoice = idInvoice;
        this.idCustomer = idCustomer;
        this.date = new Date();
        this.hashMap = new HashMap<>();
    }

    public Invoice2(String idInvoice, Date date, String nameCustomer, String idCustomer) {
        this.idInvoice = idInvoice;
        this.nameCustomer = nameCustomer;
        this.idCustomer = idCustomer;
        this.date = new Date();
        this.hashMap = new HashMap<>();
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIDProduct() {
        return IDProduct;
    }

    public void setIDProduct(String IDProduct) {
        this.IDProduct = IDProduct;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Integer> getHashMap() {
        return hashMap;
    }

    public void addProduct(String idProduct,String name, int quantity){
        getHashMap().put(idProduct, quantity);
    }

    public double getSubTotal(String idProduct, int quantity){
        Product product = productManagement.search(idProduct);
        double result;
        double priceOfProduct = product.getPrice();
        result = priceOfProduct * quantity;
        return result;
    }

    public double getTotal(){
        double total = 0;
        for (String key: getHashMap().keySet()){
            total += getSubTotal(key, getHashMap().get(key));
        }
        return total;
    }

    public String getProductInformation(){
        StringBuffer result = new StringBuffer();
        for(String key : hashMap.keySet()){
            String id = productManagement.search(key).getId();
            result.append(id).append(",").append(productManagement.search(id).getName()).
                    append(",").append(hashMap.get(key)).append(",");
        }
        return result.toString();
    }


    public String stringCreatedDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(getDate());
    }

    @Override
    public String toString() {
        return "-----Invoice-----" + "\n" +
                "ID Hóa đơn: " + idInvoice + "\n" +
                "Ngày: " + stringCreatedDay() +  "\n" +
                "Tên khách hàng: " + nameCustomer + "\n" +
                "Thông tin sản phẩm: " + getProductInformation() + "\n" +
                "Tổng: " + getTotal()  + "\n";
    }

    public String toFileInvocie2() {
        return idInvoice + "," + stringCreatedDay() + "," + nameCustomer
                + "," + getProductInformation() + "," + getTotal();
    }
}
