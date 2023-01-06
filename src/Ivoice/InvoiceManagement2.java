package Ivoice;

import Customer.Customer;

import javax.sound.midi.MidiFileFormat;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceManagement2 {
    private List<Invoice2> invoiceList2;
    private InvoiceManagement2() {
        invoiceList2 = new ArrayList<>();
    }
    private static InvoiceManagement2 invoiceManagement2 = new InvoiceManagement2();

    public static InvoiceManagement2 getInvoiceManagement2() {
        return invoiceManagement2;
    }

    public void addInvoice(Invoice2 invoice2){
        invoiceList2.add(invoice2);
    }

    public Invoice2 searchById(String id){
        for (Invoice2 invoice : invoiceList2){
            if (invoice.getIdInvoice().equals(id)){
                return invoice;
            }
        }
        return null;
    }

    public boolean checkIdInvoice(String id){
        for (Invoice2 invoice2 : invoiceList2){
            if (invoice2.getIdInvoice().equals(id)){
                return true;
            }
        }
        return false;
    }

    public boolean remove(String id){
        for (Invoice2 invoice2 : invoiceList2){
            if (invoice2.getIdInvoice().equals(id)){
                invoiceList2.remove(invoice2);
                return true;
            }
        }
        return false;
    }


    public List<Invoice2> displayInvoice(){
        return invoiceList2;
    }

    public void saveFile(){
        try {
            FileWriter fileWriter = new FileWriter("invoice.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Invoice2 i : invoiceList2){
                bufferedWriter.write(i.toFileInvocie2());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void readFromFileInvoice(){
        invoiceList2.clear();
        try {
            FileReader fileReader = new FileReader("invoice.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                Invoice2 invoice2 = handleLine(line);
                invoiceList2.add(invoice2);
                System.out.println(invoice2);
            }
            bufferedReader.close();
            fileReader.close();
        }catch (IOException | ParseException e){
            throw new RuntimeException(e);
        }
    }

    private Invoice2 handleLine(String line) throws ParseException {
        String[] strings = line.split(",");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Invoice2 invoice2 = new Invoice2(strings[0], simpleDateFormat.parse(strings[1]), strings[2], strings[strings.length - 2]);
        for (int i = 3; i < strings.length -2; i+=3) {
            invoice2.addProduct(strings[i], strings[i + 1], Integer.parseInt(strings[i + 2]));
        }
        return invoice2;
    }

    public Invoice2 displayInvoiceOfDate(String date){
        for (Invoice2 invoice2 : invoiceList2){
            if (invoice2.getDate().equals(date)){
                return invoice2;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "InvoiceManagement2{" +
                "invoiceList2=" + invoiceList2 +
                '}';
    }
}
