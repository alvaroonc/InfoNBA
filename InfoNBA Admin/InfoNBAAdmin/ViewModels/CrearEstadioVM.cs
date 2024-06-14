using CommunityToolkit.Mvvm.ComponentModel;
using InfoNBAAdmin.Clases;
using InfoNBAAdmin.Servicios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InfoNBAAdmin.ViewModels
{
    internal class CrearEstadioVM : ObservableObject
    {
        private Estadios estadioNuevo;
        public Estadios EstadioNuevo { get { return estadioNuevo; } set { SetProperty(ref estadioNuevo, value); } }

        ServicioApi api;

        public CrearEstadioVM()
        {
            api = new ServicioApi();
            EstadioNuevo = new Estadios();
        }

        public void CrearEstadio(Estadios e)
        {
            api.PostEstadio(e);
        }
    }
}
