package uscotxe;

import javax.swing.JOptionPane;

import Herencia.Cotxe;
import Herencia.Furgoneta;

	public class UsCotxe {
	    public static void main(String[] Args){
	       Cotxe elmeucotxe = new Cotxe();
	       elmeucotxe.setColor(JOptionPane.showInputDialog("Indica un color"));
	       System.out.println(elmeucotxe.getColor());
	       elmeucotxe.setSeients(JOptionPane.showInputDialog("Els seients són esportius? si o no"));
	       
	       //Cridarem els metodes de la classe filla o sigui Furgoneta
	       Furgoneta lamevafurgo = new Furgoneta(8,640);
	       
	       lamevafurgo.setColor("Groc");
	       System.out.println(lamevafurgo.getInfoFurgo());
	       System.out.println(lamevafurgo.getInfoCotxe());
	    }
	}
