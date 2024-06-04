using InfoNBAAdmin.Clases;
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
    /// Lógica de interacción para CrearEquipoVista.xaml
    /// </summary>
    public partial class CrearEquipoVista : Page
    {
        CrearEquipoVM vm;
        public CrearEquipoVista()
        {
            InitializeComponent();
            vm = new CrearEquipoVM();
            this.DataContext = vm;
        }

        private void CrearEquipoButtonClick(object sender, RoutedEventArgs e)
        { 

            Equipos eq = new Equipos(int.Parse(CampeonatosTextBox.Text), 
                                    CiudadTextBox.Text, 
                                    ColorPrincipalTextBox.Text, 
                                    ConferenciaTextBox.Text, 
                                    int.Parse(DerrotasTextBox.Text),
                                    EntrenadorTextBox.Text,
                                    FundacionTextBox.Text, 
                                    0,
                                    vm.EquipoNuevo.IdEstadio,
                                    LogoTextBox.Text,
                                    NombreTextBox.Text,
                                    int.Parse(VictoriasTextBox.Text));
            vm.CrearEquipo(eq);
        }
    }
}
