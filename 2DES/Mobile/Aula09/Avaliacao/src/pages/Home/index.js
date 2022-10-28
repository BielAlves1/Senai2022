import { View, Text, Image, StyleSheet, TouchableOpacity } from 'react-native';

const arq = require('../../../assets/arquivo.png');
const vacina = require('../../../assets/vacinacao.png');

export default function Home({navigation}) {

    const goHist = () => {
        navigation.navigate("Historico")
    }

    const goReg = () => {
        navigation.navigate("Registro")
    }

    return(
        <View style={style.container}>
            <TouchableOpacity style={style.content} onPress={() => {goHist()}}>
                <Image style={style.img} source={{uri:arq}} />
                <Text style={style.text}>Histórico de Vendas</Text>
            </TouchableOpacity>
            <TouchableOpacity style={style.content} onPress={() => {goReg()}}>
                <Image style={style.img} source={{uri:vacina}} />
                <Text style={style.text}>Registrar Vacina</Text>
            </TouchableOpacity>
        </View>
    )
}

const style = StyleSheet.create({
    container: {
        backgroundColor: '#505050',
        width: '100%',
        height: '100%',
        flexDirection: 'row',
        justifyContent: 'center',
    },
    content: {
        marginTop:'5%',
        margin: '2%',
        backgroundColor: '#EFEFEF',
        borderRadius: '25px',
        alignItems: 'center',
        justifyContent: 'center',
        height: '200px',
        width: '175px',
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 12,
        },
        shadowOpacity: 0.58,
        shadowRadius: 16.00,
        elevation: 24
    },
    img: {
        height: '50px',
        width: '50px'
    },
    text: {
        marginTop: '25%',
        fontWeight: 'bold',
        color: '#8A66FA'
    }
});