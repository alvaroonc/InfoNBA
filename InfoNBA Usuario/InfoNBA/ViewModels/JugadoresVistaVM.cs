using CommunityToolkit.Mvvm.ComponentModel;
using InfoNBA.Clases;
using InfoNBA.Servicios;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InfoNBA.ViewModels
{
    class JugadoresVistaVM : ObservableObject
    {
        private Jugadores jugador;
        private ObservableCollection<Jugadores> listaJugadores;

        public Jugadores Jugador { get { return jugador; } set { SetProperty(ref jugador, value); } }
        public ObservableCollection<Jugadores> ListaJugadores 
        { 
            get {  return listaJugadores; } 
            set { SetProperty(ref listaJugadores, value); } 
        }

        ServicioApi api;

        public JugadoresVistaVM()
        {
            api = new ServicioApi();
            ListaJugadores = api.GetJugadores();
        }
    }
}
