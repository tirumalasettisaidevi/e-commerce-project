package com.niit.doshoponline.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.doshoponline.daointerfaces.SupplierDAO;
import com.niit.doshoponline.entity.Supplier;

public class SupplierDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired
	private static Supplier supplier;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		//scan the complete package and check for annoations like
		//@Component, @Controller, @Repository, @Service
		context.scan("com.niit"); 
		//clear the context(bean factory, and recreate all the
		//instances of the classes which are there in com.niit
		//with proper annotations.
		context.refresh();
		//ask the context to get instance of SupplierDAO
		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		supplier = (Supplier)context.getBean("supplier");
	}
	@Ignore
	@Test
	public void saveSupplierTestCase()
	{
		supplier = new Supplier();
		supplier.setId("3");
		supplier.setName("Lenovo");
		supplier.setAddress("Mumbai");
		
	  boolean status = 	supplierDAO.save(supplier);
	  
	  assertEquals("save supplier test case", true, status);
	}
	
	@Ignore
	@Test
	public void updateSupplierTestCase()
	{
		supplier.setId("3");
		supplier.setName("Motorola");
		supplier.setAddress("Hyderabad");
		boolean status = supplierDAO.update(supplier);
		assertEquals("update test case", true,status );
	}
	@Ignore
	@Test
	public void getSupplierSuccessTestCase()
	{
		
	supplier= supplierDAO.get("1");
	
	assertNotNull("get supplier test case", supplier);
	}
	@Ignore
	@Test
	public void getSupplierFailureTestCase()
	{
		
	supplier= supplierDAO.get("5");
	
	assertNull("get supplier test case", supplier);
	}
	@Ignore
	@Test
	public void deleteSupplierSuccessTestCase()
	{
	boolean status =	supplierDAO.delete("3");
	assertEquals("delete supplier succss test case" , true, status);
	
	}
	@Ignore
	@Test
	public void deleteSupplierFailureTestCase()
	{
	boolean status =	supplierDAO.delete("3");
	assertEquals("delete supplier failure test case" , false, status);
	
	}
	
	@Ignore
	@Test
	public void getAllSuppliersTestCase()
	{
	List<Supplier>	suppliers = supplierDAO.list();
	
	assertEquals("get all usres " , 2, suppliers.size() );
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
