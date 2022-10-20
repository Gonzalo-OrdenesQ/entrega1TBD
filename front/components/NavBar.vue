<template>
    <header>
        <nav>
            <table>
                <tr>
                    <th><a href="/">home</a></th>
                    <th><a href="register_emergency">registrar</a></th>
                    <th><a href="update_emergency">editar</a></th>
                    <th><a href="delete_emergency">eliminar</a></th>
                    <th><a href="show_emergencies">ver</a></th>
                </tr>
            </table>
        </nav>
    </header>
</template>

<script>
export default {
    name: "navBar"
}
</script>

<style>
    th{
        padding:2em;
    }
</style>