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
        public int campeonatos;
        public string ciudad; 
        public string colorPrincipal;
        public string conferencia;
        public int derrotas;
        public string entrenador;
        public string fundacion;
        public int id;
        public Estadios idEstadio;
        public string logo;
        public string nombre;
        public int victorias;

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
        public Estadios IdEstadio { get { return idEstadio; } set { SetProperty(ref idEstadio, value); } }

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
            IdEstadio = idEstadio;
        }

        public Equipos() { }
    }
}
