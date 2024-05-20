package apirest;

import bdinfonba.Estadios;
import bdinfonba.EstadiosJpaController;
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

@Path("estadios")
public class ServiceRESTEstadios {

    private static final String PERSISTENCE_UNIT = "ApiRestBdInfonbaPU";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;

        List<Estadios> lista;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

            EstadiosJpaController dao = new EstadiosJpaController(emf);
            lista = dao.findEstadiosEntities();
            if (lista == null) {
                statusResul = Response.Status.NO_CONTENT;
                response = Response.status(statusResul).build();
            } else {
                statusResul = Response.Status.OK;
                response = Response.status(statusResul).entity(lista).build();
            }
        } catch (Exception e) {
            statusResul = Response.Status.BAD_REQUEST;
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

        Estadios estadio;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            EstadiosJpaController dao = new EstadiosJpaController(emf);
            estadio = dao.findEstadios(id);

            if (estadio == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe estadio con ID " + id);
                response = Response.status(statusResul).entity(mensaje).build();
            } else {
                statusResul = Response.Status.OK;
                response = Response.status(statusResul).entity(estadio).build();
            }
        } catch (Exception e) {
            statusResul = Response.Status.BAD_REQUEST;
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
    public Response put(Estadios estadio) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

            EstadiosJpaController dao = new EstadiosJpaController(emf);
            Estadios estadioFound = dao.findEstadios(estadio.getId());
            if (estadioFound == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe esetadio con ID " + estadio.getId());
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                estadioFound.setId(estadio.getId());
                estadioFound.setNombre(estadio.getNombre());
                estadioFound.setCapacidad(estadio.getCapacidad());
                estadioFound.setCiudad(estadio.getCiudad());
                estadioFound.setImagen(estadio.getImagen());

                dao.edit(estadioFound);
                statusResul = Response.Status.OK;
                mensaje.put("mensaje", "Estadio con ID " + estadio.getId() + " actualizado");
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
    public Response post(Estadios estadio) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            EstadiosJpaController dao = new EstadiosJpaController(emf);
            Estadios estadioFound = null;
            if ((estadio.getId() != 0) && (estadio.getId() != null)) {
                estadioFound = dao.findEstadios(estadio.getId());
            }
            if (estadioFound != null) {
                statusResul = Response.Status.FOUND;
                mensaje.put("mensaje", "Ya existe estadio con ID " + estadio.getId());
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                dao.create(estadio);
                statusResul = Response.Status.CREATED;
                mensaje.put("mensaje", "Estadio " + estadio.getNombre() + " grabado");
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

            EstadiosJpaController dao = new EstadiosJpaController(emf);
            Estadios estadioFound = dao.findEstadios(id);
            if (estadioFound == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe estadio con ID " + id);
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                dao.destroy(id);
                statusResul = Response.Status.OK;
                mensaje.put("mensaje", "Estadio con ID " + id + " eliminado");
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
