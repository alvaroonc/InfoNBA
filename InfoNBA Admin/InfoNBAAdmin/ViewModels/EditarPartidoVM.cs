using CommunityToolkit.Mvvm.ComponentModel;
using InfoNBAAdmin.Clases;
using InfoNBAAdmin.Servicios;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InfoNBAAdmin.ViewModels
{
    internal class EditarPartidoVM : ObservableObject
    {
        private ObservableCollection<Partidos> listaPartidos;
        private Partidos partidoSeleccionado;
        private ObservableCollection<Equipos> listaEquipos;
        private Equipos equipoLocal;
        private Equipos equipoVisitante;
        private ObservableCollection<Estadios> listaEstadios;
        private Estadios estadioSeleccionado;
        private Partidos partidoEditar;

        public ObservableCollection<Partidos> ListaPartidos { get {  return listaPartidos; } set { SetProperty(ref listaPartidos, value); } }
        public Partidos PartidoSeleccionado { get { return partidoSeleccionado; } set { SetProperty(ref partidoSeleccionado, value); } }
        public ObservableCollection<Equipos> ListaEquipos { get { return listaEquipos; } set { SetProperty(ref listaEquipos, value); } }    
        public Equipos EquipoLocal { get { return equipoLocal; } set { SetProperty(ref equipoLocal, value); } }
        public Equipos EquipoVisitante { get { return equipoVisitante; } set { SetProperty(ref equipoVisitante, value); } }
        public ObservableCollection<Estadios> ListaEstadios { get { return listaEstadios; } set { SetProperty(ref listaEstadios, value); } }    
        public Estadios EstadioSeleccionado { get { return estadioSeleccionado; } set { SetProperty(ref estadioSeleccionado , value); } }
        public Partidos PartidoEditar { get { return partidoEditar; } set { SetProperty(ref partidoEditar, value); } }

        ServicioApi api;

        public EditarPartidoVM()
        {
            api = new ServicioApi();
            ListaPartidos = api.GetPartidos();
            ListaEquipos = api.GetEquipos();
            ListaEstadios = api.GetEstadios();
            PartidoEditar = new Partidos();
        }

        public void EditarPartido()
        {
            api.PutPartido(PartidoEditar);
        }
    }
}
