/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.net.suetholz.pos.entries;

import lab4.net.suetholz.pos.api.CustomerStrategy;
import lab4.net.suetholz.pos.api.PosEntryStrategy;
import lab4.net.suetholz.pos.api.SaleOutputStrategy;
import lab4.net.suetholz.pos.api.SaleStrategy;
import lab4.net.suetholz.pos.api.StoreStrategy;

/**
 *
 * @author wsuetholz
 */
public class PosEntryCustomer implements PosEntryStrategy {
    
    private CustomerStrategy customer;

    public PosEntryCustomer (CustomerStrategy customer) {
	setCustomer(customer);
    }

    public final CustomerStrategy getCustomer() {
	return customer;
    }

    public final void setCustomer(CustomerStrategy customer) {
	if (customer == null) {
	    throw new IllegalArgumentException();
	}
	this.customer = customer;
    }
    
    @Override
    public final void processEntry(StoreStrategy store, SaleStrategy sale, SaleOutputStrategy receiptOutput) {
	if (sale == null) {
	    throw new IllegalArgumentException();
	}
	sale.setCustomer(customer);
    }
    
}
