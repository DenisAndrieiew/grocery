package com.goit.grocery.model.entity;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProductConstructorTest {
@Test
public void testShouldCreateNewProduct1stConstructor_happyPath(){
//given
    Product product = new Product('a', new BigDecimal(1.23), 3, new BigDecimal(3));
//when
String actual = product.toString();
//then
assertEquals("Product{id=a, price=1.229999999999999982236431605997495353221893310546875, " +
        "actionCount=3, actionPrice=3}", actual);
    }
    @Test
    public void testShouldCreateNewProduct2ndConstructor_happyPath(){
//given
        Product product = new Product('a', new BigDecimal(1.25));
//when
        String actual = product.toString();
//then
        assertEquals("Product{id=a, price=1.25, actionCount=0, actionPrice=null}", actual);
    }
    @Test
    public void testShouldCreateNewProduct3rdConstructor_happyPath(){
//given
        Product product = new Product('a', 3.13, 5, 14);
//when
        String actual = product.toString();
//then
        assertEquals("Product{id=a, price=3.12999999999999989341858963598497211933135986328125, " +
                "actionCount=5, actionPrice=14}", actual);
    }
    @Test
    public void testShouldCreateNewProduct4thConstructor_happyPath(){
//given
        Product product = new Product('a', 9.11);
//when
        String actual = product.toString();
//then
        assertEquals("Product{id=a, price=9.1099999999999994315658113919198513031005859375, " +
                "actionCount=0, actionPrice=null}", actual);
    }
}
