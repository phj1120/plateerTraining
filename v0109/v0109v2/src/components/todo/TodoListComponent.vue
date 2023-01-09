<template>
  <h1>Todo List Component</h1>
  <template v-for="todo in todos"
            :key="todo.id">
    <v-list-item @click="emits('handleClickTodo', todo.id)">
      <v-list-item-title>{{ todo.title }}</v-list-item-title>
      <v-list-item-subtitle>{{ todo.writer }}</v-list-item-subtitle>
    </v-list-item>
    <v-divider></v-divider>
  </template>
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
