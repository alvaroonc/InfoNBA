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
    class EquiposVistaVM : ObservableObject
    {
        private Equipos equipo;
        private ObservableCollection<Equipos> listaEquipos;

        public Equipos Equipo { get { return equipo; }  set { SetProperty(ref equipo, value); } }
        public ObservableCollection<Equipos> ListaEquipos 
        { 
            get { return listaEquipos; } 
            set { SetProperty(ref  listaEquipos, value); } 
        }

        ServicioApi api;

        public EquiposVistaVM()
        {
            api = new ServicioApi();
            ListaEquipos = api.GetEquipos();
        }
    }
}
