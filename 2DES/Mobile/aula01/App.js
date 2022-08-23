const usuarios = [
  {
  img: require("./assets/random.jfif"),
  nome:"Daniel Cimenton",
  cargo:"admin"
  },
  {
    img:require("./assets/random2.jfif"),
    nome:"Fernando Silva",
    cargo:"developer"
  },
  {
    img:require("./assets/random3.jfif"),
    nome:"Isabela",
    cargo:"comum"
  },
];

import {View, Text, StyleSheet, Image, TextInput, Button, TouchableOpacity} from 'react-native';

export default function App() {
  // const imgGato = require('./assets/gato.jpg');
  // const trashIcon = require('./assets/lixo.png'); 

  return(
    // <View style={style.container}>
    //   <View style={style.primeira}>
    //     <Text>Olá, Mundo!</Text>
    //     <TextInput style={style.input} placeholder="Email"/>
    //     <Button title="Enviar" />
    //     <TouchableOpacity style={style.btExclui}>
    //       <Image style={{width: '32px', height: '32px'}} source={trashIcon} />
    //       <Text>Apagar Registro</Text>
    //     </TouchableOpacity>
    //   </View>
    //   <View style={style.segunda}>
    //     <Text>Minha Segunda View</Text>
    //     <Image style={style.imgAnimal} source={imgGato} />
    //     <Image style={style.imgAnimal} source={{uri:'https://pbs.twimg.com/profile_images/1479284343273140227/jnO7MNMt_400x400.jpg'}} />
    //   </View>
    // </View>
    <View style={style.container}>
      <View style={style.content}>
        {usuarios.map((user) => {
          return (
          <TouchableOpacity style={style.info}>
            <Image style={style.imgUser} source={{uri:user.img}}/>
            <Text>{user.nome}</Text>
            <Text>{user.cargo}</Text>
          </TouchableOpacity>
          );
        })
        }
      </View>
    </View>
  );
}

const style = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  content: {
    flex: 1,
    backgroundColor: '#F1D2E7'
  },
  info: {
    display: 'flex',
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-around',
    backgroundColor: 'gray',
    border: '2px solid black',
    borderRadius: '10px',
  },
  imgUser: {
    width: '100px',
    height: '100px',
    borderRadius: '50px'
  }
  // segunda: {
  //   flex: 4,
  //   backgroundColor: '#E2F5C8'
  // },
  // imgAnimal: {
  //   width: '350px',
  //   height: '350px',
  // },
  // input: {
  //   borderBottomWidth: '1px',
  //   borderBottomColor: 'red',
  //   padding: '10px',
  // },
  // btExclui: {
  //   flexDirection: 'row',
  //   alignItems: 'center',
  //   justifyContent: 'center',
  //   backgroundColor: '#FCFFA6',
  //   border: '2px solid #adffa6',
  //   borderRadius: '10px',
  // }
});