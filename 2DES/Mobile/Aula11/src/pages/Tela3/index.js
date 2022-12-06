import { View, Text, StyleSheet, TouchableOpacity } from 'react-native';

export default function Tela3() {
    return(
        <View style={style.container}>
            <Text>TELA 3</Text>
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