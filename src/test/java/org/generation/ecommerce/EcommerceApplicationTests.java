package org.generation.ecommerce;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.generation.ecommerce.model.Producto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class EcommerceApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	//TODO actualizar el Token con uno válido.
	private String token ="Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJvQGdtYWlsLmNvbSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNjg0Mjc1MzU5LCJleHAiOjE2ODQzMTEzNTl9.on1G0AjvnGurBQXO7QX5YigIN26wAm_9M4Gvuuwf8-U";

	@Test
	@DisplayName("Prueba para obtener (GET) la lista de productos")
	void pruebaGET() throws Exception {
		
		this.mockMvc.perform(get("/api/productos/1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(
				content().string(
						containsString("norma1.gif")
						)
				);
	}//pruebaGET
	
	@Test
	@Disabled("Probado una vez queda desabilitado")
	@DisplayName("Prueba para obtener con id 7, esta prueba solo se puede ejecutar una vez")
	void pruebaDELETE() throws Exception {
		
		this.mockMvc.perform(delete("/api/productos/5"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(
				content().string(
						containsString("plumas3.gif")
						)
				);
	}//pruebaDELETE
	
	
	@Test
	@Disabled("Probado una vez queda desabilitado")
	@DisplayName("Prueba para crear un nuevo producto")
	void pruebaPOST() throws Exception {
		Producto p = new Producto();
		p.setNombre("Cuaderno profesional cuadro chico 200 hojas");
		p.setDescricion("Cuaderno pasta dura con espiral");
		p.setImagen("cuaderno_20.jpg");
		p.setPrecio(90);
		
		this.mockMvc.perform(post("/api/productos/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(
				content().string(
						containsString("cuaderno_20.jpg")
						)
				);
	}//pruebaPost
	
	private static String asJsonString(final Object obj) {
	    try {
		      return new ObjectMapper().writeValueAsString(obj);
		    } catch (Exception e) {
		      throw new RuntimeException(e);
		    }//catch
		 } // asJsonString
	
	@Test
	@DisplayName("Se modifica el producto 5 con el nuevo precio")
	void pruebaPUT () throws Exception{
		
		this.mockMvc.perform(put("/api/productos/1")
				.queryParam("precio", "38.3")
				.header("Authorization", token)
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(
				content().string(
						containsString("38.3")
						)
				);
	}
	
}//class EcommerceApplicationTests 
