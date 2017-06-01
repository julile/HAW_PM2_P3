package de.hawhh.informatik.sml.kino.werkzeuge.barzahlung;

import java.awt.GridLayout;
import java.awt.Container;

import javax.swing.*;


public class BarzahlungsWerkzeugUI
{
	private JDialog _frame;
    private JTextField _bezahlFeld;
    private JTextField _preisFeld;
    private JTextField _rueckgeldFeld;
    private JButton _okButton;
    private JButton _abbrechenButton;
    
    public BarzahlungsWerkzeugUI() {
    	_frame = new JDialog();
    	
    	_okButton = new JButton("OK");
    	_abbrechenButton = new JButton("Abbrechen");
    	
        _preisFeld = new JTextField();
        _preisFeld.setEditable(false);
    	_bezahlFeld = new JTextField();
    	_bezahlFeld.setEditable(true);
        _rueckgeldFeld = new JTextField();
        _rueckgeldFeld.setEditable(false);

        
    	Container contentPane = _frame.getContentPane();
    	GridLayout layout = new GridLayout();
    	layout.setColumns(2);
    	layout.setRows(4);
    	layout.setHgap(20);
    	layout.setVgap(20);

    	contentPane.setLayout (layout);
    	    	
    	contentPane.add(new JLabel ("Gesamtpreis: "));
       	contentPane.add(_preisFeld);
    	contentPane.add(new JLabel ("Bezahlt: "));
    	contentPane.add(_bezahlFeld);
    	contentPane.add(new JLabel ("Rueckgeld: "));
    	contentPane.add(_rueckgeldFeld);
    	contentPane.add(_okButton);
    	contentPane.add(_abbrechenButton);
 
    	_frame.setTitle("Barzahlung");
    }
    
    public void zeigeFenster(){
    	_frame.setLocation(700, 500);
    	_frame.setModal(true);
    	_frame.setSize(250,200);
    	_frame.setResizable(false);
    	_frame.setVisible(true);
    }
    
	/**
	 * @return the _bezahlFeld
	 */
	public JTextField get_bezahlFeld()
	{
		return _bezahlFeld;
	}
	/**
	 * @param _bezahlFeld the _bezahlFeld to set
	 */
	public void set_bezahlFeld(JTextField _bezahlFeld)
	{
		this._bezahlFeld = _bezahlFeld;
	}
	/**
	 * @return the _preisFeld
	 */
	public JTextField get_preisFeld()
	{
		return _preisFeld;
	}
	
	public void set_preisFeld(int preis){
		_preisFeld.setText(Integer.toString(preis));
	}
	/**
	 * @return the _rueckgeldFeld
	 */
	public JTextField get_rueckgeldFeld()
	{
		return _rueckgeldFeld;
	}
	/**
	 * @return the _okButton
	 */
	public JButton get_okButton()
	{
		return _okButton;
	}
	/**
	 * @return the _abbrechenButton
	 */
	public JButton get_abbrechenButton()
	{
		return _abbrechenButton;
	}
    
    
}
