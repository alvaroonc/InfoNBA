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
    /// Lógica de interacción para EliminarJugadorVista.xaml
    /// </summary>
    public partial class EliminarJugadorVista : Page
    {
        EliminarJugadorVM vm;
        public EliminarJugadorVista()
        {
            InitializeComponent();
            vm = new EliminarJugadorVM();
            this.DataContext = vm;
        }

        private void EliminarJugadorButtonClick(object sender, RoutedEventArgs e)
        {
            vm.EliminarJugador();
            MessageBox.Show("Jugador eliminado");
        }
    }
}
