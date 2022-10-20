<template>
    <div>
        <NavBar/>
        <h1>Emergencias En el Sistema</h1>
        <ul>
            <li v-for="(emergency,index) in emergencies" :key="index">
                <p>id: {{emergency.id}} </p>
                <p>Nombre: {{emergency.name}} </p>
                <p>Direccion: {{emergency.direction}} </p>
                <p>Descripcion: {{emergency.description}} </p>
            </li>
        </ul>
        <div v-if="emergencies.length==0">
            <h2>No hay emergencias que mostrar</h2>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import NavBar from '~/components/NavBar.vue';

export default {
    data() {
        return {
            emergencies: []
        };
    },
    methods: {
        getEmergencies: async function () {
            try {
                var httpConsult = await axios.get("http://localhost:8080/emergency");
                this.emergencies = httpConsult.data;
                emergencies.forEach(element => {
                });
            }
            catch (error) {
                console.log(error);
            }
        }
    },
    created: function () {
        this.getEmergencies();
    },
    components: { NavBar }
}
</script>
