   M S B A M L   `   `   `  ����G  CInfoNBAAdmin, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null9!clr-namespace:InfoNBAAdmin.VistasInfoNBAAdmin.Vistas  5      *    $InfoNBAAdmin.Vistas.CrearEquipoVista   5      W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5      R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      3local!clr-namespace:InfoNBAAdmin.Vistas     5        N� Title$  CrearEquipoVista��5	      .��5      � $��10q�6    � ColumnDefinitions 5   
   �� 5      �� 5       � RowDefinitions 5   
   �� 5      �� 5      �� 5      �� 5      �� 5      �� 5      �� 5      .+�5   
   �� $��0��6   $��0��6"    �� Orientation$ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5      �� $��Nombre ��6   $��Center=�6'   �� 5      -   5         ��Name$ NombreTextBox��5      $��25��6-   $	��150��69   $��10q�6E   5      �� 5   
   $��0��6   $��1��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5      �� $��Campeonatos ��6   $��Center=�6,   �� 5       -   5        $ CampeonatosTextBox��5       $��25��62   $	��150��6>   $��10q�6J   5!      �� 5"   
   $��1��6   $��0��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5#      �� $��Entrenador ��6   $��Center=�6+   �� 5$      -   5        $ EntrenadorTextBox��5$      $��25��61   $	��150��6=   $��10q�6I   5%      �� 5&   
   $��1��6   $��1��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5'      �� $��
Fundacion ��6   $��Center=�6*   �� 5(      -   5        $ FundacionTextBox��5(      $��25��60   $	��150��6<   $��10q�6H   5)      �� 5*   
   $��2��6   $��0��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5+      �� $��Ciudad ��6   $��Center=�6'   �� 5,      -   5        $ CiudadTextBox��5,      $��25��6-   $	��150��69   $��10q�6E   5-      �� 5.   
   $��2��6   $��1��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5/      �� $��Logo ��6   $��Center=�6%   �� 50      -   5        $ LogoTextBox��50      $��25��6+   $	��150��67   $��10q�6C   51      �� 52   
   $��3��6   $��0��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�53      �� $��Color principal ��6   $��Center=�60   �� 54      -   5        $ ColorPrincipalTextBox��54      $��25��65   $	��150��6A   $��10q�6M   55      �� 56   
   $��3��6   $��1��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�57      �� $��Conferencia ��6   $��Center=�6,   �� 58      -   5        $ ConferenciaTextBox��58      $��25��62   $	��150��6>   $��10q�6J   59      �� 5:   
   $��4��6   $��0��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5;      �� $��
Victorias ��6   $��Center=�6*   �� 5<      -	   5        $ VictoriasTextBox��5<      $��25��60   $	��150��6<   $��10q�6H   5=      �� 5>   
   $��4��6   $��1��6"   $ 
Horizontal=�62   $��Center=�6K   $��10q�6h   .+�5?      �� $��	Derrotas ��6   $��Center=�6)   �� 5@      -
   5        $ DerrotasTextBox��5@      $��25��6/   $	��150��6;   $��10q�6G   5A      �� 5B   
   $��5��6   $��2��6"   $ 
Horizontal=�66   $��Center=�6O   $��Center=�6l   $��35��6�   .+�5C      �� $��Estadio ��6   $��Center=�6(   �� 5D      -   5         ��Name$ EstadiosComboBox��5D      $	��100��62    �� DisplayMemberPath$ Nombre��6i   ��6>   ��  �� Path$ ListaEstadios� �� SelectedItem 6�   �� $ EstadioSeleccionado�	 �� UpdateSourceTrigger$	 PropertyChanged=�5E      �� 5F   
   -   5        
 ��Name$
 CrearEquipoButton��5F      $��6��6,   $��2��69   $��Crear Equipo��6M   $��Center=�6d   $	��200��6�   $��10q�6�   6�   5G      5H      