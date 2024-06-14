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
    internal class CrearJugadorVM : ObservableObject
    {
        private Jugadores jugadorNuevo;
        private ObservableCollection<Equipos> listaEquipos;
        private Equipos equipoSeleccionado;
        public Jugadores JugadorNuevo { get {  return jugadorNuevo; } set { SetProperty(ref  jugadorNuevo, value);} }
        public ObservableCollection<Equipos> ListaEquipos { get {  return listaEquipos; } set { SetProperty(ref listaEquipos, value); } }
        public Equipos EquipoSeleccionado { get {  return equipoSeleccionado; } set { SetProperty(ref equipoSeleccionado, value); } }

        ServicioApi api;

        public CrearJugadorVM()
        {
            api = new ServicioApi();
            ListaEquipos = api.GetEquipos();
            JugadorNuevo = new Jugadores();
        }

        public void CrearJugador(Jugadores j)
        {
            api.PostJugador(j);
        }
    }
}
