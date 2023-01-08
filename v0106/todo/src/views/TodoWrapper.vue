<template>
  <TodoInput :todo="todo" @clickAdd="handelClickAdd()"></TodoInput>
  <TodoList :todos="todos" @clickRemove="handelClickRemove"></TodoList>
</template>

<script setup>
import {ref} from "vue";
import TodoInput from "@/components/todo/TodoInput.vue";
import TodoList from "@/components/todo/TodoList.vue";

const id = ref(1)
const todo = ref({id: id.value, title: '', writer: ''})
const todos = ref([])

const handelClickAdd = () => {
  addTodo()
}

const addTodo = () => {
  todos.value.push({id: id.value++, writer: todo.value.writer, title: todo.value.title})
  todo.value = {}
}

const handelClickRemove = (id) => {
  removeTodo(id)
}

const removeTodo = (id) => {
  console.log(id)
  todos.value = todos.value.filter(todo => todo.id !== id)
}
</script>

<style scoped>

</style>
