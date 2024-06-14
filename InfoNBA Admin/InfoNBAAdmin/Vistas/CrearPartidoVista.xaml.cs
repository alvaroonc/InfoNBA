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
    /// Lógica de interacción para CrearPartidoVista.xaml
    /// </summary>
    public partial class CrearPartidoVista : Page
    {
        CrearPartidoVM vm;
        public CrearPartidoVista()
        {
            InitializeComponent();
            vm = new CrearPartidoVM();
            this.DataContext = vm;
        }

        private void CrearPartidoButtonClick(object sender, RoutedEventArgs e)
        {
            vm.PartidoCrear.EquipoLocal = vm.EquipoLocal;
            vm.PartidoCrear.EquipoVisitante = vm.EquipoVisitante;
            vm.PartidoCrear.Estadio = vm.EstadioSeleccionado;
            vm.PartidoCrear.PuntosLocal = int.Parse(PuntosLocalTextBox.Text);
            vm.PartidoCrear.PuntosVisitante = int.Parse(PuntosVisitanteTextBox.Text);

            vm.CrearPartido();

            MessageBox.Show("Partido " + vm.PartidoCrear.EquipoLocal.Nombre + " vs " + vm.PartidoCrear.EquipoVisitante.Nombre + " creado");

            EquipoLocalComboBox.SelectedItem = null;
            EquipoVisitanteComboBox.SelectedItem = null;
            EstadioComboBox.SelectedItem = null;
            PuntosLocalTextBox.Text = string.Empty;
            PuntosVisitanteTextBox.Text = string.Empty;
        }
    }
}
