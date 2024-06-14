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
    internal class EliminarPartidoVM : ObservableObject
    {
        private ObservableCollection<Partidos> listaPartidos;
        private Partidos partidoSeleccionado;
        public ObservableCollection<Partidos> ListaPartidos { get { return listaPartidos; } set { SetProperty(ref listaPartidos, value); } }
        public Partidos PartidoSeleccionado
        {
            get { return partidoSeleccionado; }
            set { SetProperty(ref partidoSeleccionado, value); }
        }

        private ServicioApi api;

        public EliminarPartidoVM()
        {
            api = new ServicioApi();
            ListaPartidos = api.GetPartidos();
        }

        public void EliminarPartido()
        {
            api.DeletePartido(PartidoSeleccionado.Id);
            ListaPartidos.Remove(PartidoSeleccionado);
        }
    }
}
