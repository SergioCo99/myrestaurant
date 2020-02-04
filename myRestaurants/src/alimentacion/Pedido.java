package alimentacion;

import java.util.List;
import java.util.Map.Entry;

public interface Pedido {
	public void anyadirPedido(Producto producto, int cantidad);


	public void eliminarPedido(Producto producto, int cantidad);


	public float precioTotal();


	public int productosDistintos();

	
	public List<Entry<Producto, Integer>> listaProductos();

}
