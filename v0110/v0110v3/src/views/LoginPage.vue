<template>
  <h1>Login Page</h1>
  <v-btn @click="handleClickLogin">Log In</v-btn>
</template>

<script setup>

import useAuth from "@/store/useAuth";
import {useRouter} from "vue-router";

const useStore = useAuth()
const router = useRouter()

const handleClickLogin = ()=>{
  useStore.login()

  router.push({name:'Home'})
}
</script>

<style scoped>

</style>
