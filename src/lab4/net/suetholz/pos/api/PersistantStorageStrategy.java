/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.net.suetholz.pos.api;

import lab4.net.suetholz.pos.Product;

/**
 *
 * @author wsuetholz
 */
public interface PersistantStorageStrategy {
    public abstract CustomerStrategy lookupCustomer(String customerId);
    public abstract Product lookupProduct(String productId);
}
