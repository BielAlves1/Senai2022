import { useState } from 'react';
import { View, Text, StyleSheet, Button, TouchableOpacity } from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';
import Header from '../../components/headerComponent/component.js';


export default function Result({ navigation }) {

    const [lida, setLida] = useState("")

    const ler = async () => {
        try {
            const jsonResp1 = await AsyncStorage.getItem('Q1')
            const jsonResp2 = await AsyncStorage.getItem('Q2')
            const jsonResp3 = await AsyncStorage.getItem('Q3')
            const jsonResp4 = await AsyncStorage.getItem('Q4')
            const jsonResp5 = await AsyncStorage.getItem('Q5')

            let resposta1 = jsonResp1 != null ? JSON.parse(jsonResp1) : null;
            let resposta2 = jsonResp2 != null ? JSON.parse(jsonResp2) : null;
            let resposta3 = jsonResp3 != null ? JSON.parse(jsonResp3) : null;
            let resposta4 = jsonResp4 != null ? JSON.parse(jsonResp4) : null;
            let resposta5 = jsonResp5 != null ? JSON.parse(jsonResp5) : null;


            let resp = 'Certa'

            if ((resposta1.checked == resp) && (resposta2.checked == resp) && (resposta3.checked == resp) && 
            (resposta4.checked == resp) && (resposta5.checked == resp)) {
                setLida(
                    <View>
                        <Text style={style.textResult}>VOCÊ NÃO É ADOTADO OK</Text>
                    </View>
                )
            }else {
                setLida(
                    <View>
                        <Text style={style.textResult}>VOCÊ É ADOTADOKKKKKKKKKKK</Text>
                    </View>
                )
            }
        } catch (err) {
            console.log(err)
        }
    }

    return (
        <View style={style.container}>
            {
                <Header />
            }
            <View style={style.content}>
                <TouchableOpacity style={style.btResult} onPress={() => {ler()}}>
                    <Text  style={style.textBt}>Ver Resultado</Text>
                </TouchableOpacity>
                <View>{lida}</View>
            </View>
        </View>
    );
}

const style = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
    },
    img: {
        height: '350px',
        width: '300px',
        borderRadius: '20px',
    },
    content: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: '5%',
        width: '100%'
    },
    textResult: {
        fontSize: '25px',
        fontWeight: 'bold',
        marginTop: 30,
    }, 
    textBt: {
        fontSize: '25px',
        fontWeight: 'bold',
        color: 'white'
    },
    btResult: {
        marginTop: '50px',
        height: '50px',
        width: '75%',
        backgroundColor: 'rgb(29, 172, 254)',
        alignItems: 'center',
        justifyContent: 'center',
        borderRadius: '15px',
    }
});