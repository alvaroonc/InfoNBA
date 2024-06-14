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
    internal class EliminarEstadioVM : ObservableObject
    {
        private ObservableCollection<Estadios> listaEstadios;
        private Estadios estadioSeleccionado;
        public ObservableCollection<Estadios> ListaEstadios { get { return listaEstadios; } set { SetProperty(ref listaEstadios, value); } }
        public Estadios EstadioSeleccionado
        {
            get { return estadioSeleccionado; }
            set { SetProperty(ref estadioSeleccionado, value); }
        }

        private ServicioApi api;

        public EliminarEstadioVM()
        {
            api = new ServicioApi();
            ListaEstadios = api.GetEstadios();
        }

        public void EliminarEstadio()
        {
            api.DeleteEstadio(EstadioSeleccionado.Id);
            ListaEstadios.Remove(EstadioSeleccionado);
        }
    }
}
