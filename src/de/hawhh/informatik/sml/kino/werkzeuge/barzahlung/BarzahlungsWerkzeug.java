package de.hawhh.informatik.sml.kino.werkzeuge.barzahlung;

import java.util.Set;

import de.hawhh.informatik.sml.kino.fachwerte.Platz;
import de.hawhh.informatik.sml.kino.materialien.Vorstellung;;

public class BarzahlungsWerkzeug
{
	private BarzahlungsWerkzeugUI _ui;
	private int _preis;
	private Set<Platz> _plaetze;
	
	public BarzahlungsWerkzeug(Set<Platz> plaetze, Vorstellung vorstellung) {
		_plaetze = plaetze;
		_preis = vorstellung.getPreisFuerPlaetze(plaetze);
		_ui = new BarzahlungsWerkzeugUI(); //erzeugt die UI
		
		_ui.set_preisFeld(_preis);
		
		_ui.zeigeFenster();
	}
	
	
	
	//listener
//  vorstellung.verkaufePlaetze(plaetze);
//  aktualisierePlatzplan();
}
