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
    /// Lógica de interacción para EliminarPartidoVista.xaml
    /// </summary>
    public partial class EliminarPartidoVista : Page
    {
        EliminarPartidoVM vm;
        public EliminarPartidoVista()
        {
            InitializeComponent();
            vm = new EliminarPartidoVM();
            this.DataContext = vm;
        }

        private void EliminarPartidoButtonClick(object sender, RoutedEventArgs e)
        {
            vm.EliminarPartido();
            MessageBox.Show("Partido eliminado");
        }
    }
}
