<template>
    <div>
        <NavBar/>
        <h1>Eliminar una Emergencia del Sistema</h1>
        <form id="emergency_delete">
                <div>
                    <label>Id de la Emergencia que quiere Eliminar</label>
                    <input id="id" type="number" min="1" required>
                </div>
                <div>
                    <button type="button" @click="submit">Enviar</button>
                </div>
        </form>
    </div>
    
</template>

<script>
import axios from 'axios';


export default{
    methods:{
        submit:async function(){
            try{
                console.log(id.value);
                var httpConsult = await axios.delete('http://localhost:8080/emergency/' + id.value);
            }catch(error){
                console.log(error);
            }
        }
    }
    
}
</script>