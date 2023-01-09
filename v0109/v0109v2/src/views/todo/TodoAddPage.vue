<template>
  <h1>Todo Add Page</h1>
  <TodoAddComponent @handleClickAdd="handleClickAdd"></TodoAddComponent>
</template>

<script setup>

import TodoAddComponent from "@/components/todo/TodoAddComponent.vue";
import {useRouter} from "vue-router";
import {postTodo} from "@/apis/todoApis";

const router = useRouter();

const handleClickAdd = (todo) => {
  postTodo(todo).then((result) => {
      router.push({name: "TodoListPage"})
    }
  )

}

</script>

<style scoped>

</style>
