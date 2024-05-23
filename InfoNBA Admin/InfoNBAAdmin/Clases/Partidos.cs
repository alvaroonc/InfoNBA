using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InfoNBAAdmin.Clases
{
    class Partidos : ObservableObject
    {
        private int id;
        private Equipos equipoLocal;
        private Equipos equipoVisitante;
        private Estadios estadio;
        private int puntosLocal;
        private int puntosVisitante;

        public int Id { get { return id; } set { SetProperty(ref id, value); } }
        public Equipos EquipoLocal { get { return equipoLocal; } set { SetProperty(ref equipoLocal, value); } }
        public Equipos EquipoVisitante { get { return equipoVisitante; } set { SetProperty(ref equipoVisitante, value); } }
        public Estadios Estadio { get { return estadio; } set { SetProperty(ref estadio, value); } }
        public int PuntosLocal { get { return puntosLocal; } set { SetProperty(ref puntosLocal, value); } }
        public int PuntosVisitante { get { return puntosVisitante; } set { SetProperty(ref puntosVisitante, value); } }

        public Partidos(int id, Equipos idEquipoLocal, Equipos idEquipoVisitante, Estadios idEstadio, int puntosLocal, int puntosVisitante)
        {
            Id = id;
            EquipoLocal = idEquipoLocal;
            EquipoVisitante = idEquipoVisitante;
            Estadio = idEstadio;
            PuntosLocal = puntosLocal;
            PuntosVisitante = puntosVisitante;
        }
    }
}
