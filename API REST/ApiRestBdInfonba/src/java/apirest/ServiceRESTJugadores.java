package apirest;

import bdinfonba.Jugadores;
import bdinfonba.JugadoresJpaController;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.List;

@Path("jugadores")
public class ServiceRESTJugadores {

    private static final String PERSISTENCE_UNIT = "ApiRestBdInfonbaPU";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;

        List<Jugadores> lista;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

            JugadoresJpaController dao = new JugadoresJpaController(emf);
            lista = dao.findJugadoresEntities();
            if (lista == null) {
                statusResul = Response.Status.NO_CONTENT;
                response = Response.status(statusResul).build();
            } else {
                statusResul = Response.Status.OK;
                response = Response.status(statusResul).entity(lista).build();
            }
        } catch (Exception e) {
            statusResul = Response.Status.OK;
            mensaje.put("mensaje", "Error al procesar la petición");
            response = Response.status(statusResul).entity(mensaje).build();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        return response;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("id") String id) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;

        Jugadores jug;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            JugadoresJpaController dao = new JugadoresJpaController(emf);
            jug = dao.findJugadores(Integer.parseInt(id));

            if (jug == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "NO existe jugador con id " + id);
                response = Response.status(statusResul).entity(mensaje).build();
            } else {
                statusResul = Response.Status.OK;
                response = Response.status(statusResul).entity(jug).build();
            }
        } catch (Exception e) {
            statusResul = Response.Status.OK;
            mensaje.put("mensaje", "Error al procesar la petición");
            response = Response.status(statusResul).entity(mensaje).build();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        return response;
    }
}
