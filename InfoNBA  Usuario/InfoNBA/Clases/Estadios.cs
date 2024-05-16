using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CommunityToolkit.Mvvm.ComponentModel;

namespace InfoNBA.Clases
{
    class Estadios : ObservableObject
    {
        private int id;
        private string nombre;
        private int capacidad;
        private string ciudad;
        private string imagen;

        public int Id {  get { return id; } set { SetProperty(ref id, value); } }
        public string Nombre { get {  return nombre; } set { SetProperty(ref nombre, value); } }
        public int Capacidad { get {  return capacidad; } set { SetProperty(ref capacidad, value); } }
        public string Ciudad { get { return ciudad; } set { SetProperty(ref ciudad, value);  } }
        public string Imagen { get { return imagen; } set { SetProperty(ref imagen, value); } }

        public Estadios(int capacidad, string ciudad, int id, string imagen, string nombre)
        {
            this.id = id;
            this.nombre = nombre;
            this.capacidad = capacidad;
            this.ciudad = ciudad;
            this.imagen = imagen;
        }
    }
}
