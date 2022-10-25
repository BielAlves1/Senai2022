import {Image, Text, View} from 'react-native';

import styles from './style.js';

export default function Header(props) {

    return(
        <View style={styles.header}>
            <Text style={styles.title}>Descubra se você é Adotado!</Text>
            <Image source={{uri:'http://wikicti.tjmt.jus.br/images/6/62/Logo_Adotar_e_Legal.png'}} style={styles.img} />
        </View>
    )
}