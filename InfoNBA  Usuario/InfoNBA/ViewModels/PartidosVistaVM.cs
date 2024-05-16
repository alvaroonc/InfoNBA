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
    class PartidosVistaVM : ObservableObject
    {
        private ObservableCollection<Partidos> listaPartidos;

        public ObservableCollection<Partidos> ListaPartidos {  get { return listaPartidos; } set { SetProperty(ref listaPartidos, value);} }

        ServicioApi api;

        public PartidosVistaVM()
        {
            api = new ServicioApi();
            ListaPartidos = api.GetPartidos();
        }
    }
}
