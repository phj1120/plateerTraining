<template>
  <TodoInput @refreshTodos="refreshTodos"></TodoInput>
  <TodoList :todos="todos" @refreshTodos="refreshTodos"></TodoList>
</template>

<script setup>
import {ref} from "vue";
import {getTodos} from "@/apis/TodoApis";
import TodoInput from "@/components/todo/TodoInput.vue";
import TodoList from "@/components/todo/TodoList.vue";

const todos = ref([])

const refreshTodos = () => {
  getTodos().then((result) => {
    todos.value = result
  })
}
refreshTodos()

</script>

<style scoped>

</style>
