package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product computerMouse = new Product("Gamer's mouse");
        Product computerKeyboard = new Product("Ultraflat computer keyboard");
        Product hardDrive = new Product("Hi-speed hard drive 10 000RPM");
        Product ssd = new Product("Ultra capacity SSD drive");
        Product lcdScreen = new Product("Frameless ultra flat hi-resolution LCD screen");
        Product multiCoreCpu = new Product("32-core, 128-thread, 5GHz universal purpose CPU from AMD");
        Product graphicCard = new Product("Entry-level graphic card from AMD (8GB VRAM, 4096 cores)");
        Product spatialPrinter = new Product("Home use 3D printer to manufacture spare parts for daily use products");
        Product spatialScanner = new Product("Home use 3D scanner for enthusiasts");

        Item scan1 = new Item(spatialScanner, new BigDecimal(2399.0), 2);
        Item grapic1 = new Item(graphicCard, new BigDecimal(1300), 3);
        Item ssd1 = new Item(ssd, new BigDecimal(300), 8);
        Item lcd1 = new Item(lcdScreen, new BigDecimal(1699.95), 2);
        Item mouse1 = new Item(computerMouse, new BigDecimal(132), 4);
        Item mouse2 = new Item(computerMouse, new BigDecimal(131), 6);
        Item printer2 = new Item(spatialPrinter, new BigDecimal(3600), 1);
        Item cpu2 = new Item(multiCoreCpu, new BigDecimal(4500), 3);
        Item hd2 = new Item(hardDrive, new BigDecimal(1200), 6);
        Item scan2 = new Item(spatialScanner, new BigDecimal(2350), 2);
        Item lcd2 = new Item(lcdScreen, new BigDecimal(1680), 1);
        Item keyb3 = new Item(computerKeyboard, new BigDecimal(89), 5);
        Item mouse3 = new Item(computerMouse, new BigDecimal(131), 5);
        Item grapic3 = new Item(graphicCard, new BigDecimal(1300), 2);
        Item ssd3 = new Item(ssd, new BigDecimal(310), 6);

        System.out.println(scan1.getProduct().getId());

        Invoice invoice1 = new Invoice("2019-01-00001");
        invoice1.getItems().add(scan1);
        invoice1.getItems().add(grapic1);
        invoice1.getItems().add(ssd1);
        invoice1.getItems().add(lcd1);
        invoice1.getItems().add(mouse1);
        System.out.println(invoice1.getNumber());
        System.out.println(invoice1.getId());
        System.out.println(invoice1.getItems().size());


        Invoice invoice2 = new Invoice("2019-01-00234");
        invoice2.getItems().add(mouse2);
        invoice2.getItems().add(printer2);
        invoice2.getItems().add(cpu2);
        invoice2.getItems().add(hd2);
        invoice2.getItems().add(scan2);
        invoice2.getItems().add(lcd2);
        System.out.println(invoice2.getNumber());
        System.out.println(invoice2.getId());
        System.out.println(invoice2.getItems().size());

        Invoice invoice3 = new Invoice("2019-01-00375");
        invoice3.getItems().add(keyb3);
        invoice3.getItems().add(mouse3);
        invoice3.getItems().add(grapic3);
        invoice3.getItems().add(ssd3);

        //When
        productDao.save(computerMouse);
        int computerMouseId = computerMouse.getId();
        productDao.save(computerKeyboard);
        int computerKeyboardId = computerKeyboard.getId();
        productDao.save(hardDrive);
        int hardDriveId = hardDrive.getId();
        productDao.save(ssd);
        int ssdId = ssd.getId();

        invoiceDao.save(invoice1);
        int invoice1Id = invoice1.getId();
        invoiceDao.save(invoice2);
        int invoice2Id = invoice2.getId();
        invoiceDao.save(invoice3);
        int invoice3Id = invoice3.getId();

        //Then
        Assert.assertNotEquals(0, computerMouseId);
        Assert.assertNotEquals(0, computerKeyboardId);
        Assert.assertNotEquals(0, hardDriveId);
        Assert.assertNotEquals(0, ssdId);

        Assert.assertNotEquals(0, invoice1Id);
        Assert.assertNotEquals(0, invoice2Id);
        Assert.assertNotEquals(0, invoice3Id);

        //CleanUp
        try {
            productDao.delete(computerMouseId);
            productDao.delete(computerMouseId);
            productDao.delete(hardDriveId);
            productDao.delete(ssdId);

            invoiceDao.delete(invoice1Id);
            invoiceDao.delete(invoice2Id);
            invoiceDao.delete(invoice3Id);
        } catch (Exception e) {
            System.out.println("Sorry, unhandled exception occur.");
        }
    }
}
