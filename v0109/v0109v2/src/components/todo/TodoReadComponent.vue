<template>
  <h1>Todo Read Component</h1>
  {{ todo }}
</template>

<script setup>

import {useRoute} from "vue-router";
import {getTodo} from "@/apis/todoApis";
import {ref} from "vue";

const route = useRoute()
const {id} = route.params

const todo = ref({})
getTodo(id).then((result)=>{
  todo.value = result
  console.log(result)
})

</script>

<style scoped>

</style>
