using InfoNBA.Vistas;
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

namespace InfoNBA
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            frameContent.Navigate(new InicioVista());
        }

        private void EquiposRadioClick(object sender, RoutedEventArgs e)
        {
            frameContent.Navigate(new EquiposVista());
        }

        private void JugadoresRadioClick(object sender, RoutedEventArgs e)
        {
            frameContent.Navigate(new JugadoresVista());
        }

        private void PartidosRadioClick(object sender, RoutedEventArgs e)
        {
            frameContent.Navigate(new PartidosVista());
        }

        private void EstadiosRadioClick(object sender, RoutedEventArgs e)
        {
            frameContent.Navigate(new EstadiosVista());
        }

        private void InfoNBAButtonClick(object sender, RoutedEventArgs e)
        {
            frameContent.Navigate(new InicioVista());
            EquiposRadio.IsChecked = false;
            EstadiosRadio.IsChecked = false;
            JugadoresRadio.IsChecked = false;
            PartidosRadio.IsChecked = false;
        }
    }
}
