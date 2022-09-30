import { View, StyleSheet, TextInput } from 'react-native';

export default function Home() {
    const chamados = [
        {
            "user_id": 1,
            "chamados": [
                {
                    "titulo":"Manutenção de Roteador",
                    "descricao":"Cliente reclamou que está sem internet, possível troca"
                },
                {
                    "titulo":"Mudança de Endereço",
                    "descricao":"Fazer a instalação na nova instalação"
                },
                {
                    "titulo":"Recolher equipamento",
                    "descricao":"Assinatura Cancelada, recolher os equipamentos da instalação"
                }
            ]
        },
        {
            "user_id": 2,
            "chamados": [
                {
                    "titulo":"Recolher equipamento",
                    "descricao":"Assinatura Cancelada, recolher os equipamentos da instalação"
                },
                {
                    "titulo":"Mudança de Endereço",
                    "descricao":"Fazer a instalação na nova instalação"
                },
                {
                    "titulo":"Manutenção de Roteador",
                    "descricao":"Cliente reclamou que está sem internet, possível troca"
                }
            ]
        }
    ]

    return(
        <View style={style.container}>
            <TextInput style={style.inputzao} placeholder='Filtrar' />
            
        </View>
    )
}

const style = StyleSheet.create({
    container: {
        alignItems: 'center',
        justifyContent: 'center',
        width: '100%'
    },
    inputzao: {
        marginTop: '20px',
        height: '50px',
        width: '75%',
        backgroundColor: 'white',
        borderRadius: '15px',
        boxShadow: '1px 1px #7242F5',
        padding: '20px',
        fontWeight: 'bold',
        fontSize: "20px",
        color: '#7242F5'
      }
});