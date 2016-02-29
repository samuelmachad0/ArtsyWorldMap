package br.fatec.testeGuit;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Model {
	
	private String link;
	
	
	 public ArrayList<Artist> generateJSON(JSONObject json){
	    	
	    	ArrayList<Artist> artists = new ArrayList<Artist>();
	    	
	        
	        try {
	        	JSONObject obj = json.getJSONObject("_links");
	        	link = obj.getJSONObject("next").getString("href");
	        	
	        	for(int i = 0; i<5;i++){
	        		JSONObject objeto = json.getJSONObject("_embedded");
	        		Artist artist = new Artist(objeto.getJSONArray("artists").getJSONObject(i).getString("name"),objeto.getJSONArray("artists").getJSONObject(i).getString("location"));
	            	artists.add(artist);         
	        	}
	        	
	        } catch (JSONException e) {
	            // handle exception
	        }
	        
	        
	        return artists;

	    }
	 
	 
	 
	 public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public void Results(String URL) throws JSONException, MalformedURLException{
		Connection c = new Connection();
		c.setURL(URL);
		 
		ArrayList <Artist> artistas = generateJSON(new JSONObject(c.getData()));
	
		for(Artist a: artistas ){
			System.out.println("Nome: "+a.getNome());
			System.out.println("Localização: "+a.getLocation());
			
		}
		
		 
		 
	 }
	 
	 
	 
	
}
