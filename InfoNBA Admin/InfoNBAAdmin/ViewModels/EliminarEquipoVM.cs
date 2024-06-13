using InfoNBAAdmin.Clases;
using InfoNBAAdmin.Servicios;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CommunityToolkit.Mvvm.ComponentModel;

namespace InfoNBAAdmin.ViewModels
{
    class EliminarEquipoVM : ObservableObject
    {
        private ObservableCollection<Equipos> listaEquipos;
        private Equipos equipoSeleccionado;
        public ObservableCollection<Equipos> ListaEquipos { get { return listaEquipos; } set { SetProperty(ref listaEquipos, value); } }
        public Equipos EquipoSeleccionado
        {
            get { return equipoSeleccionado; }
            set { SetProperty(ref equipoSeleccionado, value); }
        }

        private ServicioApi api;

        public EliminarEquipoVM()
        {
            api = new ServicioApi();
            ListaEquipos = api.GetEquipos();
        }

        public void EliminarEquipo()
        {
            api.DeleteEquipo(EquipoSeleccionado.Id);
            ListaEquipos.Remove(EquipoSeleccionado);
        }
    }
}
