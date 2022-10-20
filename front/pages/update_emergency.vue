<template>
    <div>
        <NavBar/>
        <h1>Actualizar una Emergencia en el Sistema</h1>
        <form id="update_emergency_input">
            <div id="id">
                <label>Id de la Emergencia a Modificar</label>
                <input type="number" min="1" v-model="emergency.id" required>
            </div>
            <div id="name">
                <label>Nombre de la Emergencia</label>
                <input type="text" v-model="emergency.name" required>
            </div>
            <div id="addr">
                <label>Direccion de la Emergencia</label>
                <input type="text" v-model="emergency.addr" required>
            </div>
            <div id="description">
                <label class="description_label">Descripcion de la Emergencia</label>
                <textarea cols="40" rows="10" v-model="emergency.description" required></textarea>
            </div>
            <div id="submit">
                <button type="button" @click="submit">Enviar</button>
            </div>
        </form>
        
    </div>
    
</template>

<script>
import axios from 'axios';

export default{
    data(){
        return{
            emergency:{}
        }
    },
    methods:{
        submit:async function(){
            try{
                var httpConsult = await axios.put('http://localhost:8080/emergency/' + this.emergency.id,this.emergency);
                console.log("enviado correctamente");
            }catch(error){
                console.log(error);
            }
        }
    }
}

</script>

<style scoped>
label.description_label{
        display: flex;
        vertical-align: middle;
    }
</style>