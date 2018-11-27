package com.bestshoes;

/**
 * --------------------------------------------- 
 * @author JIEUN KWON (991447941)
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Nov 25, 2018 
 * modified Date : Nov 25, 2018
 * --------------------------------------------- 
 *
 * Page Task	: OrdersDAO 
 * 				  all tasks related to access database 'Orders' 
 *
 * references db structure : 
   Orders 
		orderId int NOT NULL auto_increment primary key,
	    itemId int NOT NULL,
	    customerNo	int NOT NULL,
		quantity int NOT NULL,
	    price	decimal(7,2) NOT NULL,
	    orderStatus varchar(10) null,
	    Orderdate date not null,
	    Foreign KEY (itemId) references shoes(itemId),
	    Foreign KEY (customerNo) references customers(customerNo)
	
    
 *
 */ 
public class OrdersDAO {

}
