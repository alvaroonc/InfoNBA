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
    internal class EditarEquipoVM : ObservableObject
    {
        private Equipos equipoSeleccionado;
        private Equipos equipoEditar;
        private Estadios estadioSeleccionado;
        private ObservableCollection<Equipos> listaEquipos;
        private ObservableCollection<Estadios> listaEstadios;

        public Equipos EquipoSeleccionado { get {  return equipoSeleccionado; } set { SetProperty(ref equipoSeleccionado, value); } }
        public Equipos EquipoEditar { get { return equipoEditar; } set { SetProperty(ref equipoEditar, value); } }
        public Estadios EstadioSeleccionado { get { return estadioSeleccionado;} set { SetProperty(ref estadioSeleccionado, value); }}
        public ObservableCollection<Equipos> ListaEquipos { get { return listaEquipos; } set { SetProperty(ref listaEquipos, value); } }
        public ObservableCollection<Estadios> ListaEstadios { get { return listaEstadios;} set { SetProperty (ref listaEstadios, value); } }

        ServicioApi api;

        public EditarEquipoVM()
        {
            api = new ServicioApi();
            ListaEquipos = api.GetEquipos();
            ListaEstadios = api.GetEstadios();
            EquipoEditar = new Equipos();
        }

        public void EditarEquipo()
        {
            api.PutEquipo(EquipoEditar);
        }
    }
}
