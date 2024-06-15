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
    class ClasificacionViewModel : ObservableObject
    {
        private ObservableCollection<Equipos> clasificacionEste;
        private ObservableCollection<Equipos> clasificacionOeste;

        public ObservableCollection<Equipos> ClasificacionEste { get {  return clasificacionEste; } set { SetProperty(ref  clasificacionEste, value); } }
        public ObservableCollection<Equipos> ClasificacionOeste { get {  return clasificacionOeste;} set { SetProperty(ref clasificacionOeste, value); } }

        ServicioApi api;

        public ClasificacionViewModel()
        {
            api = new ServicioApi();
            ClasificacionEste = api.GetEste();
            ClasificacionOeste = api.GetOeste();
        }

    }
}
