package Product;

import java.io.*;
import java.util.*;

public class ProductManagement {
    private List<Product> productList;
    private ProductManagement(){
        productList = new ArrayList<>();
        readFromFile();
    }

    private static ProductManagement productManagement = new ProductManagement();

    public static ProductManagement getProductManagement() {
        return productManagement;
    }

    public void add(Product product){
        productList.add(product);
        saveFile();
    }


    public boolean remove(String id){
        for (Product product : productList){
            if (product.getId().equals(id)){
                productList.remove(product);
                return true;
            }
        }
        return false;
    }

    public Product search(String id){
        for (Product product : productList){
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    public Product fixName(String id, String name){
        for (Product product : productList){
            if (product.getId().equals(id)){
                product.setName(name);
            }
        }
        return null;
    }

    public Product fixSize(String id, double size){
        for (Product product : productList){
            if (product.getId().equals(id)){
                product.setSize(size);
            }
        }
        return null;
    }

    public Product fixPrice(String id, double price){
        for (Product product : productList){
            if (product.getId().equals(id)){
                product.setPrice(price);
            }
        }
        return null;
    }

    public Product fixAmount(String id, int amount){
        for (Product product : productList){
            if (product.getId().equals(id)){
                product.setAmount(amount);
            }
        }
        return null;
    }

    public void display(){
        System.out.println(productList);
    }

    public boolean checkIDProduct(String id){
        for (Product product : productList){
            if (product.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public void saveFile(){
        try {
            FileWriter fileWriter = new FileWriter("product.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p : productList){
                bufferedWriter.write(p.tofile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void readFromFile(){
        productList.clear();
        try {
            FileReader fileReader = new FileReader("product.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                Product product = handleLine(line);
                productList.add(product);
                System.out.println(product);
            }
            bufferedReader.close();
            fileReader.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private Product handleLine(String line) {
        String[] strings = line.split(",");
        return new Product(strings[0], strings[1], strings[2], Double.valueOf(strings[3]), strings[4],
                Integer.parseInt(strings[5]), Double.valueOf(strings[6]));
    }

    public void sortUpAscending(){
        compareProduct compareProduct = new compareProduct();
        productList.sort(compareProduct);
        System.out.println(productList);
        saveFile();
    }

    public void sortDescending(){
        compareProduct compareProduct = new compareProduct();
        productList.sort(compareProduct.reversed());
        System.out.println(productList);
        saveFile();
    }

    @Override
    public String toString() {
        return "ProductManagement{" +
                "productList=" + productList +
                '}';
    }
}
