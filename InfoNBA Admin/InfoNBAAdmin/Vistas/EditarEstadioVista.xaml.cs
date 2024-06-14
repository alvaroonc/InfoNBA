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
    /// Lógica de interacción para EditarEstadioVista.xaml
    /// </summary>
    public partial class EditarEstadioVista : Page
    {
        EditarEstadioVM vm;
        public EditarEstadioVista()
        {
            InitializeComponent();
            vm = new EditarEstadioVM();
            this.DataContext = vm;
        }

        private void EditarEstadioButtonClick(object sender, RoutedEventArgs e)
        {
            vm.EstadioNuevo = vm.EstadioSeleccionado;
            vm.EstadioNuevo.Nombre = NombreTextBox.Text;

            vm.EditarEstadio();
            MessageBox.Show("Estadio " + vm.EstadioNuevo.Nombre + " editado");

            EstadiosComboBox.SelectedItem = null;
        }
    }
}
