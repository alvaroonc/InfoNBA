using InfoNBAAdmin.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace InfoNBAAdmin.Vistas
{
    /// <summary>
    /// Lógica de interacción para CrearJugadorVista.xaml
    /// </summary>
    public partial class CrearJugadorVista : Page
    {
        CrearJugadorVM vm;
        public CrearJugadorVista()
        {
            InitializeComponent();
            vm = new CrearJugadorVM();
            this.DataContext = vm;
        }

        private void CrearJugadorButtonClick(object sender, RoutedEventArgs e)
        {
            vm.JugadorNuevo.Id = 0;
            vm.JugadorNuevo.Equipo = vm.EquipoSeleccionado;
            vm.JugadorNuevo.Nombre = NombreTextBox.Text;
            vm.JugadorNuevo.Apellido = ApellidoTextBox.Text;
            vm.JugadorNuevo.Posicion = PosicionTextBox.Text;
            vm.JugadorNuevo.Altura = int.Parse(AlturaTextBox.Text);
            vm.JugadorNuevo.Peso = float.Parse(PesoTextBox.Text);
            vm.JugadorNuevo.Dorsal = int.Parse(DorsalTextBox.Text);
            vm.JugadorNuevo.PartidosJugados = int.Parse(PartidosTextBox.Text);
            vm.JugadorNuevo.Puntos = int.Parse(PuntosTextBox.Text);
            vm.JugadorNuevo.Asistencias = int.Parse(AsistenciasTextBox.Text);
            vm.JugadorNuevo.Rebotes = int.Parse(RebotesTextBox.Text);

            vm.CrearJugador(vm.JugadorNuevo);
            MessageBox.Show("Jugador " + vm.JugadorNuevo.Nombre + " " + vm.JugadorNuevo.Apellido + " creado");

            EquiposComboBox.SelectedItem = null;
            NombreTextBox.Text = String.Empty;
            ApellidoTextBox.Text = String.Empty;
            PosicionTextBox.Text = String.Empty;
            AlturaTextBox.Text = String.Empty;
            PesoTextBox.Text = String.Empty;
            DorsalTextBox.Text = String.Empty;
            PartidosTextBox.Text = String.Empty;
            PuntosTextBox.Text = String.Empty;
            RebotesTextBox.Text = String.Empty;
            AsistenciasTextBox.Text = String.Empty;
        }
    }
}
