<template>
    <div>
        <NavBar/>
        <h1>Registrar una Emergencia en el Sistema</h1>
        <form id="emergency_input">
            <div id="name_input">
                <label>Nombre de la emergencia</label>
                <input type="text" id="name" v-model="emergency.name" required>
            </div>
            <div id="addr_input">
                <label>Direccion de la emergencia</label>
                <input type="text" id="addr" v-model="emergency.addr" required>
            </div>
            
            <div id="description_input">
                <label class="description_label">Descripcion de la emergencia:</label>
                <textarea cols="40" rows="10" id="description" v-model="emergency.description" required></textarea>
            </div>
            <div id="submit_button">
                <button type="button" @click="submit" >Enviar</button>
            </div>
        </form>
    </div>
</template>>

<script>
import axios from 'axios';
import NavBar from '~/components/NavBar.vue';

export default{
    data() {
        return {
            emergency: {}
        };
    },
    methods: {
        submit: async function () {
            try {
                var httpConsult = await axios.post("http://localhost:8080/emergency", this.emergency);
            }
            catch (error) {
                console.log("error", error);
            }
        }
    },
    components: { NavBar }
}
</script>

<style scoped>
    label.description_label{
        display: flex;
        vertical-align: middle;
    }

    textarea{
        resize:none;
    }
</style>