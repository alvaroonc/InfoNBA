   M S B A M L   `   `   `  ����G  CInfoNBAAdmin, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null9!clr-namespace:InfoNBAAdmin.VistasInfoNBAAdmin.Vistas  5      &     InfoNBAAdmin.Vistas.EquiposVista   5      W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5      R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      3local!clr-namespace:InfoNBAAdmin.Vistas     5        N� Title$  EquiposVista��5	       � 	Resources 5
         Button.MouseOver.Background �� Color  Button.MouseOver.Border  Button.Pressed.Background  Button.Pressed.Border  Button.Disabled.Background  Button.Disabled.Border  Button.Disabled.Foreground  ButtonTemplate �� 
TargetType ��Name J� SnapsToDevicePixels �� CornerRadius ��Name �� Triggers	 P� Property
 P� Value �� 
TargetName �� Value �� Property��%  &	        &	 #     &	 F     &	 i     &	 �     &	 �     &	 �     &	 �     7   7  7  7  7  7  7  �� 5   
   $ 	#FFBEE6FD��6>   �� 5   
   $ 	#FF3C7FB1��6:   �� 5   
   $ 	#FFC4E5F6��6<   �� 5   
   $ 	#FF2C628B��68   �� 5   
   $ 	#FFF4F4F4��6=   �� 5   
   $ 	#FFADB2B5��69   �� 5   
   $ 	#FF838383��6=   �� 5   
   " ��61   .R�5      �� $ border��6   #��z��6%   #��z��6O   #��z��6{   $
 true��6�   $ 5��6�   $��	10,0,10,0q�6�   ._�5      �� $ contentPresenter��6#   $|�False��6=   #��z��6O   #��z��6�   $
��True��6�   # z 6�   #��z��6  5       5      P� 5      	 �@��IsDefaulted$

 true��68   . �5      �� $ border��64   # � ��6H    � ��5      P� 5      	 �@J�IsMouseOver$

 true��61   . �5      �� $ border��63   8    � ��6G   �� 5      $ border��64   8   � ��6H   5      P� 5      	 � ��$

 true��6/   . �5      �� $ border��63   8   � ��6G   �� 5       $ border��64   8   � ��6H   5!      P� 5"      	 � {�$
 false��6/   . �5#      �� $ border��63   8   � ��6G   �� 5$      $ border��64   8   � ��6H   �� 5%      $ contentPresenter��6?   8   � ��6]   5&      5(      5)      .��5+      �� 
�������$ 8��6    ._�5,   
   �  � RowDefinitions 5-      �� 5.      $��0.15* �6    �� 5/      .+�51      � $��0��6   $��10q�6     � ColumnDefinitions 52      �� 53      �� 54      �� 55      .+�57      �� -   5         ��Name$ CrearButton��57   E   #���  6   $��Crear��6Z   $��0��6j   6z   �� 58      -   5        $ EditarButton��58   E   #���  6   $��Editar��6[   $��1��6l   6|   �� 59      -   5        $ EliminarButton��59   E   #���  6   $��Eliminar��6]   $��2��6p   6�   5:      � 5;      $��1��6   $��10q�6    .+�5<       � -   5          �Name$ frameContent��5<      $��10q�6.     � NavigationUIVisibility$ Hidden=�6:   5=      5>      5?      5@      