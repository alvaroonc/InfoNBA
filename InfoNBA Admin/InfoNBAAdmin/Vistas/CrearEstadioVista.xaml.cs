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
    /// Lógica de interacción para CrearEstadioVista.xaml
    /// </summary>
    public partial class CrearEstadioVista : Page
    {
        CrearEstadioVM vm;
        public CrearEstadioVista()
        {
            InitializeComponent();
            vm = new CrearEstadioVM();
            this.DataContext = vm;
        }

        private void CrearEstadioButtonClick(object sender, RoutedEventArgs e)
        {
            vm.EstadioNuevo.Id = 0;
            vm.EstadioNuevo.Nombre = NombreTextBox.Text;
            vm.EstadioNuevo.Capacidad = int.Parse(CapacidadTextBox.Text);
            vm.EstadioNuevo.Ciudad = CiudadTextBox.Text;
            vm.EstadioNuevo.Imagen = ImagenTextBox.Text;

            vm.CrearEstadio(vm.EstadioNuevo);
            MessageBox.Show("Estadio " + vm.EstadioNuevo.Nombre + " creado");

            NombreTextBox.Text = String.Empty;
            CapacidadTextBox.Text = String.Empty;
            CiudadTextBox.Text = String.Empty;
            ImagenTextBox.Text = String.Empty;
        }
    }
}
