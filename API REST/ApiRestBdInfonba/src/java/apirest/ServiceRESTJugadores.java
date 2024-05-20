package apirest;

import bdinfonba.Jugadores;
import bdinfonba.JugadoresJpaController;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
    public Response getOne(@PathParam("id") int id) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;

        Jugadores jug;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            JugadoresJpaController dao = new JugadoresJpaController(emf);
            jug = dao.findJugadores(id);

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

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Jugadores jugador) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

            JugadoresJpaController dao = new JugadoresJpaController(emf);
            Jugadores jugadorFound = dao.findJugadores(jugador.getId());
            if (jugadorFound == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe jugador con ID " + jugador.getId());
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                jugadorFound.setId(jugador.getId());
                jugadorFound.setNombre(jugador.getNombre());
                jugadorFound.setApellido(jugador.getApellido());
                jugadorFound.setPosicion(jugador.getPosicion());
                jugadorFound.setAltura(jugador.getAltura());
                jugadorFound.setPeso(jugador.getPeso());
                jugadorFound.setDorsal(jugador.getDorsal());
                jugadorFound.setPartidosJugados(jugador.getPartidosJugados());
                jugadorFound.setPuntos(jugador.getPuntos());
                jugadorFound.setAsistencias(jugador.getAsistencias());
                jugadorFound.setRebotes(jugador.getRebotes());
                jugadorFound.setIdEquipo(jugador.getIdEquipo());
                // Grabar los cambios
                dao.edit(jugadorFound);
                statusResul = Response.Status.OK;
                mensaje.put("mensaje", "Jugador con ID " + jugador.getId() + " actualizado");
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
            mensaje.put("mensaje", "Error al procesar la petición");
            response = Response
                    .status(statusResul)
                    .entity(mensaje)
                    .build();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        return response;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(Jugadores jugador) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            JugadoresJpaController dao = new JugadoresJpaController(emf);
            Jugadores jugadorFound = null;
            if ((jugador.getId() != 0) && (jugador.getId() != null)) {
                jugadorFound = dao.findJugadores(jugador.getId());
            }
            if (jugadorFound != null) {
                statusResul = Response.Status.FOUND;
                mensaje.put("mensaje", "Ya existe jugador con ID " + jugador.getId());
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                dao.create(jugador);
                statusResul = Response.Status.CREATED;
                mensaje.put("mensaje", "Jugador " + jugador.getNombre() + " grabado");
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
            mensaje.put("mensaje", "Error al procesar la petición");
            response = Response
                    .status(statusResul)
                    .entity(mensaje)
                    .build();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        return response;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

            JugadoresJpaController dao = new JugadoresJpaController(emf);
            Jugadores jugadorFound = dao.findJugadores(id);
            if (jugadorFound == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe jugador con ID " + id);
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                dao.destroy(id);
                statusResul = Response.Status.OK;
                mensaje.put("mensaje", "Jugador con ID " + id + " eliminado");
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
            mensaje.put("mensaje", "Error al procesar la petición");
            response = Response
                    .status(statusResul)
                    .entity(mensaje)
                    .build();
        } finally {
            if (emf != null) {
                emf.close();
            }
        }
        return response;
    }
}
