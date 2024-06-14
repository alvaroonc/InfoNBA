using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.ObjectModel;
using CommunityToolkit.Mvvm.ComponentModel;
using InfoNBAAdmin.Clases;
using InfoNBAAdmin.Servicios;

namespace InfoNBAAdmin.ViewModels
{
    internal class EditarJugadorVM : ObservableObject
    {
        private Jugadores jugadorSeleccionado;
        private Jugadores jugadorEditar;
        private Equipos equipoSeleccionado;
        private ObservableCollection<Jugadores> listaJugadores;
        private ObservableCollection<Equipos> listaEquipos;

        public Jugadores JugadorSeleccionado { get { return jugadorSeleccionado; } set { SetProperty(ref jugadorSeleccionado, value); } }
        public Jugadores JugadorEditar { get {  return jugadorEditar; } set { SetProperty(ref jugadorEditar, value); } }
        public Equipos EquipoSeleccionado { get { return equipoSeleccionado;} set { SetProperty(ref equipoSeleccionado, value); }}
        public ObservableCollection<Jugadores > ListaJugadores { get {  return listaJugadores; } set { SetProperty(ref  listaJugadores, value); } }
        public ObservableCollection<Equipos> ListaEquipos { get {  return listaEquipos; } set { SetProperty(ref listaEquipos, value); } }

        ServicioApi api;

        public EditarJugadorVM()
        {
            api = new ServicioApi();
            ListaJugadores = api.GetJugadores();
            ListaEquipos = api.GetEquipos();
            JugadorEditar = new Jugadores();
        }

        public void EditarJugador()
        {
            api.PutJugador(JugadorEditar);
        }
    }
}
