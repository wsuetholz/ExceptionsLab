/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.net.suetholz.pos.entries;

import lab4.net.suetholz.pos.api.LineItemStrategy;
import lab4.net.suetholz.pos.api.PosEntryStrategy;
import lab4.net.suetholz.pos.api.SaleOutputStrategy;
import lab4.net.suetholz.pos.api.SaleStrategy;
import lab4.net.suetholz.pos.api.StoreStrategy;

/**
 *
 * @author wsuetholz
 */
public class PosEntryProductNQuantity implements PosEntryStrategy {

    LineItemStrategy lineItem;

    public PosEntryProductNQuantity(LineItemStrategy lineItem) {
	setLineItem(lineItem);
    }

    public final LineItemStrategy getLineItem() {
	return lineItem;
    }

    public final void setLineItem(LineItemStrategy lineItem) {
	if (lineItem == null) {
	    throw new IllegalArgumentException();
	}
	this.lineItem = lineItem;
    }

    @Override
    public final void processEntry(StoreStrategy store, SaleStrategy sale, SaleOutputStrategy receiptOutput) {
	if (sale == null) {
	    throw new IllegalArgumentException();
	}
	sale.addLineItem(lineItem);
    }

}
