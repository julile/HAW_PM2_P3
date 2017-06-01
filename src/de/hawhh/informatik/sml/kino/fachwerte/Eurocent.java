package de.hawhh.informatik.sml.kino.fachwerte;

/*
 * Eurocent, erhält einen Int-Wert, um daraus ein Eurocent-Objekt zu generieren.
 * Kann in String ausgegeben werden
 * kann von String und Int auslesen (static)
 * ist final
 */

public final class Eurocent
{
	int _euro;
	int _cent;

	/**
	 * 
	 * @param eurocent
	 * 
	 * @requires eurocent >= 0
	 * @requires eurocent < 1000000000
	 * @requires eurocent not null
	 */
	public static Eurocent get(int eurocent)
	{
		assert eurocent >= 0 : "Vorbedingung verletzt: eurocent >=0";
		assert eurocent < 1000000000 : "Vorbedingung verletzt: eurocent < 1000000000";

		int cent = eurocent % 100;
		eurocent = eurocent / 100;

		return new Eurocent(eurocent, cent);
	}

	/**
	 * 
	 * @param euro
	 * @param cent
	 * 
	 * @requires cent >= 0, <100
	 * @requires euro >= 0
	 */
	public static Eurocent get(int euro, int cent)
	{
		assert euro >= 0 : "Vorbedingung verletzt: euro>=0";
		assert cent >= 0 : "Vorbedingung verletzt: cent>=0";
		assert cent < 100 : "Vorbedingung verletzt: cent<100";

		return new Eurocent(euro, cent);
	}

	private Eurocent(int euro, int cent)
	{
		_euro = euro;
		_cent = cent;
	}

	@Override
	public boolean equals(Object o)
	{
		boolean ergebnis = false;
		if (o instanceof Eurocent)
		{
			Eurocent eu = (Eurocent) o;
			ergebnis = (eu.toInt() == this.toInt());
		}
		return ergebnis;
	}

	@Override
	public int hashCode()
	{
		return toInt();
	}

	public int toInt()
	{
		return (_euro * 100 + _cent);
	}

	public String toString()
	{
		String c = Integer.toString(_cent);
		if (_cent < 10)
			c = "0" + _cent;
		return _euro + "," + c;
	}

	/**
	 * 
	 * @param eu1
	 * @param eu2
	 * @return
	 * 
	 * @requires Eurocent eu1 not null
	 * @requires Erucoent eu2 not null
	 */
	public static Eurocent add(Eurocent eu1, Eurocent eu2)
	{
		assert eu1 != null : "Vorbedingung verletzt: eu1 != null";
		assert eu2 != null : "Vorbedingung verletzt: eu2 != null";

		int sum = eu1.toInt() + eu2.toInt();
		return Eurocent.get(sum);
	}

	public Eurocent add(Eurocent eu)
	{
		return Eurocent.add(this, eu);
	}

	/**
	 * 
	 * @param eu1
	 * @param eu2
	 * @return
	 * 
	 * @requires Eurocent eu1 not null
	 * @requires Erucoent eu2 not null
	 * @requires Eurocent eu1 >= eu2
	 */
	public static Eurocent sub(Eurocent eu1, Eurocent eu2)
	{
		assert eu1 != null : "Vorbedingung verletzt: eu1 != null";
		assert eu2 != null : "Vorbedingung verletzt: eu2 != null";
		assert eu1.toInt() >= eu2
				.toInt() : "Vorbedingung verletzt: eu1.toInt()>=eu2.toInt()";

		int sum = eu1.toInt() - eu2.toInt();
		return Eurocent.get(sum);
	}

	public Eurocent sub(Eurocent eu)
	{
		return Eurocent.sub(this, eu);
	}

	/**
	 * 
	 * @param eu
	 * @param mul
	 * @return
	 * 
	 * @requires eu1 not null
	 * @requires mul >= 0
	 */
	public static Eurocent mul(Eurocent eu, int mul)
	{
		assert mul >= 0 : "Vorbedingung verletzt: mul >= 0";
		assert eu != null : "Vorbedingung verletzt: eu != null";

		int prod = eu.toInt() * mul;
		return Eurocent.get(prod);
	}

	/**
	 * 
	 * @param mul
	 * @return
	 * 
	 * @requires mul >= 0
	 */
	public Eurocent mul(int mul)
	{
		return Eurocent.mul(this, mul);
	}

	/**
	 * 
	 * @param s
	 * @return
	 * 
	 * @requires s not null
	 * @requires s matches \\d{1,7}[,]\\d{2}
	 */
	public static Eurocent toEuro(String s)
	{
		assert s != null : "Vorbedingung verletzt: s != null";
		assert s.matches(
				"\\d{1,7}[,]\\d{2}") : "Vorbedingung verletzt: s.matches(\\d{1,7}[.]\\d{2})";

		int i = s.indexOf(",");
		int euro = 0;
		int cent = 0;
		int multiplikator = 1;
		// euro teil ermitteln
		for (int j = i - 1; j >= 0; j--)
		{
			euro = euro + multiplikator * ((int) s.charAt(j) - '0');
			multiplikator = multiplikator * 10;
		}
		// cent teil ermitteln
		if (s.length() - 1 >= i + 2)
		{
			cent = (10 * ((int) s.charAt(i + 1) - '0'))
					+ (1 * ((int) s.charAt(i + 2) - '0'));
		} else if (s.length() - 1 == i + 1)
		{
			cent = (10 * ((int) s.charAt(i + 1) - '0'));
		}
		return Eurocent.get(euro, cent);
	}

	public static Eurocent toEuro(int i)
	{
		return Eurocent.get(i);
	}

}
