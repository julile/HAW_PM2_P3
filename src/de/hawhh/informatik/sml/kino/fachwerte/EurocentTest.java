package de.hawhh.informatik.sml.kino.fachwerte;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class EurocentTest
{

	private Eurocent eu1;
	private Eurocent eu2;

	@Before
	public void setUp()
	{
		eu1 = Eurocent.get(1234);
		eu2 = Eurocent.get(05, 00);
	}

	@Test
	public void testeKonstruktoren()
	{
		assertNotNull(eu1);
		assertNotNull(eu2);
	}

	@Test
	public void testeToEuroString()
	{
		Eurocent eu3 = Eurocent.toEuro("12,34");
		assertEquals(eu1, eu3);
		Eurocent eu4 = Eurocent.toEuro("5,00");
		assertEquals(eu2, eu4);
		Eurocent eu5 = Eurocent.toEuro("05,00");
		assertEquals(eu2, eu5);
	}

	@Test
	public void testeToEuroInt()
	{
		Eurocent eu3 = Eurocent.toEuro(1234);
		assertEquals(eu1, eu3);
		Eurocent eu4 = Eurocent.toEuro(500);
		assertEquals(eu2, eu4);
		// Eurocent eu5 = Eurocent.toEuro(0500);
		// assertEquals(eu2, eu5);
	}

	@Test
	public void testeToString()
	{
		assertEquals(eu1.toString(), "12,34");
		assertEquals(eu2.toString(), "5,00");
	}

	@Test
	public void testeAdd()
	{
		Eurocent eu3 = eu2.add(eu1);
		Eurocent eu4 = eu1.add(eu2);
		assertEquals(eu4, eu3);
		assertEquals(eu3.toString(), "17,34");
	}

	@Test
	public void testeSub()
	{
		Eurocent eu3 = eu1.sub(eu2);
		assertEquals(eu3.toString(), "7,34");
	}

	@Test
	public void testeMul()
	{
		Eurocent eu3 = eu1.mul(2);
		assertEquals(eu3.toString(), "24,68");
	}
}
