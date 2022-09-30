import { useState } from 'react';
import { View, Text, StyleSheet, Image, TextInput } from 'react-native';
import BtLogar from '../../components/buttonLog/component.js';

export default function Login({ navigation }) {
    const img = require('../../../assets/logo.png');
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const users = [
        {
            "id": 1,
            "email": "user01@empresa.com",
            "senha": "teste1234",
        },
        {
            "id": 2,
            "email": "user02@empresa.com",
            "senha": "1234teste",
        }
    ]

    const logar = () => {
        let validando = false
        users.forEach(user => {
            if(email == user.email && senha == user.senha) {
                validando = true
            }
        })

        if(validando){
            navigation.navigate('Home')
        }
    }

    return (
        <View style={style.container}>
            <Image source={{uri:img}} style={style.img} />
            <View style={style.content}>
                <TextInput style={style.inputzin} placeholder='E-Mail' onChangeText={(val) => { setEmail(val) }} />
                <TextInput style={style.inputzin} placeholder='Senha' onChangeText={(val) => { setSenha(val) }}/>
                <BtLogar value="Login" onPress={logar}/>
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
    img: {
        height: '150px',
        width: '150px'
      },
    content: {
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: '5%',
        width: '100%'
      },
      inputzin: {
        marginTop: '20px',
        height: '50px',
        width: '75%',
        backgroundColor: 'white',
        borderRadius: '15px',
        boxShadow: '1px 1px #7242F5',
        padding: '20px'
      }
  });