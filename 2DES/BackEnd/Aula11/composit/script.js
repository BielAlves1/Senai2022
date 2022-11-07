class Pizza {
    constructor(sabor, precoU) {
        this.sabor = sabor; 
        this.precoU = precoU;
    }

    toString() {
        return this.sabor + ' ' + this.precoU;
    }
}

class Pedido extends Pizza{
    constructor(sabor, precoU, data, hora, subTotal, valTotal){
        super(sabor, precoU);
        this.data = data;
        this.hora = hora;
        this.subTotal = subTotal;
        this.valTotal = valTotal;
    }

    get

    toString() {
        return super.toString() + ' ' + this.data + ' ' + this.hora + ' ' + this.subTotal + ' ' + this.valTotal;
         0
    }
}