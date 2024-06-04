using InfoNBAAdmin.Clases;
using Newtonsoft.Json;
using RestSharp;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InfoNBAAdmin.Servicios
{
    class ServicioApi
    {
        public Estadios GetEstadio(int id)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest($"/estadios/{id}", Method.Get);
            var response = client.Execute(request);

            return JsonConvert.DeserializeObject<Estadios>(response.Content);
        }

        public ObservableCollection<Estadios> GetEstadios()
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest($"/estadios", Method.Get);
            var response = client.Execute(request);

            return JsonConvert.DeserializeObject<ObservableCollection<Estadios>>(response.Content);
        }

        public Equipos GetEquipo(int id)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest($"/equipos/{id}", Method.Get);
            var response = client.Execute(request);

            return JsonConvert.DeserializeObject<Equipos>(response.Content);
        }

        public ObservableCollection<Equipos> GetEquipos()
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest($"/equipos", Method.Get);
            var response = client.Execute(request);

            return JsonConvert.DeserializeObject<ObservableCollection<Equipos>>(response.Content);
        }

        public Jugadores GetJugadores(int id)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest($"/jugadores/{id}", Method.Get);
            var response = client.Execute(request);

            return JsonConvert.DeserializeObject<Jugadores>(response.Content);
        }

        public ObservableCollection<Jugadores> GetJugadores()
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest($"/jugadores", Method.Get);
            var response = client.Execute(request);

            return JsonConvert.DeserializeObject<ObservableCollection<Jugadores>>(response.Content);
        }

        public ObservableCollection<Partidos> GetPartidos()
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest($"/partidos", Method.Get);
            var response = client.Execute(request);

            return JsonConvert.DeserializeObject<ObservableCollection<Partidos>>(response.Content);
        }

        public ObservableCollection<Equipos> GetEste()
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest("/equipos/clasificacion/este", Method.Get);
            var response = client.Execute(request);

            return JsonConvert.DeserializeObject<ObservableCollection<Equipos>>(response.Content);
        }

        public ObservableCollection<Equipos> GetOeste()
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest("/equipos/clasificacion/oeste", Method.Get);
            var response = client.Execute(request);

            return JsonConvert.DeserializeObject<ObservableCollection<Equipos>>(response.Content);
        }

        public RestResponse PostEquipo(Equipos nuevo)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest("/equipos", Method.Post);
            string data = JsonConvert.SerializeObject(nuevo);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }

        public RestResponse PostEstadio(Estadios nuevo)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest("/estadios", Method.Post);
            string data = JsonConvert.SerializeObject(nuevo);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }

        public RestResponse PostJugador(Jugadores nuevo)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest("/jugadores", Method.Post);
            string data = JsonConvert.SerializeObject(nuevo);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }

        public RestResponse PostPartido(Partidos nuevo)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest("/partidos", Method.Post);
            string data = JsonConvert.SerializeObject(nuevo);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }

        public RestResponse PutJugador(Jugadores actualizar)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest("/jugadores", Method.Put);
            string data = JsonConvert.SerializeObject(actualizar);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }

        public RestResponse PutEquipo(Equipos actualizar)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest("/equipos", Method.Put);
            string data = JsonConvert.SerializeObject(actualizar);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }

        public RestResponse PutEstadio(Estadios actualizar)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest("/estadios", Method.Put);
            string data = JsonConvert.SerializeObject(actualizar);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }

        public RestResponse PutPartido(Partidos actualizar)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest("/partidos", Method.Put);
            string data = JsonConvert.SerializeObject(actualizar);
            request.AddParameter("application/json", data, ParameterType.RequestBody);
            var response = client.Execute(request);
            return response;
        }

        public RestResponse DeleteEquipo(int id)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest($"/equipos/{id}", Method.Delete);
            var response = client.Execute(request);
            return response;
        }

        public RestResponse DeleteEstadio(int id)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest($"/estadios/{id}", Method.Delete);
            var response = client.Execute(request);
            return response;
        }

        public RestResponse DeleteJugador(int id)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest($"/jugadores/{id}", Method.Delete);
            var response = client.Execute(request);
            return response;
        }

        public RestResponse DeletePartido(int id)
        {
            var client = new RestClient("http://localhost:8080/bdinfonba/infonba");
            var request = new RestRequest($"/partidos/{id}", Method.Delete);
            var response = client.Execute(request);
            return response;
        }

        public ServicioApi() { }
    }
}
