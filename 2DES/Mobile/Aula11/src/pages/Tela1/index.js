import { View, Text, StyleSheet, TouchableOpacity } from 'react-native';

export default function Tela1() {
    return(
        <View style={style.container}>
            <Text>TELA 1</Text>
        </View>
    )
}

const style = StyleSheet.create({
    container: {
        alignItems: 'center',
        width: '100%',
        height: '100%',
        flexDirection: 'row',
        justifyContent: 'center',
    }
});