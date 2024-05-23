﻿using System;
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
    /// Lógica de interacción para EquiposVista.xaml
    /// </summary>
    public partial class EquiposVista : Page
    {
        public EquiposVista()
        {
            InitializeComponent();
        }

        private void CrearButtonClick(object sender, RoutedEventArgs e)
        {
            frameContent.Navigate(new CrearEquipoVista());
        }

        private void EditarButtonClick(object sender, RoutedEventArgs e)
        {
            frameContent.Navigate(new EditarEquipoVista());
        }

        private void EliminarButtonClick(object sender, RoutedEventArgs e)
        {
            frameContent.Navigate(new EliminarEquipoVista());
        }
    }
}