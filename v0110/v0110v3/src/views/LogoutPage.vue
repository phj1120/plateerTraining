<template>
  <h1>Logout Page</h1>
  <v-btn @click="handleClickLogout">Logout</v-btn>
</template>

<script setup>

import useAuth from "@/store/useAuth";
import {useRouter} from "vue-router";

const useStore = useAuth();
const router = useRouter()

const handleClickLogout = ()=>{
  useStore.logout()

  router.push({name:'Home'})
}

</script>

<style scoped>

</style>
