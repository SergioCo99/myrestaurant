package alimentacion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



public class MiPedido implements Pedido {
	
	public static void main(String[] args) {
		MiPedido pedido = new MiPedido();
		Producto producto = new Producto("pan", "masa madre", 5.0);
		pedido.anyadirPedido(producto, 5);
		pedido.eliminarPedido(producto, 4);
		System.out.println(pedido);
	}
	
	private HashMap<Producto, Integer> mapI;
	
	public MiPedido() {
		mapI = new HashMap<>();
	}
	
	@Override
	public String toString() {
		//String con toda la información de los productos en del mapa
		String producto = "";
		for(Entry<Producto, Integer> productos : mapI.entrySet()) {
			producto = "nombre " + productos.getKey().getNombre() + ", descripcion: " + productos.getKey().getDescripcion() + ", precio: " + productos.getKey().getPrecio() + "; Unidades: " + productos.getValue();
		}
		return producto;
	}

	@Override
	public void anyadirPedido(Producto producto, int cantidad) {
		//Método para añadir pedidos
		if(!this.mapI.containsKey(producto)) {//si el mapa no contiene productos
			this.mapI.put(producto, cantidad);//se le añade al mapa un producto y cuantos va a haber
		}else {//si el mapa si contiene items
			Integer cantidadExistente = this.mapI.get(producto);//sacamos la cantidad de productos de ese tipo que va a haber
			this.mapI.put(producto, cantidadExistente + cantidad); //actualizamos la cantidad de los productos que va haber
		}
		
	}
	
	public void removeAll() {
		mapI.clear();
	}
	@Override
	public void eliminarPedido(Producto producto, int cantidad) {
		//Método para eliminar pedidos
		if(this.mapI.containsKey(producto)) {
			Integer cantidadExistente = this.mapI.get(producto);
			int cantidadRestante = cantidadExistente - cantidad;
			if(cantidadRestante > 0) {
				this.mapI.put(producto, cantidadRestante);
			}else {
				this.mapI.remove(producto);
			}
		}
		
	}

	@Override
	public float precioTotal() {
		float resultado = 0;
		for(Entry<Producto, Integer> e : mapI.entrySet()) {
			resultado += (e.getKey().getPrecio() * e.getValue());
		}
		return resultado;
	}

	@Override
	public int productosDistintos() {
		//Método para distinguir los productos
		return mapI.size();
	}

	@Override
	public List<Entry<Producto, Integer>> listaProductos() {
		//Método que compara una lista de productos
		List<Entry<Producto, Integer>> result = new ArrayList<Map.Entry<Producto,Integer>>(mapI.entrySet());//como estamos haciendo un arrayde entry, podemos sacar la lista de entry en nuestro mapa principal
		Comparator<Entry<Producto, Integer>> comparador = new Comparator<Entry<Producto,Integer>>() {
			
			@Override
			public int compare(Entry<Producto, Integer> o1, Entry<Producto, Integer> o2) {//compara los numeros para decir cual es mayor.
				if(o1.getValue() == o2.getValue()) {
					return o1.getKey().getNombre().compareTo(o2.getKey().getNombre());
				}
				return o2.getValue().compareTo(o1.getValue());
			}
		};
			result.sort(comparador);
			return result;
		}

}
