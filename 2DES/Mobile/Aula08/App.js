import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import Home from './src/pages/Home/index.js';
import Quest1 from './src/pages/Page1/index.js';
import Quest2 from './src/pages/Page2/index.js';
import Quest3 from './src/pages/Page3/index.js';
import Quest4 from './src/pages/Page4/index.js';
import Quest5 from './src/pages/Page5/index.js';
import Result from './src/pages/Result/index.js';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={Home} />
        <Stack.Screen name="Quest1" component={Quest1} />
        <Stack.Screen name="Quest2" component={Quest2} />
        <Stack.Screen name="Quest3" component={Quest3} />
        <Stack.Screen name="Quest4" component={Quest4} />
        <Stack.Screen name="Quest5" component={Quest5} />
        <Stack.Screen name="Result" component={Result} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
