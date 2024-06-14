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
    /// Lógica de interacción para EliminarEstadioVista.xaml
    /// </summary>
    public partial class EliminarEstadioVista : Page
    {
        EliminarEstadioVM vm;
        public EliminarEstadioVista()
        {
            InitializeComponent();
            vm = new EliminarEstadioVM();
            this.DataContext = vm;
        }

        private void EliminarEstadioButtonClick(object sender, RoutedEventArgs e)
        {
            vm.EliminarEstadio();
            MessageBox.Show("Estadio eliminado");
        }
    }
}
