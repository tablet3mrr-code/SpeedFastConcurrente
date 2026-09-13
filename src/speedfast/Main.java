package speedfast;

public class Main {

    public static void main(String[] args) {

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        zonaDeCarga.agregarPedido(
                new Pedido(
                        1,
                        "Av. Libertad 100",
                        EstadoPedido.PENDIENTE
                )
        );

        zonaDeCarga.agregarPedido(
                new Pedido(
                        2,
                        "Av. San Martin 250",
                        EstadoPedido.PENDIENTE
                )
        );

        zonaDeCarga.agregarPedido(
                new Pedido(
                        3,
                        "1 Norte 500",
                        EstadoPedido.PENDIENTE
                )
        );

        zonaDeCarga.agregarPedido(
                new Pedido(
                        4,
                        "5 Norte 340",
                        EstadoPedido.PENDIENTE
                )
        );

        zonaDeCarga.agregarPedido(
                new Pedido(
                        5,
                        "8 Norte 720",
                        EstadoPedido.PENDIENTE
                )
        );

        Repartidor repartidor1 =
                new Repartidor("Juan", zonaDeCarga);

        Repartidor repartidor2 =
                new Repartidor("Pedro", zonaDeCarga);

        Repartidor repartidor3 =
                new Repartidor("Maria", zonaDeCarga);

        Thread hilo1 = new Thread(repartidor1);
        Thread hilo2 = new Thread(repartidor2);
        Thread hilo3 = new Thread(repartidor3);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {

            hilo1.join();
            hilo2.join();
            hilo3.join();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    "El hilo principal fue interrumpido."
            );
        }

        System.out.println(
                "Todos los pedidos han sido entregados correctamente"
        );
    }
}