package alimentacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import alimentacion.MiPedido;
import alimentacion.Producto;

//EJERCICIO-3
public class MiPedidoTest {
	private static MiPedido miPedido;
	
	@BeforeClass
	public static void inicializarClase() {
		miPedido = new MiPedido();
	}
	
	@After
	public  void disposear() {
		miPedido.removeAll();
	}
	
	@Test
	public void testAnyadirPedido() {
		Producto producto1 = new Producto("Pan", "Masa madre", 1.20);
		Producto producto2 = new Producto("Agua", "De manantial", 1);
		miPedido.anyadirPedido(producto1, 10);
		miPedido.anyadirPedido(producto2, 5);
		assertEquals(miPedido.productosDistintos(), 2);
	}
	
	@Test
	public void testEliminarPedido(){
		Producto producto1 = new Producto("Pan", "Masa madre", 1.20);
		miPedido.anyadirPedido(producto1, 1);//El metodo addItem sirve para meter items en el myOrder
		assertEquals(miPedido.productosDistintos(), 1);
		
		miPedido.eliminarPedido(producto1, 1);
		assertEquals(miPedido.productosDistintos(), 0);
	}
	
	@Test
	public void testPrecioTotal() {
		Producto producto1 = new Producto("Pan", "Masa madre", 1.20);
		Producto producto2 = new Producto("Agua", "De manantial", 1);
		Producto producto3 = new Producto("Helado", "De chocolate", 2.80);
		double sumaPrecios = (producto1.getPrecio() + producto2.getPrecio() + producto3.getPrecio()) ;
		assertEquals(sumaPrecios, miPedido.precioTotal(), 5);//4 es la suma
		
	}
	@Test
	public void testProductosDistintos() {
		Producto producto1 = new Producto("Pan", "Masa madre", 1.20);
		Producto producto2 = new Producto("Agua", "De manantial", 1);
		Producto producto3 = new Producto("Helado", "De chocolate", 2.80);
		miPedido.anyadirPedido(producto1, 2);
		miPedido.anyadirPedido(producto2, 1);
		miPedido.anyadirPedido(producto3, 4);
		assertEquals(miPedido.productosDistintos(), 3);
	}
	@Test
	public void testListaProductos() {
		Producto producto1 = new Producto("Pan", "Masa madre", 1.20);
		Producto producto2 = new Producto("Agua", "De manantial", 1);
		Producto producto3 = new Producto("Helado", "De chocolate", 2.80);
		Producto producto4 = new Producto("Carne", "Eusko Label", 25.50);
		Producto producto5 = new Producto("Merluza", "Muy buena", 13.50);

		miPedido.anyadirPedido(producto1, 1);
		miPedido.anyadirPedido(producto2, 3);
		miPedido.anyadirPedido(producto3, 2);
		miPedido.anyadirPedido(producto4, 1);
		miPedido.anyadirPedido(producto5, 3);
		
		List<Entry<Producto, Integer>> listaOrdenada = miPedido.listaProductos();
		Integer cantidadAuxiliar = null;
		for(Entry<Producto, Integer> entry: listaOrdenada) {
			System.out.println("Producto" + entry.getKey().getNombre() + entry.getKey().getDescripcion());
			if(cantidadAuxiliar != null) {
				assertTrue("Los elementos están ordenados en orden ascendente", cantidadAuxiliar >= entry.getValue());
			}
		}
		
	}

}
