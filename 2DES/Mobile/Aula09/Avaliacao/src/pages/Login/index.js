import { useState } from 'react';
import { StyleSheet, View, Text, TextInput, Button, Image, TouchableOpacity } from 'react-native';

const dog = require('../../../assets/dog.png');

export default function Login({navigation}) {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const users = [
        {
            "email":"fulano@gmail.com",
            "senha":"umdoistresquatro",
        },
        {
            "email":"beltrano@ig.com.br",
            "senha":"s3nh4",
        }
    ];

    const Logar = () => {
        users.forEach(user => {
            if(user.email === email && user.senha === password) navigation.navigate("Home");
        })
    }

    return(
        <View style={style.container}>
            <Image style={style.imgDog} source={{uri:dog}} />
    
            <TextInput style={style.inputzin} placeholder='Informe o seu Email' placeholderTextColor={"#00000077"} onChangeText={(value) => {setEmail(value)}} />
            <TextInput style={style.inputzin} placeholder='Informe a sua Senha' placeholderTextColor={"#00000077"} secureTextEntry={true} onChangeText={(value) => {setPassword(value)}} />

            <TouchableOpacity style={style.btLogin} onPress={()=>{Logar()}}>
                <Text style={style.text}>Conectar</Text>
            </TouchableOpacity>

        </View>
    )
}

const style = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#505050',
        width: '100%',
        alignItems: 'center',
        justifyContent: 'center'

    },
    imgDog: {
        height: '250px',
        width: '250px',
        borderRadius: '50px',
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 12,
        },
        shadowOpacity: 0.58,
        shadowRadius: 16.00,
        elevation: 24,
    },
    inputzin: {
        marginTop: '5%',
        height: '50px',
        width: '75%',
        backgroundColor: '#EFEFEF',
        borderRadius: '10px',
        padding: '20px',
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 12,
        },
        shadowOpacity: 0.58,
        shadowRadius: 16.00,
        elevation: 24,
      },
    btLogin: {
        marginTop: '20px',
        height: '50px',
        width: '75%',
        backgroundColor: '#7242F5',
        alignItems: 'center',
        justifyContent: 'center',
        borderRadius: '10px',
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 12,
        },
        shadowOpacity: 0.58,
        shadowRadius: 16.00,
        elevation: 24,
      },
    text: {
        fontWeight: 'bold',
        fontSize: "25px",
        color: 'white'
        }
});