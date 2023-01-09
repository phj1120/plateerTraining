<template>
  <h1>Todo List Page</h1>
  <TodoListComponent @handleClickAdd="handleClickAdd" @handleClickTodo="handleClickTodo"></TodoListComponent>
</template>

<script setup>
import TodoListComponent from "@/components/todo/TodoListComponent.vue";
import {useRouter} from "vue-router";

const router = useRouter()

const handleClickAdd = () => {
  router.push({name: 'TodoAddPage'})
}

const handleClickTodo = (id) => {
  router.push({name: 'TodoReadPage', params: {id}})
}
</script>

<style scoped>

</style>
