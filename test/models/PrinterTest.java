package models;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;


import org.junit.Before;
import org.junit.Test;

import exception.IllegalPlantNameException;
import models.Printer;

/**
 * 
 * @author jushita
 * Date: 06/01/2020
 * Course: CS622
 * 
 * Class to test Printer Class 
 */
public class PrinterTest {
	@Test
	public void shouldTakeUserInput() {
	    Printer printer= new Printer();
	    // mocking user input
	    String input = "pothos";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    // checking to see if getting user input
	    assertEquals("pothos", printer.userInput());
	}
}
