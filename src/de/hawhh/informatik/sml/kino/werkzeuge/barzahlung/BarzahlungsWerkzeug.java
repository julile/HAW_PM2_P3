package de.hawhh.informatik.sml.kino.werkzeuge.barzahlung;

public class BarzahlungsWerkzeug
{
	private BarzahlungsWerkzeugUI _ui;
	private int _preis;
	
	public BarzahlungsWerkzeug(int preis) {
		_preis = preis;
		_ui = new BarzahlungsWerkzeugUI(); //erzeugt die UI
		
		_ui.set_preisFeld(_preis);
	}
}
