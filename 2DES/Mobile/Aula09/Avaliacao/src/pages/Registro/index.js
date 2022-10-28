import { useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, TextInput } from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';

export default function Registro({ navigation }) {
    const [pet, setPet] = useState("");
    const [vet, setVet] = useState("");
    const [vacina, setVacina] = useState("");
    const [data, setData] = useState("");

    const registros = [
        {
            "nomePet": "Bichano",
            "nomeVet": "Fulano",
            "vacina": "Vacinarius",
            "data": "27/10/2022"
        },
        {
            "nomePet": "Fofurinha",
            "nomeVet": "Beltrano",
            "vacina": "Vacininha",
            "data": "28/10/2022"
        },
        {
            "nomePet": "Raivoso",
            "nomeVet": "Malunquio",
            "vacina": "Astravac",
            "data": "30/05/2023"
        }
    ]

    let form = {
        pet,
        vet,
        vacina,
        data
    }

    const Registrar = async () => {
        try {
            let info = await AsyncStorage.getItem("registro");
            if(info !== null) {
                info = JSON.parse(info);
                info.push(form);
            }else {
                info = new Array(form);
            }

            await AsyncStorage.setItem("registro", JSON.stringify(info));

            navigation.navigate("Historico")
        }catch(e) {
            console.log(e);
        }
    }

    return (
        <View style={style.container}>
            <View style={style.content}>
                <TextInput style={style.inputzin} placeholder='Nome do Pet' placeholderTextColor={"#00000077"} onChangeText={(value) => { setPet(value) }} />
                <TextInput style={style.inputzin} placeholder='Nome do Médico Veterinário' placeholderTextColor={"#00000077"} onChangeText={(value) => { setVet(value) }} />
                <TextInput style={style.inputzin} placeholder='Nome da Vacina' placeholderTextColor={"#00000077"} onChangeText={(value) => { setVacina(value) }} />
                <TextInput style={style.inputzin} placeholder='Data da Aplicação' placeholderTextColor={"#00000077"} onChangeText={(value) => { setData(value) }} />
                <TouchableOpacity style={style.btLogin} onPress={() => { Registrar(); navigation.navigate("Historico")}}>
                    <Text style={style.text}>Registrar</Text>
                </TouchableOpacity>
            </View>
        </View>
    )
}

const style = StyleSheet.create({
    container: {
        backgroundColor: '#505050',
        width: '100%',
        height: '100%',
    },
    content: {
        alignItems: 'center',
        flexDirection: 'column',
        justifyContent: 'center',
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