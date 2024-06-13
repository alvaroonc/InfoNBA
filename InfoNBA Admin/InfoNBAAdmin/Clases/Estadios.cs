using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InfoNBAAdmin.Clases
{
    using Newtonsoft.Json;

    class Estadios : ObservableObject
    {
        private int id;
        private string nombre;
        private int capacidad;
        private string ciudad;
        private string imagen;

        [JsonProperty("id")]
        public int Id { get { return id; } set { SetProperty(ref id, value); } }

        [JsonProperty("nombre")]
        public string Nombre { get { return nombre; } set { SetProperty(ref nombre, value); } }

        [JsonProperty("capacidad")]
        public int Capacidad { get { return capacidad; } set { SetProperty(ref capacidad, value); } }

        [JsonProperty("ciudad")]
        public string Ciudad { get { return ciudad; } set { SetProperty(ref ciudad, value); } }

        [JsonProperty("imagen")]
        public string Imagen { get { return imagen; } set { SetProperty(ref imagen, value); } }

        public Estadios(int capacidad, string ciudad, int id, string imagen, string nombre)
        {
            Capacidad = capacidad;
            Ciudad = ciudad;
            Id = id;
            Imagen = imagen;
            Nombre = nombre;
        }

        public Estadios() { }
    }



}
