using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InfoNBAAdmin.Clases
{
    using Newtonsoft.Json;

    class Equipos : ObservableObject
    {
        private int campeonatos;
        private string ciudad;
        private string colorPrincipal;
        private string conferencia;
        private int derrotas;
        private string entrenador;
        private string fundacion;
        private int id;
        private Estadios idEstadio;
        private string logo;
        private string nombre;
        private int victorias;

        [JsonProperty("campeonatos")]
        public int Campeonatos { get { return campeonatos; } set { SetProperty(ref campeonatos, value); } }

        [JsonProperty("ciudad")]
        public string Ciudad { get { return ciudad; } set { SetProperty(ref ciudad, value); } }

        [JsonProperty("colorPrincipal")]
        public string ColorPrincipal { get { return colorPrincipal; } set { SetProperty(ref colorPrincipal, value); } }

        [JsonProperty("conferencia")]
        public string Conferencia { get { return conferencia; } set { SetProperty(ref conferencia, value); } }

        [JsonProperty("derrotas")]
        public int Derrotas { get { return derrotas; } set { SetProperty(ref derrotas, value); } }

        [JsonProperty("entrenador")]
        public string Entrenador { get { return entrenador; } set { SetProperty(ref entrenador, value); } }

        [JsonProperty("fundacion")]
        public string Fundacion { get { return fundacion; } set { SetProperty(ref fundacion, value); } }

        [JsonProperty("id")]
        public int Id { get { return id; } set { SetProperty(ref id, value); } }

        [JsonProperty("idEstadio")]
        public Estadios IdEstadio { get { return idEstadio; } set { SetProperty(ref idEstadio, value); } }

        [JsonProperty("logo")]
        public string Logo { get { return logo; } set { SetProperty(ref logo, value); } }

        [JsonProperty("nombre")]
        public string Nombre { get { return nombre; } set { SetProperty(ref nombre, value); } }

        [JsonProperty("victorias")]
        public int Victorias { get { return victorias; } set { SetProperty(ref victorias, value); } }

        public Equipos(int campeonatos, string ciudad, string colorPrincipal, string conferencia, int derrotas, string entrenador, string fundacion, int id, Estadios idEstadio, string logo, string nombre, int victorias)
        {
            Campeonatos = campeonatos;
            Ciudad = ciudad;
            ColorPrincipal = colorPrincipal;
            Conferencia = conferencia;
            Derrotas = derrotas;
            Entrenador = entrenador;
            Fundacion = fundacion;
            Id = id;
            IdEstadio = idEstadio;
            Logo = logo;
            Nombre = nombre;
            Victorias = victorias;
        }

        public Equipos() { }
    }




}
