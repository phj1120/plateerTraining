<template>
  <h1>Login Page </h1>

  <LoginComponent @handleClickLogin="HandleClickLogin"></LoginComponent>

</template>

<script setup>
import LoginComponent from "@/components/LoginComponent";
import {useRoute, useRouter} from "vue-router";

// const emits = defineEmits([])

const route = useRoute();
const router = useRouter();

const HandleClickLogin = ()=>{

}



</script>

<style scoped>

</style>
