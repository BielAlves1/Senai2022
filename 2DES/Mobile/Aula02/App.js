import {useState} from 'react';
import {View, Button, Text, TouchableOpacity, TextInput, Image, StyleSheet, CheckBox} from 'react-native';

export default function App() {
  const [value, setValue] = useState("");
  const [value2, setValue2] = useState("");
  const [soma, setSoma] = useState(false);
  const [sub, setSub] = useState(false);
  const [div, setDiv] = useState(false);
  const [mult, setMult] = useState(false);
  const [result, setResult] = useState("");

  return (
    <View style={style.container}>
      {/* <TextInput style={style.inputzin}  onChangeText={(val) => { setValue(Number(val)); }} />
      <TextInput style={style.inputzin} onChangeText={(val) => { setValue2(Number(val)); }} /> */}
      {/* <TouchableOpacity >
        <Text onPress={() => {setSoma(value + value2); }}>Calcular</Text>
      </TouchableOpacity>
        <Text>{soma}</Text> */}
        <TextInput style={style.inputzin}  onChangeText={(val) => { setValue(Number(val)); }} />
        <TextInput style={style.inputzin}  onChangeText={(val) => { setValue2(Number(val)); }} />
        <View style={style.sinais}>
          <TouchableOpacity>
            <CheckBox style={style.soma} value={soma} onValueChange={setSoma} />
          </TouchableOpacity>

          <TouchableOpacity>
            <CheckBox style={style.sub} value={sub} onValueChange={setSub} />
          </TouchableOpacity>

          <TouchableOpacity>
            <CheckBox style={style.div} value={div} onValueChange={setDiv}/>
          </TouchableOpacity>

          <TouchableOpacity>
            <CheckBox style={style.mult} value={mult} onValueChange={setMult}/>
          </TouchableOpacity>
        </View>
        <Button style={style.btCalc} title="CALCULAR " onPress={() => {
          if(soma == true) {
            setResult(value + value2);
            
          }else if(sub == true) {
            setResult(value - value2);
          }else if(div == true){
            setResult(value / value2);
          }else if(mult == true){
            setResult(value * value2);
          }else{
            alert("Selecione uma das operaçõe matemáticas")
          }
        }} />

        <Text>{result}</Text>
    </View>
  );
}

const style = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  sinais: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    flexDirection: 'row',
  }
});