   M S B A M L   `   `   `  ����B  >InfoNBA, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null!clr-namespace:InfoNBAInfoNBA  5   	       InfoNBA.MainWindow   5   	   W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   'localclr-namespace:InfoNBA     5   	     � Title$   ��5   	   $
��1500��6   $	��800��6"    � WindowStartupLocation$ CenterScreen=�5	   	    � 	Resources 5         RadioButtonStyle �� 
TargetType �� Property �� Value �� 
TargetType ��Name � ColumnDefinitions	 �� CornerRadius
 �� RadiusX �� RadiusY J� BitmapEffect F� ShadowDepth F� 	Direction F� Color F� Softness ��Name �� Triggers P� Property P� Value �� 
TargetName  Button.MouseOver.Background �� Color  Button.MouseOver.Border  Button.Pressed.Background  Button.Pressed.Border  Button.Disabled.Background  Button.Disabled.Border  Button.Disabled.Foreground  ButtonTemplate1 J� SnapsToDevicePixels ��Name��%b
  &	        &	 f    &	 �    &	 �    &	 �    &	 �    &	     &	 @    &	 c    7  7  7  7  7  7  7  �� 5   
   " 	�6)   .�5      ��  � ��
 ���� 6+   �� 5       � ��
 �����6+   �� 5       � ��$ Medium"�6+   �� 5       � ��$ 15(�6)   �� 5       � ��$ 40��6'   �� 5       � �� 5      �� 5      " 	�6&   .R�5      �� $ 
menuButton��6!   #��z��5      #��z��5      $	��300��5      ._�5      �  5   "   �� 5   &   $	��25* �67   �� 5   &   $
��127* �67   .+�5   "   �� $ btnSelected��6)   $��0��5    %   $��2��5!   %   $	 10��5"   %   �� 5$   "   $��	Indicator��6,   $
 3��5%   %   $ 3��5&   %   $��10��5'   %   $
��Left=�5(   %    5)   &   F� 5*   *   $ 3Q�5+   -   $ 0Q�5,   -   $ #1d428a��5-   -   $	 0.6Q�5.   -   50   #   �� 52   "   $ txtName��6,   $��	72,9,59,9q�6=   $��1��53   $   #��z��64   #��z��54   $   #��z��55   $   #��z��56   $   57      58       59      P� 5:       �@J�IsMouseOver$
 True��6=   . �5;   "   �� $ txtName��6)    � ��
 �����6T   �� 5<   "   $ btnSelected��6)    � �� �#1d428a6X   5=      P� 5>       �@d�	IsChecked$
 TrueY�6;   . �5?   "   �� $ 	Indicator��6)    � �� �#ffffff6P   �� 5@   "   $ btnSelected��6)    � �� �#1d428a6X   �� 5A   "   $ txtName��6)    � ��
 �����6T   5B      5D      5F      5G      �� 5H   
   $ Transparent��6>   �� 5I   
   $ Transparent��6:   �� 5J   
   $ Transparent��6<   �� 5K   
   $ Transparent��68   �� 5L   
   $ 	#FFF4F4F4��6=   �� 5M   
   $ 	#FFADB2B5��69   �� 5N   
   $ 	#FF838383��6=   �� 5O   
   " ��62   .R�5P      �� $ border��6   #��z��6%   #��z��6O   #��z��6{   $
 true��6�   ._�5Q      �� $ contentPresenter��6#   $|�False��6=   #��z��6O   #��z��6�   $
��True��6�   # z 6�   #��z��6  5R       5S      P� 5T       �@��IsDefaulted$
 true��68   . �5U      �� $ border��64   # � ��6H    � ��5V      P� 5W       �@J�IsMouseOver$
 true��61   . �5X      �� $ border��63   8    � ��6G   �� 5Y      $ border��64   8   � ��6H   5Z      P� 5[       � ��$
 true��6/   . �5\      �� $ border��63   8   � ��6G   �� 5]      $ border��64   8   � ��6H   5^      P� 5_       � {�$ false��6/   . �5`      �� $ border��63   8   � ��6G   �� 5a      $ border��64   8   � ��6H   �� 5b      $ contentPresenter��6?   8   � ��6]   5c      5e      5f      .��5h      �  5i   
   �� 5j      $
��0.3* �6   �� 5k      $��* �6   .+�5n   
   � $��0��6   
���   �.+�5o      �� $��10q�6    �� Orientation$ Vertical=�6%   .+�5q      �� -   5         ��Name$ InfoNBAButton��5q   F   #���  6   
������ 
������ .��5r      �� $��50(�6    $
��Bold"�6.   $��10q�6@   $��Center=�6L   ��5s      �� 5t      .��5u   "   �  � Color$ #1d428a��6/    � Offset$ 0Q�6?   � 5v   "   $ #c8102e��6/   $ 1Q�6?   5w      	InfoNBA5z      5{      �� 5}      $ Vertical=�6   $��10q�64   .+�5~      	� -   5         	�Name$ EquiposRadio��5~   "   $��Equipos��68   #��[  6d   	� 5      -   5        $ JugadoresRadio��5   "   $��	Jugadores��6:   #��[  6j   	� 5�      -   5        $ PartidosRadio��5�   "   $��Partidos��69   #��[  6g   	� 5�      -   5        $ EstadiosRadio��5�   "   $��Estadios��69   #��[  6g   	� 5�      -   5        $ ClasificacionRadio��5�   "   $��Clasificación��6>   #��[  6V   6�   5�      5�      5�      � 5�   
   $��1��6   ��5�      �� 5�      .��5�      � $ #1d428a��6#   $ 0Q�63   � 5�      $ #c8102e��6#   $ 1Q�63   5�       5�      �� 5�      $��* �6#    � RowDefinitions 5�      �� 5�      $��* �6    .+�5�       � -   5          �Name$ frameContent��5�      $��25q�6*      � NavigationUIVisibility$  Hidden=�66   5�      5�      5�      