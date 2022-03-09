package com.genx.shopping_cart_manyToOne;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
        System.out.println( "Hiberate Many-To-One & One-To-Many Works!" );
        
        // Initializing Items
        Items item1 = new Items();
        item1.setItemId(1);
        item1.setItemName("Pastry");
        item1.setItemPrice(50);
        
        Items item2 = new Items();
        item2.setItemId(2);
        item2.setItemName("Cupcake");
        item2.setItemPrice(150);
        
        Items item3 = new Items();
        item3.setItemId(3);
        item3.setItemName("Butter");
        item3.setItemPrice(30);
        
        List<Items> allItems = new ArrayList<Items>();
        allItems.add(item1); allItems.add(item2); allItems.add(item3);
        
        // Initializing Cart
        Cart cart = new Cart();
        cart.setCartId(3);
        cart.setItems(allItems);
        
        // Setting cart for the Items
        item1.setCart(cart);
        item2.setCart(cart);
        item3.setCart(cart);
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        s.save(item1); 
        s.save(item2); 
        s.save(item3);
        s.save(cart);
        tx.commit();
        s.close();
        factory.close();
    }
}
