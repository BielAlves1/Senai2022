import { View, Text } from 'react-native';

export default function Descricao({ route }) {
    var {info} = route.params;

    return(
        <View>
            <Text>imagem : {info.imagem}</Text>
            <Text>endereco : {info.endereco}</Text>
        </View>
    )
}