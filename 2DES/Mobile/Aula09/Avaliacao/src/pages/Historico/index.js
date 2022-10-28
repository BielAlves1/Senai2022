import { useState } from 'react';
import { View, Text, TextInput, StyleSheet, ScrollView } from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';

export default function Historico() {
    const [registro, setRegistro] = useState([]);
    const [busca, setBusca] = useState("");

    const read = async () => {
        try {
            let registros = await AsyncStorage.getItem("registro");

            if (registros !== null) setRegistro(JSON.parse(registros));
        } catch (err) {
            console.log(err);
        }
    }

    if (registro.length == 0) read();

    return (

        <View style={style.container}>
            <ScrollView>
                <View style={style.content}>
                <TextInput style={style.inputzin} placeholder='Digite para buscar...' placeholderTextColor={"#00000077"} onChangeText={(val) => { setBusca(val) }}   />
                    {
                        registro.map((info, index) => {
                                return (
                                    <View style={style.regis} key={index}>
                                        <Text style={style.text}>PET: {info.pet}</Text>
                                        <Text style={style.text}>Veterinário: {info.vet}</Text>
                                        <Text style={style.text}>Vacina: {info.vacina}</Text>
                                        <Text style={style.text}>Data: {info.data}</Text>
                                    </View>
                                    )
                                })
                    }
                </View>
            </ScrollView>
        </View>
    )
}

const style = StyleSheet.create({
    container: {
        backgroundColor: '#505050',
        width: '100%',
        height: '100%',
    },
    inputzin: {
        marginTop: '5%',
        height: '50px',
        width: '90%',
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
    content: {
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center'
    },
    regis: {
        marginTop: '5%',
        margin: '2%',
        borderRadius: '10px',
        height: '200px',
        width: '90%',
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 12,
        },
        shadowOpacity: 0.58,
        shadowRadius: 16.00,
        elevation: 24
    },
    text: {
        fontWeight: 'bold',
        color: 'white',
    }
});