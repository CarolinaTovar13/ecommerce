package org.generation.ecommerce.service;


import java.util.List;

import org.generation.ecommerce.model.Producto;
import org.generation.ecommerce.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	
	private final ProductoRepository productoRepository;	
	//public final ArrayList<Producto> lista = new ArrayList<>();
	
	@Autowired
	public ProductoService (ProductoRepository productoRepository) {
		this.productoRepository=productoRepository;
	}//constructor
	
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	}//getAllProductos
	
//	public ProductoService(){
//		lista.add(new Producto("Cuaderno Profesional Norma 58813 / Raya / 100 hojas",
//				" Cuaderno profesional / Cubiertas estándar / Espiral doble ",
//					"norma1.gif", 57.0));
//		lista.add(new Producto("CUADERNO PROFESIONAL NORMA FERRARI (RAYA, 120 H.)",
//				"Doble espiral reforzado / Pastas semirrígidas","norma2.jpg", 219));
//		lista.add(new Producto("Plumas Bic Cristal Intenso Fashion",
//				"Plumas Bic Cristal Intenso Fashion / Punto extra grueso / Tinta colores surtidos",
//				"bic1.jpg", 46));
//		lista.add(new Producto("Plumas Bic Cristal Intenso",
//				" Plumas Bic Cristal Intenso / Punto extra grueso / Tinta negra roja azul / 3 piezas",
//				"bic2.jpg", 27));
//	}//constructor
	
//	public ArrayList<Producto> getAllProductos(){
//		return lista;
	
//	}//getAllProductos

	public Producto getProducto(Long id) {
		return productoRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El producto con id " + id + " no existe")
				);
		
	}//getProducto
//		Producto tmpProd = null;
//		for(Producto producto:lista) {
//			if (producto.getId()==id) {
//				return producto;
//			}//if
//		}//foreach
//		return tmpProd;
//	}//getProducto
	
	
	public Producto deleteProducto(Long id) {
		Producto tmpProd = null;
		if(productoRepository.existsById(id)) {
			tmpProd= productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}//if
		
//		for(Producto producto:lista) {
//			if (producto.getId()==id) {
//				tmpProd = lista.remove(lista.indexOf(producto));
//				break;
//			}//if
//		}//foreach
		
		return tmpProd;
	}//deleteProducto
	
	public Producto addProducto(Producto producto) {
		Producto tmpProd=null;
		if(productoRepository.findByNombre(producto.getNombre()).isEmpty()) {
			tmpProd=productoRepository.save(producto);
	}else {
		System.out.println("Ya existe un producto con el nombre [" + producto.getNombre()+ "]");
	}//if
		return tmpProd;
	}//addProducto
	
//	public Producto addProducto (Producto producto) {
//		lista.add(producto);
//		return producto;
//	}//addProducto
//	
	
	public Producto updateProducto(Long id, String nombre, String descripcion, String imagen, Double precio) {
		Producto tmpProd=null;		
		if(productoRepository.existsById(id)) {
				tmpProd = productoRepository.findById(id).get();
				if (nombre!=null) tmpProd.setNombre(nombre);
				if (descripcion!=null) tmpProd.setDescricion(descripcion);
				if (imagen!=null) tmpProd.setImagen(imagen);
				if (precio!=null) tmpProd.setPrecio(precio.doubleValue());
				productoRepository.save(tmpProd);
		}else {
			System.out.println("Update -El producto con id " + id + " no existe");
		}//else
		return tmpProd;
	}//updateProducto

}//class ProductoService
