package Herencia;


	public class Cotxe {
	    //Atributs definits
	    private int rodes;
	    private int llarg;
	    private int ample;
	    private int cilindrada;
	    private int pes;
	    private String color;
	    private boolean seients_sportius,aire_acondicionat;
	    
	    //Metode constructor
	    public Cotxe(){
	        rodes = 4;
	        llarg = 2000;
	        ample = 300;
	        cilindrada = 1600;
	        pes = 500;
	    }
	    
	    //Getter
	    public String getInfoCotxe(){
	        return "La plataforma del vehicle te " + rodes + " rodes." +
	                " Medeix " + llarg/1000 + " metres amb un ample de " + ample +
	                " cm i un pes de " + pes + " kg. Amb un color " + color;
	    }
	    
	    //Setter
	    public void setColor(String color_cotxe){
	        color = color_cotxe;
	    }
	    
	    //Getter
	    public String getColor(){
	        return "El color del cotxe es " + color;
	    }
	    
	    //Setter
	    public void setSeients(String seientsEsportius){
	        String seients_sportiusPrev = seientsEsportius;
	        if(seients_sportiusPrev=="si"){
	            seients_sportius = true;
	        }else{
	            seients_sportius = false;
	        }
	    }
	}


