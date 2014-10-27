/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.net.suetholz.pos;

import lab4.net.suetholz.pos.api.PersistantStorageStrategy;
import lab4.net.suetholz.pos.api.StoreStrategy;
import lab4.net.suetholz.pos.api.SaleInputStrategy;
import lab4.net.suetholz.pos.api.SaleOutputStrategy;
import lab4.net.suetholz.pos.input.FakeRegisterInput;
import lab4.net.suetholz.pos.output.ReceiptConsoleOuput;
import lab4.net.suetholz.pos.storage.FakePersistantCustomer;
import lab4.net.suetholz.pos.storage.FakePersistantCustomerType;
import lab4.net.suetholz.pos.storage.FakePersistantDiscount;
import lab4.net.suetholz.pos.storage.FakePersistantDiscountType;
import lab4.net.suetholz.pos.storage.FakePersistantProduct;
import lab4.net.suetholz.pos.storage.FakePerstantStorage;
import lab4.net.suetholz.pos.store.BasicStore;

/**
 *
 * @author wsuetholz
 */
public class Main {

    public static void main(String[] args) {
	FakePersistantCustomer[] persistantCustomers = {
	    new FakePersistantCustomer("101", "Cust 101", FakePersistantCustomerType.Basic, "NoDisc"),
	    new FakePersistantCustomer("102", "Cust 102", FakePersistantCustomerType.Preferred, "Preferred5pct")
	};
	FakePersistantProduct[] persistantProducts = {
	    new FakePersistantProduct("Prod001", "Product 001", "Shoes", 15.00, "Buy3_5Dlrs"),
	    new FakePersistantProduct("Prod002", "Product 002", "Shoes", 15.00, "15PctOff")
	};

	FakePersistantDiscount[] persistantDiscounts = {
	    new FakePersistantDiscount("NoDisc", FakePersistantDiscountType.None, "No Discount", 0, 0.0),
	    new FakePersistantDiscount("Buy3_5Dlrs", FakePersistantDiscountType.ByQuantity, "Buy 3 or More Save $5.00", 3, 5.0),
	    new FakePersistantDiscount("15PctOff", FakePersistantDiscountType.ByPercentage, "15% Discount", 0, 15.0),
	    new FakePersistantDiscount("Preferred5pct", FakePersistantDiscountType.ByPercentage, "Preferred Customer 15% Discount", 0, 5.0)
	};
	PersistantStorageStrategy storage = new FakePerstantStorage(persistantCustomers, persistantProducts, persistantDiscounts);

	SaleInputStrategy input = new FakeRegisterInput(storage);
	SaleOutputStrategy output = new ReceiptConsoleOuput();
	StoreStrategy store = new BasicStore("Kohls #2675", "Pewaukee, WI", "Welcome to Kohls", "Thank you for shopping at Kohls", 5.25);
	PosRegister register = new PosRegister(100, store, input, output);

	FakeRegisterInput finput = (FakeRegisterInput) input;
	finput.addClearKey();
	finput.addCustomer("101");
	finput.addProductNQuantity("Prod001", 10);
	finput.addProductNQuantity("Prod002", 2);
	finput.addProductNQuantity("Prod001", 1);
	finput.addAmountTendered(200.00);
	finput.addClearKey();
	finput.addCustomer("102");
	finput.addProductNQuantity("Prod001", 10);
	finput.addProductNQuantity("Prod002", 2);
	finput.addProductNQuantity("Prod001", 1);
	finput.addAmountTendered(200.00);

	register.run();
    }
}
