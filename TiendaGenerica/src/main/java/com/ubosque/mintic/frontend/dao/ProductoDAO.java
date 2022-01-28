package com.ubosque.mintic.frontend.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.csvreader.CsvReader;
import com.google.gson.Gson;
import com.ubosque.mintic.frontend.dto.ProductoDTO;
import com.ubosque.mintic.frontend.dto.UsuarioDTO;
import com.ubosque.mintic.frontend.servlet.*;


public class ProductoDAO {
	
	
	 private static final char DEFAULT_CSV_SEPARATOR = ',';
	
	
	 public static List<List<String>> parseCsv(InputStream csvInput) { 
	    return parseCsv(csvInput, DEFAULT_CSV_SEPARATOR);
	  }
	
	 public static List<List<String>> parseCsv(InputStream csvInput, char csvSeparator) {

	        // Prepare.
	        BufferedReader csvReader = null;
	        List<List<String>> csvList = new ArrayList<List<String>>();
	        String csvRecord = null;

	        // Process records.
	        try {
	            csvReader = new BufferedReader(new InputStreamReader(csvInput, "UTF-8"));
	            while ((csvRecord = csvReader.readLine()) != null) {
	                csvList.add(parseCsvRecord(csvRecord, csvSeparator));
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("Reading CSV failed.", e);
	        } finally {
	            if (csvReader != null)
	                try {
	                    csvReader.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	        }

	        return csvList;
	    }
	 
	 private static List<String> parseCsvRecord(String record, char csvSeparator) {

	        // Prepare.
	        boolean quoted = false;
	        StringBuilder fieldBuilder = new StringBuilder();
	        List<String> fields = new ArrayList<String>();

	        // Process fields.
	        for (int i = 0; i < record.length(); i++) {
	            char c = record.charAt(i);
	            fieldBuilder.append(c);

	            if (c == '"') {
	                quoted = !quoted; // Detect nested quotes.
	            }

	            if ((!quoted && c == csvSeparator) // The separator ..
	                    || i + 1 == record.length()) // .. or, the end of record.
	            {
	                String field = fieldBuilder.toString() // Obtain the field, ..
	                        .replaceAll(csvSeparator + "$", "") // .. trim ending separator, ..
	                        .replaceAll("^\"|\"$", "") // .. trim surrounding quotes, ..
	                        .replace("\"\"", "\""); // .. and un-escape quotes.
	                fields.add(field.trim()); // Add field to List.
	                fieldBuilder = new StringBuilder(); // Reset.
	            }
	        }

	        return fields;
	    }
	
		///////CREACION DE PRODUCTOS //////////
		public boolean crearProductos(ArrayList<ProductoDTO> prod) {
			Gson gson = new Gson();
			String usuarioJSON = gson.toJson(prod);
			System.out.println(usuarioJSON);
			System.out.println("Esto envio al back");
			Client cliente = ClientBuilder.newClient();
			WebTarget servicioREST = cliente.target("http://localhost:5000/productos/cargar");
			Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
			if(respuesta.getStatus()==200) {
				System.out.println("creado");
				return true;
			}
			return false;
		}
		
		public String consultarCodigo(ProductoDTO dto) {
			Gson gson = new Gson();
			String usuarioJSON = gson.toJson(dto);
			
			Client cliente = ClientBuilder.newClient();
			WebTarget servicioREST = cliente.target("http://localhost:5000/productos/consulta");
			String respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE),String.class);
			//Response respuesta = servicioREST.request().post(Entity.entity(usuarioJSON, MediaType.APPLICATION_JSON_TYPE));
			return respuesta;
				
		}

}
