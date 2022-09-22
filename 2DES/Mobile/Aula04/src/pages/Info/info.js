import { View, Text, Image, StyleSheet } from 'react-native';

export default function Info({ route }) {
    var { info } = route.params;

    return (
        <View style={style.container}>
            <Image source={{uri:info.imagem}} style={style.img} />
            <View style={style.content}>
                <Text>Endereço : {info.endereco}</Text>
                <Text>Telefone : {info.telefone}</Text>
            </View>
        </View>
    )
}

const style = StyleSheet.create({
    container: {
      alignItems: 'center',
      justifyContent: 'center',
    },
    content: {
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: '5%',
        width: '100%',
        backgroundColor: 'rgb(53, 152, 227)',
      },
      img: {
        height: '350px',
        width: '100%'
      }
  });