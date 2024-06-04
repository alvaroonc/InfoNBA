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
    class CrearEquipoVM: ObservableObject
    {
        private Equipos equipoNuevo;
        private ObservableCollection<Estadios> listaEstadios;

        public Equipos EquipoNuevo { get { return equipoNuevo; } set { SetProperty(ref equipoNuevo, value); } }
        public ObservableCollection<Estadios> ListaEstadios {  get { return listaEstadios; } set { SetProperty(ref listaEstadios, value); } }

        private ServicioApi api;

        public CrearEquipoVM()
        {
            api = new ServicioApi();
            ListaEstadios = api.GetEstadios();
            EquipoNuevo = new Equipos();
        }

        public void CrearEquipo(Equipos e)
        {
            var response = api.PostEquipo(e);
        }
    }
}
