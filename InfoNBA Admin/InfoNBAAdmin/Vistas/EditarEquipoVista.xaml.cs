using InfoNBAAdmin.ViewModels;
using Newtonsoft.Json;
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
    /// Lógica de interacción para EditarEquipoVista.xaml
    /// </summary>
    public partial class EditarEquipoVista : Page
    {
        EditarEquipoVM vm;
        public EditarEquipoVista()
        {
            InitializeComponent();
            vm = new EditarEquipoVM();
            this.DataContext = vm;
        }

        private void EditarEquipoButtonClick(object sender, RoutedEventArgs e)
        {
            vm.EquipoEditar.Campeonatos = int.Parse(CampeonatosTextBox.Text);
            vm.EquipoEditar.Ciudad = CiudadTextBox.Text;
            vm.EquipoEditar.ColorPrincipal = ColorPrincipalTextBox.Text;
            vm.EquipoEditar.Conferencia = ConferenciaTextBox.Text;
            vm.EquipoEditar.Derrotas = int.Parse(DerrotasTextBox.Text);
            vm.EquipoEditar.Entrenador = EntrenadorTextBox.Text;
            vm.EquipoEditar.Fundacion = FundacionTextBox.Text;
            vm.EquipoEditar.Id = vm.EquipoSeleccionado.Id;
            vm.EquipoEditar.IdEstadio = vm.EstadioSeleccionado;
            vm.EquipoEditar.Logo = LogoTextBox.Text;
            vm.EquipoEditar.Nombre = NombreTextBox.Text;
            vm.EquipoEditar.Victorias = int.Parse(VictoriasTextBox.Text);

            vm.EditarEquipo();
            MessageBox.Show("Se ha editado el equipo " + vm.EquipoEditar.Nombre);

            EquiposComboBox.SelectedItem = null;
            EstadiosComboBox.SelectedItem = null;
        }
    }
}
