<template>
  <h1>Login Page </h1>

  <LoginComponent @login="login"></LoginComponent>

</template>

<script setup>
import LoginComponent from "@/components/LoginComponent";
import {useRouter} from "vue-router";

const router = useRouter();

const login = () => {
  router.push({name: 'TodoListPage'})
}


</script>

<style scoped>

</style>
