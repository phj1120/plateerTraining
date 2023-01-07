<template>
  <h1>Todo Wrapper</h1>
  <TodoInput></TodoInput>
  <TodoList></TodoList>
</template>

<script>
import TodoList from "@/components/todo/TodoList.vue";
import TodoInput from "@/components/todo/TodoInput.vue";

export default {
  name: "TodoWrapper",
  components: {TodoInput, TodoList}
}
</script>

<style scoped>

</style>
