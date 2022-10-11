import { View, StyleSheet, Image, TextInput, Text, TouchableOpacity } from 'react-native';

export default function Home( {navigation} ) {
    const pizzas = [
        {
            "img": "http://www.saboresajinomoto.com.br/uploads/images/recipes/pizza-de-atum-e-mussarela.jpg",
            "nome": "Atum com Muçarela",
            "descricao": "Deliciosa pizza com atum e muita muçarela!!"
        },
        {
            "img": "https://img.freepik.com/fotos-premium/close-up-de-uma-pizza-de-milho-com-borda-recheada-em-uma-mesa-de-madeira-clara_311379-1220.jpg?w=2000",
            "nome": "Milho",
            "descricao": "A favorita da criançada!!!"
        },
        {
            "img": "https://pizzariadesucesso.com/wp-content/uploads/2018/05/foto_pizza_baiana_600x402.jpg",
            "nome": "Baiana",
            "descricao": "Muita calabresa, tomate e cebola!!"
        },
        {
            "img": "https://pos.motorburguer.com.br/wp-content/uploads/2021/01/frango-catupiry.jpg",
            "nome": "Frango com Catupiry",
            "descricao": "A queridinha franga com catupiry!"
        },
        {
            "img": "https://coopatos.com.br/images/media-grande/dominos-pizza-mussarela-imprensa-handam.jpg",
            "nome": "Muçarela",
            "descricao": "Tradicional queijuda"
        },
        {
            "img": "https://i0.wp.com/saudevidatotal.com/wp-content/uploads/2018/08/Pizza-Calabresa..jpg?fit=720%2C480&ssl=1",
            "nome": "Calabresa",
            "descricao": "Deliciosa pizza de calabresa!"
        },
        {
            "img": "https://static.clubedaanamariabraga.com.br/wp-content/uploads/2020/08/pizza-margherita.jpg?x41527",
            "nome": "Margherita",
            "descricao": "Tradicional também, bambino"
        },
        {
            "img": "https://storage.googleapis.com/domain-images/208da95b-9928-4d84-97a8-da8a585d125d/products/gallery_2e04d625-91a7-4958-870d-69596aa6f8b2.jpg",
            "nome": "Lombo com muçarela",
            "descricao": "Minha favorita, vale mais que mil palavras!!!"
        },
        {
            "img": "https://riopardolaticinio.com.br/wp-content/uploads/2022/02/pizza4queijos-1024x819.jpg",
            "nome": "Quatro queijos",
            "descricao": "Queijo demais, muito bom"
        },
        {
            "img": "https://img.freepik.com/fotos-premium/pizza-brasileira-com-mussarela-estrogonofe-de-carne-e-palitos-de-batata-pizza-de-strogonoff-de-carne_311876-446.jpg?w=2000",
            "nome": "Strogonoff",
            "descricao": "Para os exóticos!"
        }
    ]

    return(
        <View style={style.container}>
            {
                pizzas.map((pizza, index) => {
                    return(
                        <View style={style.content} key={index}>
                            <View style={style.infoP}>
                                <Image source={{uri:pizza.img}} style={style.imgPizza} />
                                <Text style={style.title}>{pizza.nome}</Text>
                                <Text>{pizza.descricao}</Text>
                            </View>

                            <TouchableOpacity>
                                <Image source={{uri:"https://cdn-icons-png.flaticon.com/512/2740/2740600.png"}} style={style.imgAdd} />
                            </TouchableOpacity>
                        </View>
                    )
                })
            }
        </View>
    )
}

const style = StyleSheet.create({
    container: {
        width: '100%',
        justifyContent: 'center'

    },
    content: {
        
    },
    imgPizza: {
        height: '50px',
        width: '50px',
        borderRadius: '50px'
    },
    imgAdd: {
        height: '35px',
        width: '35px',
        borderRadius: '50px'
      },
      title: {
        fontWeight: 'bold',
        fontSize: "20px",
      }
});