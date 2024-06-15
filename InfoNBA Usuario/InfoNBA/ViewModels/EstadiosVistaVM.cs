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
    class EstadiosVistaVM : ObservableObject
    {
        private Estadios estadio;
        private ObservableCollection<Estadios> listaEstadios;

        public Estadios Estadio { get { return estadio; } set { SetProperty(ref estadio, value); } }
        public ObservableCollection<Estadios> ListaEstadios 
        { 
            get { return listaEstadios; }
            set { SetProperty(ref listaEstadios, value); }
        }

        ServicioApi api;

        public EstadiosVistaVM() 
        {
            api = new ServicioApi();
            ListaEstadios = api.GetEstadios();
        }
    }
}
