import { View, Text, Button, TouchableOpacity } from 'react-native';

export default function Segunda({ navigation }) {
    const restaurantes = [
        {
            "nomeRes":"BigFrag",
            "nota":10,
            "info":{
                "imagem":"",
                "endereco":"Rua Antonio Fanti, 173",
                "telefone":"(19) 99867-6565"
            }
        },
        {
            "nomeRes":"Sabor de Minas",
            "nota":10,
            "info":{
                "imagem":"",
                "endereco":"Rua José Serra, 542",
                "telefone":"(19) 99867-7456"
            }
        },
        {
            "nomeRes":"Restaurante Plaza",
            "nota":5,
            "info":{
                "imagem":"",
                "endereco":"Rua Angelica Lima, 231",
                "telefone":"(19) 99976-3754"
            }
        }
    ];


    return(
        <View>
            {
                produtos.map((rest, indice) => {
                    return(
                        <TouchableOpacity onPress={() => {navigation.navigate("Info", { "info":rest.info} )}}>
                            <Text> {rest.nomeRes}</Text>
                            <Text>{rest.nota}</Text>
                        </TouchableOpacity>
                    )
                })
            }
        </View>
    )
}