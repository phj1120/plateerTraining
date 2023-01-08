<template>
  <TodoInput :todo="todo" @clickAdd="handelClickAdd()"></TodoInput>
  <TodoList :todos="todos" @clickRemove="handelClickRemove"></TodoList>
</template>

<script setup>
import {ref} from "vue";
import {deleteTodo, getTodos, postTodo} from "@/apis/TodoApis";
import TodoInput from "@/components/todo/TodoInput.vue";
import TodoList from "@/components/todo/TodoList.vue";

const todo = ref({title: '', writer: ''})
const todos = ref([])

const refreshTodos = () => {
  getTodos().then((result) => {
    todos.value = result
  })
}
refreshTodos()

const handelClickAdd = () => {
  addTodo()
}

const addTodo = () => {
  postTodo({writer: todo.value.writer, title: todo.value.title})
    .then(() => {
        refreshTodos()
        todo.value = {title: '', writer: ''}
      }
    );
}

const handelClickRemove = (id) => {
  removeTodo(id)
}

const removeTodo = (id) => {
  deleteTodo(id).then(() => {
    refreshTodos()
  })
}
</script>

<style scoped>

</style>
