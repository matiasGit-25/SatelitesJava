package mensaje;

import red.Edge;
import red.Operador;

import java.util.List;

public class PingRequest extends Mensaje {

    public PingRequest(String id, Operador origen, Operador destino) {
        super(id, origen, destino);
    }

    @Override
    public void enviar() {
        Operador origen = this.getOrigen();
        List<Edge> edges = origen.getEdges();
        for (Edge arista : edges) {
            if (arista.getEstado() && !this.getRecorrido().contains(arista.getDestino())) {
                arista.getDestino().recibirMensaje(this);
            }
        }
    }

    @Override
    public void reenviarMensaje() {
        Operador origen = this.getOrigen();
        List<Edge> edges = origen.getEdges();
        for (Edge arista : edges) {
            if (arista.getEstado() && !this.getRecorrido().contains(arista.getDestino())) {
                arista.getDestino().recibirMensaje(this);
            }
        }
    }
}
