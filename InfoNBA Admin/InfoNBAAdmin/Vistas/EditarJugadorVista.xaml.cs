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
    /// Lógica de interacción para EditarJugadorVista.xaml
    /// </summary>
    public partial class EditarJugadorVista : Page
    {
        EditarJugadorVM vm;
        public EditarJugadorVista()
        {
            InitializeComponent();
            vm = new EditarJugadorVM();
            this.DataContext = vm;
        }

        private void EditarJugadorButtonClick(object sender, RoutedEventArgs e)
        {
            vm.JugadorEditar = vm.JugadorSeleccionado;
            vm.JugadorEditar.Nombre = NombreTextBox.Text;
            vm.JugadorEditar.Equipo = vm.EquipoSeleccionado;

            vm.EditarJugador();

            MessageBox.Show("Jugador " + vm.JugadorEditar.Nombre + " " + vm.JugadorEditar.Apellido + " editado");

            JugadoresComboBox.SelectedItem = null;
            EquiposComboBox.SelectedItem = null;
        }
    }
}
