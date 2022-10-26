import { useState } from 'react';
import * as React from 'react';
import { View, Text, StyleSheet, Button, TouchableOpacity } from 'react-native';
import { RadioButton } from 'react-native-paper';
import AsyncStorage from '@react-native-async-storage/async-storage';
import Header from '../../components/headerComponent/component.js';


export default function Quest4({ navigation }) {
   
    const [checked, setChecked] = useState("")

    const salvar = async () => {
        try {
          await AsyncStorage.setItem("Q4", JSON.stringify({checked}))
          setChecked("")
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
                <Text  style={style.titleQ}>Tem alguns sonhos ou memórias de relânce de quando era criança em lugares estranhos cheio de criança/bebês?</Text>
                <View style={style.check}>
                    <Text  style={style.text}>Sim</Text>
                    <RadioButton value="Errada" status={ checked === 'Errada' ? 'checked' : 'unchecked' } onPress={() => setChecked('Errada')} />
                </View>
                <View style={style.check}>
                    <Text  style={style.text}>Não</Text>
                    <RadioButton value="Certa" status={ checked === 'Certa' ? 'checked' : 'unchecked' } onPress={() => setChecked('Certa')} />
                </View>
                <TouchableOpacity style={style.btNext} onPress={() => { 
                    salvar()
                    navigation.navigate('Quest5') }}>
                    <Text  style={style.textBt}>Próxima</Text>
                </TouchableOpacity>
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
    titleQ: {
        fontSize: '20px',
        fontWeight: 'bold',
        marginTop: 30,
    },
    text: {
        fontSize: '20px',
    },
    check: {
        marginTop: 50,
        display: 'flex',
        flexDirection: 'row',
    },
    textBt: {
        fontSize: '25px',
        fontWeight: 'bold',
        color: 'white'
    },
    btNext: {
        marginTop: '50px',
        height: '50px',
        width: '75%',
        backgroundColor: 'rgb(29, 172, 254)',
        alignItems: 'center',
        justifyContent: 'center',
        borderRadius: '15px',
    }
  });