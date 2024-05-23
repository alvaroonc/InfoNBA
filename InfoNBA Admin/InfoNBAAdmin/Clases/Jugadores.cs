using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InfoNBAAdmin.Clases
{
    class Jugadores : ObservableObject
    {
        private int id;
        private Equipos equipo;
        private string nombre;
        private string apelllido;
        private string posicion;
        private int altura;
        private float peso;
        private int dorsal;
        private int partidosJugados;
        private int puntos;
        private int asistencias;
        private int rebotes;

        public int Id { get { return id; } set { SetProperty(ref id, value); } }
        public Equipos Equipo { get { return equipo; } set { SetProperty(ref equipo, value); } }
        public string Nombre { get { return nombre; } set { SetProperty(ref nombre, value); } }
        public string Apellido { get { return apelllido; } set { SetProperty(ref apelllido, value); } }
        public string Posicion { get { return posicion; } set { SetProperty(ref posicion, value); } }
        public int Altura { get { return altura; } set { SetProperty(ref altura, value); } }
        public float Peso { get { return peso; } set { SetProperty(ref peso, value); } }
        public int Dorsal { get { return dorsal; } set { SetProperty(ref dorsal, value); } }
        public int PartidosJugados { get { return partidosJugados; } set { SetProperty(ref partidosJugados, value); } }
        public int Puntos { get { return puntos; } set { SetProperty(ref puntos, value); } }
        public int Asistencias { get { return asistencias; } set { SetProperty(ref asistencias, value); } }
        public int Rebotes { get { return rebotes; } set { SetProperty(ref rebotes, value); } }

        public Jugadores(int altura, string apellido, int asistencias, int dorsal, int id, Equipos idEquipo, string nombre, int partidosJugados, float peso, string posicion, int puntos, int rebotes)
        {
            Id = id;
            Equipo = idEquipo;
            Nombre = nombre;
            Apellido = apellido;
            Posicion = posicion;
            Altura = altura;
            Peso = peso;
            Dorsal = dorsal;
            PartidosJugados = partidosJugados;
            Puntos = puntos;
            Asistencias = asistencias;
            Rebotes = rebotes;
        }
    }
}
