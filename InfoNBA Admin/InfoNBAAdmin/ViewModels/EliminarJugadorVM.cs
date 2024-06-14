using CommunityToolkit.Mvvm.ComponentModel;
using InfoNBAAdmin.Clases;
using InfoNBAAdmin.Servicios;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace InfoNBAAdmin.ViewModels
{
    internal class EliminarJugadorVM : ObservableObject
    {
        private ObservableCollection<Jugadores> listaJugadores;
        private Jugadores jugadorSeleccionado;
        public ObservableCollection<Jugadores> ListaJugadores { get { return listaJugadores; } set { SetProperty(ref listaJugadores, value); } }
        public Jugadores JugadorSeleccionado
        {
            get { return jugadorSeleccionado; }
            set { SetProperty(ref jugadorSeleccionado, value); }
        }

        private ServicioApi api;

        public EliminarJugadorVM()
        {
            api = new ServicioApi();
            ListaJugadores = api.GetJugadores();
        }

        public void EliminarJugador()
        {
            api.DeleteJugador(JugadorSeleccionado.Id);
            ListaJugadores.Remove(JugadorSeleccionado);
        }
    }
}
