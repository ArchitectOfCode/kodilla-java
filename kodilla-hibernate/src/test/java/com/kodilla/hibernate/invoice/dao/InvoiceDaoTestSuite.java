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
    private ItemDao itemDao;
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product computerMouse1 = new Product("Gamer's mouse");
        Product computerMouse2 = new Product("Gamer's mouse");
        Product computerMouse3 = new Product("Gamer's mouse");
        Product computerKeyboard3 = new Product("Ultraflat computer keyboard");
        Product hardDrive2 = new Product("Hi-speed hard drive 10 000RPM");
        Product product_ssd1 = new Product("Ultra capacity SSD drive");
        Product product_ssd3 = new Product("Ultra capacity SSD drive");
        Product lcdScreen1 = new Product("Frameless ultra flat hi-resolution LCD screen");
        Product lcdScreen2 = new Product("Frameless ultra flat hi-resolution LCD screen");
        Product multiCoreCpu2 = new Product("32-core, 128-thread, 5GHz universal purpose CPU from AMD");
        Product graphicCard1 = new Product("Entry-level graphic card from AMD (8GB VRAM, 4096 cores)");
        Product graphicCard3 = new Product("Entry-level graphic card from AMD (8GB VRAM, 4096 cores)");
        Product spatialPrinter2 = new Product("Home use 3D printer to manufacture spare parts for daily use products");
        Product spatialScanner1 = new Product("Home use 3D scanner for enthusiasts");
        Product spatialScanner2 = new Product("Home use 3D scanner for enthusiasts");

        Item scan1 = new Item(spatialScanner1, new BigDecimal(2399.0), 2);
        Item graphic1 = new Item(graphicCard1, new BigDecimal(1300), 3);
        Item ssd1 = new Item(product_ssd1, new BigDecimal(300), 8);
        Item lcd1 = new Item(lcdScreen1, new BigDecimal(1699.95), 2);
        Item mouse1 = new Item(computerMouse1, new BigDecimal(132), 4);
        Item mouse2 = new Item(computerMouse2, new BigDecimal(131), 6);
        Item printer2 = new Item(spatialPrinter2, new BigDecimal(3600), 1);
        Item cpu2 = new Item(multiCoreCpu2, new BigDecimal(4500), 3);
        Item hd2 = new Item(hardDrive2, new BigDecimal(1200), 6);
        Item scan2 = new Item(spatialScanner2, new BigDecimal(2350), 2);
        Item lcd2 = new Item(lcdScreen2, new BigDecimal(1680), 1);
        Item keyb3 = new Item(computerKeyboard3, new BigDecimal(89), 5);
        Item mouse3 = new Item(computerMouse3, new BigDecimal(131), 5);
        Item graphic3 = new Item(graphicCard3, new BigDecimal(1300), 2);
        Item ssd3 = new Item(product_ssd3, new BigDecimal(310), 6);

        Invoice invoice1 = new Invoice("2019-01-00001");
        invoice1.getItems().add(scan1);
        invoice1.getItems().add(graphic1);
        invoice1.getItems().add(ssd1);
        invoice1.getItems().add(lcd1);
        invoice1.getItems().add(mouse1);

        Invoice invoice2 = new Invoice("2019-01-00234");
        invoice2.getItems().add(mouse2);
        invoice2.getItems().add(printer2);
        invoice2.getItems().add(cpu2);
        invoice2.getItems().add(hd2);
        invoice2.getItems().add(scan2);
        invoice2.getItems().add(lcd2);

        Invoice invoice3 = new Invoice("2019-01-00375");
        invoice3.getItems().add(keyb3);
        invoice3.getItems().add(mouse3);
        invoice3.getItems().add(graphic3);
        invoice3.getItems().add(ssd3);

        scan1.setInvoice(invoice1);
        graphic1.setInvoice(invoice1);
        ssd1.setInvoice(invoice1);
        lcd1.setInvoice(invoice1);
        mouse1.setInvoice(invoice1);
        mouse2.setInvoice(invoice2);
        printer2.setInvoice(invoice2);
        cpu2.setInvoice(invoice2);
        hd2.setInvoice(invoice2);
        scan2.setInvoice(invoice2);
        lcd2.setInvoice(invoice2);
        keyb3.setInvoice(invoice3);
        mouse3.setInvoice(invoice3);
        graphic3.setInvoice(invoice3);
        ssd3.setInvoice(invoice3);

        //When
        invoiceDao.save(invoice1);
        int invoice1Id = invoice1.getId();

        invoiceDao.save(invoice2);
        int invoice2Id = invoice2.getId();
        invoiceDao.save(invoice3);
        int invoice3Id = invoice3.getId();

        //Then
        Assert.assertNotEquals(0, mouse1.getId());
        Assert.assertNotEquals(0, keyb3.getId());
        Assert.assertNotEquals(0, hd2.getId());
        Assert.assertNotEquals(0, ssd1.getId());
        Assert.assertNotEquals( ssd1.getId(), ssd3.getId());

        Assert.assertNotEquals(0, invoice1Id);
        Assert.assertNotEquals(0, invoice2Id);
        Assert.assertNotEquals(0, invoice3Id);

        //CleanUp
        try {
            invoiceDao.delete(invoice1Id);
            invoiceDao.delete(invoice2Id);
            invoiceDao.delete(invoice3Id);
        } catch (Exception e) {
            System.out.println("Sorry, unhandled exception occur.");
        }
    }
}
