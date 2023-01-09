<template>
  <h1>Todo List Component</h1>
  <ul>
    <li v-for="todo in todos" :key="todo.id" @click="emits('handleClickTodo', todo.id)">
      {{ todo }}
    </li>
  </ul>
  <v-btn @click="emits('handleClickAdd')">+</v-btn>
</template>

<script setup>
import {ref} from "vue";
import {getTodoList} from "@/apis/todoApis";

const emits = defineEmits(['handleClickAdd', 'handleClickTodo'])
const todos = ref([])
getTodoList().then(
  (result) => {
    todos.value = result
  }
)

</script>

<style scoped>

</style>
