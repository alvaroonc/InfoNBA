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
    /// Lógica de interacción para EditarPartidoVsita.xaml
    /// </summary>
    public partial class EditarPartidoVsita : Page
    {
        EditarPartidoVM vm;
        public EditarPartidoVsita()
        {
            InitializeComponent();
            vm = new EditarPartidoVM();
            this.DataContext = vm;
        }

        private void EditarPartidoButtonClick(object sender, RoutedEventArgs e)
        {
            vm.PartidoEditar = vm.PartidoSeleccionado;
            vm.PartidoEditar.EquipoLocal = vm.EquipoLocal;
            vm.PartidoEditar.EquipoVisitante = vm.EquipoVisitante;
            vm.PartidoEditar.Estadio = vm.EstadioSeleccionado;

            vm.EditarPartido();
            MessageBox.Show("Partido " + vm.PartidoEditar.EquipoLocal.Nombre + " vs " + vm.PartidoEditar.EquipoVisitante.Nombre + " editado");

            PartidosComboBox.SelectedItem = null;
            EquipoLocalComboBox.SelectedItem = null;
            EquipoVisitanteComboBox.SelectedItem = null;
            EstadiosComboBox.SelectedItem = null;
            PuntosLocalTextBox.Text = string.Empty;
            PuntosVisitanteTextBox.Text = string.Empty;
        }
    }
}
