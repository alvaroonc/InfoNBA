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
    internal class EditarEstadioVM : ObservableObject
    {
        private Estadios estadioSeleccionado;
        private Estadios estadioNuevo;
        private ObservableCollection<Estadios> listaEstadios;
        public Estadios EstadioSeleccionado { get { return estadioSeleccionado; } set { SetProperty(ref estadioSeleccionado, value); } }
        public Estadios EstadioNuevo { get { return estadioNuevo;} set { SetProperty(ref estadioNuevo, value); } }
        public ObservableCollection<Estadios> ListaEstadios { get {  return listaEstadios; } set { SetProperty(ref listaEstadios, value); } }

        ServicioApi api;

        public EditarEstadioVM()
        {
            api = new ServicioApi();
            ListaEstadios = api.GetEstadios();
            EstadioNuevo = new Estadios();
        }

        public void EditarEstadio()
        {
            api.PutEstadio(EstadioNuevo);
        }
    }
}
