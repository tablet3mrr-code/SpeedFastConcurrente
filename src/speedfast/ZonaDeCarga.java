package speedfast;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCarga {

    private final List<Pedido> pedidos = new ArrayList<>();

    public synchronized void agregarPedido(Pedido p) {
        pedidos.add(p);

        System.out.println(
                "Pedido " + p.getId() +
                        " agregado a la zona de carga."
        );
    }

    public synchronized Pedido retirarPedido() {

        for (int i = 0; i < pedidos.size(); i++) {

            Pedido pedido = pedidos.get(i);

            if (pedido.getEstado() == EstadoPedido.PENDIENTE) {

                pedido.setEstado(EstadoPedido.EN_REPARTO);

                pedidos.remove(i);

                return pedido;
            }
        }

        return null;
    }

    public synchronized boolean hayPedidos() {
        return !pedidos.isEmpty();
    }
}