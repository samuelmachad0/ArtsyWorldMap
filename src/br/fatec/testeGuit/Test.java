package br.fatec.testeGuit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;


public class Test {

	public static void main(String[] args) throws JSONException {
		
		Connection con = new Connection();

	
		HashMap<String, ArrayList<String>> result = con.getData();
		
		
		System.out.println(result.get(0).getNext());
		System.out.println(result.get(0).getName());
		
	}
	
}
