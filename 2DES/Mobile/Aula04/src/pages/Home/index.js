import { View, Text, StyleSheet, TouchableOpacity } from 'react-native';

export default function Home({ navigation }) {
    const restaurantes = [
        {
            "nomeRes":"Good Chef",
            "nota":8,
            "info":{
                "imagem":"https://img.freepik.com/vetores-premium/modelo-de-design-de-logotipo-de-restaurante-good-chef_25572-210.jpg?w=2000",
                "endereco":"Rua Antonio Fanti, 173",
                "telefone":"(19) 99867-6565"
            }
        },
        {
            "nomeRes":"Sabor de Minas",
            "nota":10,
            "info":{
                "imagem":"https://scontent-gru1-1.xx.fbcdn.net/v/t39.30808-6/305766926_490372559763483_372108829752049314_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=yrBquGyjd_oAX8YbBhi&_nc_ht=scontent-gru1-1.xx&oh=00_AT9c0vp0OSKZd9cYZTgNoXBfHJz8m0F7SB3ke5dymuSzOw&oe=63307F1A",
                "endereco":"Rua José Serra, 542",
                "telefone":"(19) 99867-7456"
            }
        },
        {
            "nomeRes":"Fartura",
            "nota":6,
            "info":{
                "imagem":"https://farturaculinaria.com.br/wp-content/uploads/2022/06/logo-Fartura-520fbx.png.webp",
                "endereco":"Rua Angelo Lima, 231",
                "telefone":"(19) 99976-3754"
            }
        }
    ];


    return(
        <View style={style.container}>
            <Text style={style.title}>Restaurantes</Text>
            {
                restaurantes.map((rest, indice) => {
                    return(
                        <TouchableOpacity key={indice} onPress={() => {navigation.navigate("Info", { "info":rest.info} )}} style={style.content}>
                            <Text style={style.texto}>{rest.nomeRes}</Text>
                            <Text style={style.texto}>Nota: {rest.nota}</Text>
                        </TouchableOpacity>
                    )
                })
            }
        </View>
    )
}

const style = StyleSheet.create({
    container: {
        flex: 1,
      alignItems: 'center',
      justifyContent: 'center',
      width: '100%',
      backgroundColor: 'rgb(88, 170, 233)'
    },
    title: {
        fontWeight: 'bold',
        fontSize: "30px",
    },
    content: {
        marginTop: "10%",
        height: "100px",
        width: "75%",
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: 'rgb(36, 134, 209)',
        borderRadius: '50px',
        border: '3px solid rgb(140, 198, 242)',
        boxShadow: '1px 3px black'
    },
    texto: {
        color: "white",
        fontSize: "20px"
    }
  });