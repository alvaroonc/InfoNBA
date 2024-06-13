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
    /// Lógica de interacción para EliminarEquipoVista.xaml
    /// </summary>


    public partial class EliminarEquipoVista : Page
    {
        EliminarEquipoVM vm;
        public EliminarEquipoVista()
        {
            InitializeComponent();
            vm = new EliminarEquipoVM();
            this.DataContext = vm;
        }

        private void EliminarEquipoButtonClick(object sender, RoutedEventArgs e)
        {
            vm.EliminarEquipo();
            MessageBox.Show("Equipo eliminado.");
        }
    }
}
