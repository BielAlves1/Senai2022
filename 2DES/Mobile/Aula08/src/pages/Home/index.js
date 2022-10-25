import { View, Text, StyleSheet, Image, Button, TouchableOpacity } from 'react-native';
import Header from '../../components/headerComponent/component.js';


export default function Home({ navigation }) {
    return (
        <View style={style.container}>
            {
                <Header />
            }
            <View style={style.content}>
                <TouchableOpacity style={style.btInicio} onPress={() => { navigation.navigate('Quest1') }}>
                    <Text  style={style.text}>Iniciar Quiz</Text>
                </TouchableOpacity>
            </View>
        </View>
    )
}

const style = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
    },
    content: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: '5%',
        width: '100%'
      },
    text: {
        fontSize: '25px',
        fontWeight: 'bold',
        color: 'white'
    },
    btInicio: {
        height: '50px',
        width: '75%',
        backgroundColor: 'rgb(29, 172, 254)',
        alignItems: 'center',
        justifyContent: 'center',
        borderRadius: '15px',
    }
  });