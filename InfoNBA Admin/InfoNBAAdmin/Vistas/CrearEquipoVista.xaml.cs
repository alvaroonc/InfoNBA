using InfoNBAAdmin.Clases;
using InfoNBAAdmin.ViewModels;
using Newtonsoft.Json;
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
            Estadios estadio = new Estadios(vm.EstadioSeleccionado.Capacidad,
                                            vm.EstadioSeleccionado.Ciudad,
                                            vm.EstadioSeleccionado.Id,
                                            vm.EstadioSeleccionado.Imagen,
                                            vm.EstadioSeleccionado.Nombre);

            Equipos eq = new Equipos(int.Parse(CampeonatosTextBox.Text),
                                     CiudadTextBox.Text,
                                     ColorPrincipalTextBox.Text,
                                     ConferenciaTextBox.Text,
                                     int.Parse(DerrotasTextBox.Text),
                                     EntrenadorTextBox.Text,
                                     FundacionTextBox.Text,
                                     0,
                                     estadio,
                                     LogoTextBox.Text,
                                     NombreTextBox.Text,
                                     int.Parse(VictoriasTextBox.Text));

            MessageBox.Show("Se ha creado el equipo " + eq.Nombre);

            vm.CrearEquipo(eq);

            CampeonatosTextBox.Text = string.Empty;
            CiudadTextBox.Text = string.Empty;
            ColorPrincipalTextBox.Text = string.Empty;
            ConferenciaTextBox.Text = string.Empty;
            DerrotasTextBox.Text = string.Empty;
            EntrenadorTextBox.Text = string.Empty;
            FundacionTextBox.Text = string.Empty;
            LogoTextBox.Text = string.Empty;
            NombreTextBox.Text = string.Empty;
            VictoriasTextBox.Text = string.Empty;
            EstadiosComboBox.SelectedItem= null;
        }
    }
}
