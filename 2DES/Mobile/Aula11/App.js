import { NavigationContainer } from '@react-navigation/native';
import { createMaterialBottomTabNavigator } from '@react-navigation/material-bottom-tabs';
import { createDrawerNavigator } from '@react-navigation/drawer';
import { MaterialCommunityIcons } from '@expo/vector-icons';

const Tab = createMaterialBottomTabNavigator();
const Drawer = createDrawerNavigator();

import Tela1 from './src/pages/Tela1/index.js';
import Tela2 from './src/pages/Tela2/index.js';
import Tela3 from './src/pages/Tela3/index.js';

export default function App() {
  return (
    <NavigationContainer>
      <Drawer.Navigator initialRouteName="Home">
        <Drawer.Screen name="TelaUm" component={Tela1} />
        <Drawer.Screen name="TelaDois" component={Tela2} />
        <Drawer.Screen name="TelaTres" component={Tela3} />
      </Drawer.Navigator>

      {/* <Tab.Navigator initialRouteName="Tela1" activeColor="#328ECB" barStyle={{ backgroundColor: 'white' }}>
        <Tab.Screen name="Tela1" component={Tela1}
          options={{
            tabBarLabel: 'Home',
            tabBarIcon: ({ color }) => (
              <MaterialCommunityIcons name="home" color={color} size={26} />
            ),
          }} />

        <Tab.Screen name="Tela2" component={Tela2}
          options={{
            tabBarLabel: 'Notificação',
            tabBarIcon: ({ color }) => (
              <MaterialCommunityIcons name="bell" color={color} size={26} />
            ),
          }} />

        <Tab.Screen name="Tela3" component={Tela3}
          options={{
            tabBarLabel: 'Perfil',
            tabBarIcon: ({ color }) => (
              <MaterialCommunityIcons name="account" color={color} size={26} />
            ),
          }} />
      </Tab.Navigator> */}
    </NavigationContainer>
  );
}
