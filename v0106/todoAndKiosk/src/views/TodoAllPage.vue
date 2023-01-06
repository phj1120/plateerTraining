<template>
  <h1>Todo All Page</h1>
  <TodoInput @changeCount="changeCount"></TodoInput>
  <TodoList :count="count" @changeCount="changeCount"></TodoList>
</template>

<script setup>
import TodoList from "@/components/todoall/TodoList.vue";
import TodoInput from "@/components/todoall/TodoInput.vue";
import {ref} from "vue";

const count = ref(0)

const changeCount = () => {
  count.value++
}


</script>

<style scoped>

</style>
