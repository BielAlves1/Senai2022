import { useEffect, useState } from 'react';
import { StyleSheet, Text, Image, View, TextInput } from 'react-native';

export default function App() {
  const [pokemon, setPokemon] = useState([]);

  useEffect(() => {
    fetch("https://pokeapi.co/api/v2/pokemon/1")
    .then(resp => {return resp.json()})
    .then(poke => {
      setPokemon(poke);
    })
  });

  return (
    <View style={styles.container}> 
      {
        (pokemon !== undefined)
        ?
        <View>
          <Image style={styles.imgPoke} source={{uri:pokemon.sprites.front_default}} />
          <Text>{pokemon.name}</Text>
        </View>
        :
        <View>
          <Image source={{uri:"https://acegif.com/wp-content/uploads/loading-48.gif"}} />
        </View>
      }
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  imgPoke: {
    height: '250px',
    width: '250px'
  }
});
