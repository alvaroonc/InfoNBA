﻿#pragma checksum "..\..\..\..\Vistas\JugadoresVista.xaml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "E55FDC9F51B2303C3A910683578658DB27CFEC41"
//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

using InfoNBAAdmin.Vistas;
using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Controls.Ribbon;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;


namespace InfoNBAAdmin.Vistas {
    
    
    /// <summary>
    /// JugadoresVista
    /// </summary>
    public partial class JugadoresVista : System.Windows.Controls.Page, System.Windows.Markup.IComponentConnector {
        
        
        #line 55 "..\..\..\..\Vistas\JugadoresVista.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button CrearButton;
        
        #line default
        #line hidden
        
        
        #line 56 "..\..\..\..\Vistas\JugadoresVista.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button EditarButton;
        
        #line default
        #line hidden
        
        
        #line 57 "..\..\..\..\Vistas\JugadoresVista.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button EliminarButton;
        
        #line default
        #line hidden
        
        
        #line 60 "..\..\..\..\Vistas\JugadoresVista.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Frame frameContent;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "7.0.12.0")]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/InfoNBAAdmin;V1.0.0.0;component/vistas/jugadoresvista.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\..\..\Vistas\JugadoresVista.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "7.0.12.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            this.CrearButton = ((System.Windows.Controls.Button)(target));
            
            #line 55 "..\..\..\..\Vistas\JugadoresVista.xaml"
            this.CrearButton.Click += new System.Windows.RoutedEventHandler(this.CrearButtonClick);
            
            #line default
            #line hidden
            return;
            case 2:
            this.EditarButton = ((System.Windows.Controls.Button)(target));
            
            #line 56 "..\..\..\..\Vistas\JugadoresVista.xaml"
            this.EditarButton.Click += new System.Windows.RoutedEventHandler(this.EditarButtonClick);
            
            #line default
            #line hidden
            return;
            case 3:
            this.EliminarButton = ((System.Windows.Controls.Button)(target));
            
            #line 57 "..\..\..\..\Vistas\JugadoresVista.xaml"
            this.EliminarButton.Click += new System.Windows.RoutedEventHandler(this.EliminarButtonClick);
            
            #line default
            #line hidden
            return;
            case 4:
            this.frameContent = ((System.Windows.Controls.Frame)(target));
            return;
            }
            this._contentLoaded = true;
        }
    }
}

