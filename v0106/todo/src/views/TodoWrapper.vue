<template>
  <TodoInput :todo="todo" @clickAdd="handelClickAdd()"></TodoInput>
  <TodoList :todos="todos" :removeDialog="removeDialog"
            @handleClickRemoveAgree="handleClickRemoveAgree"
            @handelClickRemove="handelClickRemove"></TodoList>
</template>

<script setup>
import {ref} from "vue";
import {deleteTodo, getTodos, postTodo} from "@/apis/TodoApis";
import TodoInput from "@/components/todo/TodoInput.vue";
import TodoList from "@/components/todo/TodoList.vue";

const todo = ref({title: '', writer: ''})
const todos = ref([])
const removeDialog = ref({id: '', open: false})

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
  removeDialog.value.id = id
  removeDialog.value.open = true
}

const handleClickRemoveAgree = (id) => {
  removeAgree(id)
}

const removeAgree = (id) => {
  deleteTodo(id).then(() => {
    refreshTodos()
    removeDialog.value.open = false
  })
}

</script>

<style scoped>

</style>
