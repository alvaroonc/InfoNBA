   M S B A M L   `   `   `  ����G  CInfoNBAAdmin, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null9!clr-namespace:InfoNBAAdmin.VistasInfoNBAAdmin.Vistas  5      +    %InfoNBAAdmin.Vistas.EditarEquipoVista   5      W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5      R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      3local!clr-namespace:InfoNBAAdmin.Vistas     5        N� Title$  EditarEquipoVista��5	      .��5      � $��10q�6    � ColumnDefinitions 5   
   �� 5      �� 5       � RowDefinitions 5   
   �� 5      �� 5      �� 5      �� 5      �� 5      �� 5      �� 5      �� 5      .+�5   
   �� $��0��6   $��2��6"    �� Orientation$ 
Horizontal=�66   $��Center=�6O   $��Center=�6l   $��35��6�   .+�5      �� $��
Id equipo ��6   $��Center=�6*   �� 5      -   5         ��Name$ EquiposComboBox��5      $	��100��61    �� DisplayMemberPath$ Nombre��6g   ��6=   ��  �� Path$ ListaEquipos� �� SelectedItem 6�   �� $ EquipoSeleccionado� �� UpdateSourceTrigger$ PropertyChanged=�5      �� 5   
   $��1��6   $��0��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5       �� $��Nombre ��6   $��Center=�6'   �� 5!      -   5        	 ��Name$	 NombreTextBox��5!      $��25��6-   $	��150��69   $��10q�6E   ��6Q   �� $ EquipoSeleccionado.Nombre�5"      �� 5#   
   $��1��6   $��1��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5$      �� $��Campeonatos ��6   $��Center=�6,   �� 5%      -   5        $	 CampeonatosTextBox��5%      $��25��62   $	��150��6>   $��10q�6J   ��6V   �� $$ EquipoSeleccionado.Campeonatos�$ PropertyChanged=�5&      �� 5'   
   $��2��6   $��0��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5(      �� $��Entrenador ��6   $��Center=�6+   �� 5)      -   5        $	 EntrenadorTextBox��5)      $��25��61   $	��150��6=   $��10q�6I   ��6U   �� $# EquipoSeleccionado.Entrenador�$ PropertyChanged=�5*      �� 5+   
   $��2��6   $��1��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5,      �� $��
Fundacion ��6   $��Center=�6*   �� 5-      -   5        $	 FundacionTextBox��5-      $��25��60   $	��150��6<   $��10q�6H   ��6T   �� $" EquipoSeleccionado.Fundacion�$ PropertyChanged=�5.      �� 5/   
   $��3��6   $��0��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�50      �� $��Ciudad ��6   $��Center=�6'   �� 51      -   5        $	 CiudadTextBox��51      $��25��6-   $	��150��69   $��10q�6E   ��6Q   �� $ EquipoSeleccionado.Ciudad�$ PropertyChanged=�52      �� 53   
   $��3��6   $��1��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�54      �� $��Logo ��6   $��Center=�6%   �� 55      -   5        $	 LogoTextBox��55      $��25��6+   $	��150��67   $��10q�6C   ��6O   �� $ EquipoSeleccionado.Logo�$ PropertyChanged=�56      �� 57   
   $��4��6   $��0��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�58      �� $��Color principal ��6   $��Center=�60   �� 59      -   5        $	 ColorPrincipalTextBox��59      $��25��65   $	��150��6A   $��10q�6M   ��6Y   �� $' !EquipoSeleccionado.ColorPrincipal�$ PropertyChanged=�5:      �� 5;   
   $��4��6   $��1��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5<      �� $��Conferencia ��6   $��Center=�6,   �� 5=      -	   5        $	 ConferenciaTextBox��5=      $��25��62   $	��150��6>   $��10q�6J   ��6V   �� $$ EquipoSeleccionado.Conferencia�$ PropertyChanged=�5>      �� 5?   
   $��5��6   $��0��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5@      �� $��
Victorias ��6   $��Center=�6*   �� 5A      -
   5        $	 VictoriasTextBox��5A      $��25��60   $	��150��6<   $��10q�6H   ��6T   �� $" EquipoSeleccionado.Victorias�$ PropertyChanged=�5B      �� 5C   
   $��5��6   $��1��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5D      �� $��	Derrotas ��6   $��Center=�6)   �� 5E      -   5        $	 DerrotasTextBox��5E      $��25��6/   $	��150��6;   $��10q�6G   ��6S   �� $! EquipoSeleccionado.Derrotas�$ PropertyChanged=�5F      �� 5G   
   $��6��6   $��2��6"   $ 
Horizontal=�66   $��Center=�6O   $��Center=�6l   $��35��6�   .+�5H      �� $��Estadio ��6   $��Center=�6(   �� 5I      -   5        $ EstadiosComboBox��5I      $	��100��62   $ Nombre��6i   ��6>   �� $ ListaEstadios� 6�   �� $ EstadioSeleccionado�$ PropertyChanged=�5J      �� 5K   
   -   5        
 ��Name$
 EditarEquipoButton��5K      $��7��6-   $��2��6:   $��Editar Equipo��6N   $��Center=�6f   $	��200��6�   $��10q�6�   6�   5L      5M      