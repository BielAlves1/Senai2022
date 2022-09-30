import {TouchableOpacity, Text} from 'react-native';

import styles from './style.js';

export default function BtFiltrar(props) {
    const { value, onPress } = props;

    return(
        <TouchableOpacity style={styles.btLogin} onPress={()=>{onPress()}}>
            <Text style={styles.texto}>{value}</Text>
        </TouchableOpacity>
    )
}