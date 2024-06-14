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
    internal class CrearPartidoVM : ObservableObject
    {
        private ObservableCollection<Equipos> listaEquipos;
        private Equipos equipoLocal;
        private Equipos equipoVisitante;
        private ObservableCollection<Estadios> listaEstadios;
        private Estadios estadioSeleccionado;
        private Partidos partidoCrear;

        public ObservableCollection<Equipos> ListaEquipos { get { return listaEquipos; } set { SetProperty(ref listaEquipos, value); } }
        public Equipos EquipoLocal { get { return equipoLocal; } set { SetProperty(ref equipoLocal, value); } }
        public Equipos EquipoVisitante { get { return equipoVisitante; } set { SetProperty(ref equipoVisitante, value); } }
        public ObservableCollection<Estadios> ListaEstadios { get {  return listaEstadios; } set { SetProperty (ref listaEstadios, value); } }
        public Estadios EstadioSeleccionado { get {  return estadioSeleccionado; } set { SetProperty(ref  estadioSeleccionado, value);} }
        public Partidos PartidoCrear { get {  return partidoCrear; } set { SetProperty(ref partidoCrear, value); } }

        ServicioApi api;

        public CrearPartidoVM()
        {
            api = new ServicioApi();
            ListaEquipos = api.GetEquipos();
            ListaEstadios = api.GetEstadios();
            PartidoCrear = new Partidos();
        }

        public void CrearPartido()
        {
            api.PostPartido(PartidoCrear);
        }
    }
}
