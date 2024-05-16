using InfoNBA.Clases;
using Newtonsoft.Json;
using RestSharp;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InfoNBA.Servicios
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

        public ServicioApi() { }
    }
}
