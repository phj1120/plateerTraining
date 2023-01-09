<template>
  <h1>Todo Read Component</h1>
  <v-table>
    <tbody>
    <tr>
      <td> title</td>
      <td>{{ todo.title }}</td>
    </tr>
    <tr>
      <td> writer</td>
      <td>{{ todo.writer }}</td>
    </tr>
    </tbody>
  </v-table>
</template>

<script setup>

import {useRoute} from "vue-router";
import {getTodo} from "@/apis/todoApis";
import {ref} from "vue";

const route = useRoute()
const {id} = route.params

const todo = ref({})
getTodo(id).then((result) => {
  todo.value = result
  console.log(result)
})

</script>

<style scoped>

</style>
