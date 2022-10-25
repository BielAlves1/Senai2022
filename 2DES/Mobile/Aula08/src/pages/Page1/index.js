import * as React from 'react';
import { View, Text, StyleSheet, Image } from 'react-native';
import { RadioButton } from 'react-native-paper';
import AsyncStorage from '@react-native-async-storage/async-storage';


export default function Quest1({ navigation }) {
    const [checked, setChecked] = React.useState('');

    const salvar = async () => {
        try {
          await AsyncStorage.setItem("data", JSON.stringify({checked}))
          setChecked("")
        } catch (err) {
          console.log(err)
        }
      }

    return (
        <View style={style.container}>
            <View style={style.content}>
                <Text  style={style.titleQ}>Você é parecido com algum dos seus pais ou parecido com ambos?</Text>
                <View style={style.check}>
                    <Text  style={style.text}>Sim</Text>
                    <RadioButton value="resp" status={ checked === 'resp' ? 'checked' : 'unchecked' } onPress={() => setChecked('resp')} />
                </View>
                <View style={style.check}>
                    <Text  style={style.text}>Não</Text>
                    <RadioButton value="err" status={ checked === 'err' ? 'checked' : 'unchecked' } onPress={() => setChecked('err')} />
                </View>
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
    btInicio: {
        marginTop: '50px',
        height: '50px',
        width: '75%',
        backgroundColor: 'rgb(29, 172, 254)',
        alignItems: 'center',
        justifyContent: 'center',
        borderRadius: '15px',
    }
  });