using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InfoNBAAdmin.Clases
{
    class Equipos : ObservableObject
    {
        private int id;
        private string nombre;
        private int campeonatos;
        private string entrenador;
        private string fundacion;
        private string ciudad;
        private string logo;
        private string colorPrincipal;
        private string conferencia;
        private int victorias;
        private int derrotas;
        private Estadios estadio;
        private string nombreEstadio;

        public int Id { get { return id; } set { SetProperty(ref id, value); } }
        public string Nombre { get { return nombre; } set { SetProperty(ref nombre, value); } }
        public int Campeonatos { get { return campeonatos; } set { SetProperty(ref campeonatos, value); } }
        public string Entrenador { get { return entrenador; } set { SetProperty(ref entrenador, value); } }
        public string Fundacion { get { return fundacion; } set { SetProperty(ref fundacion, value); } }
        public string Ciudad { get { return ciudad; } set { SetProperty(ref ciudad, value); } }
        public string Logo { get { return logo; } set { SetProperty(ref logo, value); } }
        public string ColorPrincipal { get { return colorPrincipal; } set { SetProperty(ref colorPrincipal, value); } }
        public string Conferencia { get { return conferencia; } set { SetProperty(ref conferencia, value); } }
        public int Victorias { get { return victorias; } set { SetProperty(ref victorias, value); } }
        public int Derrotas { get { return derrotas; } set { SetProperty(ref derrotas, value); } }
        public Estadios Estadio { get { return estadio; } set { SetProperty(ref estadio, value); } }
        public string NombreEstadio { get { return nombreEstadio; } set { SetProperty(ref nombreEstadio, value); } }

        public Equipos(int campeonatos, string ciudad, string colorPrincipal, string conferencia, int derrotas, string entrenador, string fundacion, int id, Estadios idEstadio, string logo, string nombre, int victorias)
        {
            Id = id;
            Nombre = nombre;
            Campeonatos = campeonatos;
            Entrenador = entrenador;
            Fundacion = fundacion;
            Ciudad = ciudad;
            Logo = logo;
            ColorPrincipal = colorPrincipal;
            Conferencia = conferencia;
            Victorias = victorias;
            Derrotas = derrotas;
            Estadio = idEstadio;
            NombreEstadio = idEstadio.Nombre;
        }
    }
}
