package apirest;

import bdinfonba.Equipos;
import bdinfonba.EquiposJpaController;
import bdinfonba.Estadios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
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
import org.eclipse.yasson.internal.JsonBindingBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("equipos")
public class ServiceRESTEquipos {

    private static final String PERSISTENCE_UNIT = "ApiRestBdInfonbaPU";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;

        List<Equipos> lista;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

            EquiposJpaController dao = new EquiposJpaController(emf);
            lista = dao.findEquiposEntities();
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
        Equipos equipo;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            EquiposJpaController dao = new EquiposJpaController(emf);
            equipo = dao.findEquipos(id);

            if (equipo == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe departamento con ID " + id);
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                statusResul = Response.Status.OK;
                response = Response
                        .status(statusResul)
                        .entity(equipo)
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

    @GET
    @Path("/clasificacion/este")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEste() {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;

        String resultado = "{}";
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            EquiposJpaController dao = new EquiposJpaController(emf);
            EntityManager em = dao.getEntityManager();
            Query query
                    = em.createQuery("SELECT e FROM Equipos e WHERE e.conferencia = 'Este' ORDER BY e.victorias DESC");
            List<Equipos> lista = query.getResultList();

            if ((lista != null) && (!lista.isEmpty())) {
                JSONArray jsonArray = new JSONArray();
                for (Equipos equipo : lista) {
                    JSONObject json = new JSONObject();
                    json.put("campeonatos", equipo.getCampeonatos());
                    json.put("ciudad", equipo.getCiudad());
                    json.put("colorPrincipal", equipo.getColorPrincipal());
                    json.put("conferencia", equipo.getConferencia());
                    json.put("derrotas", equipo.getDerrotas());
                    json.put("entrenador", equipo.getEntrenador());
                    json.put("fundacion", equipo.getFundacion());
                    json.put("id", equipo.getId());

                    Estadios estadio = equipo.getIdEstadio();
                    JSONObject jsonEstadio = new JSONObject();
                    jsonEstadio.put("capacidad", estadio.getCapacidad());
                    jsonEstadio.put("ciudad", estadio.getCiudad());
                    jsonEstadio.put("id", estadio.getId());
                    jsonEstadio.put("imagen", estadio.getImagen());
                    jsonEstadio.put("nombre", estadio.getNombre());
                    json.put("idEstadio", jsonEstadio);

                    json.put("logo", equipo.getLogo());
                    json.put("nombre", equipo.getNombre());
                    json.put("victorias", equipo.getVictorias());

                    jsonArray.put(json);
                }
                resultado = jsonArray.toString();
                statusResul = Response.Status.OK;
                response = Response
                        .status(statusResul)
                        .entity(resultado)
                        .build();
            } else {
                statusResul = Response.Status.NO_CONTENT;
                response = Response
                        .status(statusResul)
                        .build();
            }
        } catch (Exception e) {
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

    @GET
    @Path("/clasificacion/oeste")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOeste() {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;

        String resultado = "{}";
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            EquiposJpaController dao = new EquiposJpaController(emf);
            EntityManager em = dao.getEntityManager();
            Query query
                    = em.createQuery("SELECT e FROM Equipos e WHERE e.conferencia = 'Oeste' ORDER BY e.victorias DESC");
            List<Equipos> lista = query.getResultList();

            if ((lista != null) && (!lista.isEmpty())) {
                JSONArray jsonArray = new JSONArray();
                for (Equipos equipo : lista) {
                    JSONObject json = new JSONObject();
                    json.put("campeonatos", equipo.getCampeonatos());
                    json.put("ciudad", equipo.getCiudad());
                    json.put("colorPrincipal", equipo.getColorPrincipal());
                    json.put("conferencia", equipo.getConferencia());
                    json.put("derrotas", equipo.getDerrotas());
                    json.put("entrenador", equipo.getEntrenador());
                    json.put("fundacion", equipo.getFundacion());
                    json.put("id", equipo.getId());

                    Estadios estadio = equipo.getIdEstadio();
                    JSONObject jsonEstadio = new JSONObject();
                    jsonEstadio.put("capacidad", estadio.getCapacidad());
                    jsonEstadio.put("ciudad", estadio.getCiudad());
                    jsonEstadio.put("id", estadio.getId());
                    jsonEstadio.put("imagen", estadio.getImagen());
                    jsonEstadio.put("nombre", estadio.getNombre());
                    json.put("idEstadio", jsonEstadio);

                    json.put("logo", equipo.getLogo());
                    json.put("nombre", equipo.getNombre());
                    json.put("victorias", equipo.getVictorias());

                    jsonArray.put(json);
                }
                resultado = jsonArray.toString();
                statusResul = Response.Status.OK;
                response = Response
                        .status(statusResul)
                        .entity(resultado)
                        .build();
            } else {
                statusResul = Response.Status.NO_CONTENT;
                response = Response
                        .status(statusResul)
                        .build();
            }
        } catch (Exception e) {
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

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Equipos equipo) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

            EquiposJpaController dao = new EquiposJpaController(emf);
            Equipos equipoFound = dao.findEquipos(equipo.getId());
            if (equipoFound == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe equipo con ID " + equipo.getId());
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                equipoFound.setId(equipo.getId());
                equipoFound.setNombre(equipo.getNombre());
                equipoFound.setCampeonatos(equipo.getCampeonatos());
                equipoFound.setEntrenador(equipo.getEntrenador());
                equipoFound.setFundacion(equipo.getFundacion());
                equipoFound.setCiudad(equipo.getCiudad());
                equipoFound.setColorPrincipal(equipo.getColorPrincipal());
                equipoFound.setConferencia(equipo.getConferencia());
                equipoFound.setVictorias(equipo.getVictorias());
                equipoFound.setDerrotas(equipo.getDerrotas());
                equipoFound.setIdEstadio(equipo.getIdEstadio());

                dao.edit(equipoFound);
                statusResul = Response.Status.OK;
                mensaje.put("mensaje", "Equipo con ID " + equipo.getId() + " actualizado");
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
    public Response post(Equipos equipo) {
        EntityManagerFactory emf = null;
        HashMap<String, String> mensaje = new HashMap<>();
        Response response;
        Status statusResul;
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            EquiposJpaController dao = new EquiposJpaController(emf);
            Equipos equipoFound = null;
            if ((equipo.getId() != 0) && (equipo.getId() != null)) {
                equipoFound = dao.findEquipos(equipo.getId());
            }
            if (equipoFound != null) {
                statusResul = Response.Status.FOUND;
                mensaje.put("mensaje", "Ya existe equipo con ID " + equipo.getId());
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                dao.create(equipo);
                statusResul = Response.Status.CREATED;
                mensaje.put("mensaje", "Equipo " + equipo.getNombre() + " grabado");
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

            EquiposJpaController dao = new EquiposJpaController(emf);
            Equipos equipoFound = dao.findEquipos(id);
            if (equipoFound == null) {
                statusResul = Response.Status.NOT_FOUND;
                mensaje.put("mensaje", "No existe equipo con ID " + id);
                response = Response
                        .status(statusResul)
                        .entity(mensaje)
                        .build();
            } else {
                dao.destroy(id);
                statusResul = Response.Status.OK;
                mensaje.put("mensaje", "Equipo con ID " + id + " eliminado");
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
