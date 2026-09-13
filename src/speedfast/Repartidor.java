package speedfast;

public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        while (true) {

            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            System.out.println(
                    nombre +
                            " retiró el pedido " +
                            pedido.getId() +
                            " - Estado: " +
                            pedido.getEstado()
            );

            try {

                Thread.sleep(2000);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                System.out.println(
                        nombre + " fue interrumpido."
                );

                break;
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);

            System.out.println(
                    nombre +
                            " entregó el pedido " +
                            pedido.getId() +
                            " en " +
                            pedido.getDireccionEntrega() +
                            " - Estado: " +
                            pedido.getEstado()
            );
        }
    }
}