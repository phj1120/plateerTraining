<template>
  <h1>Todo Read Page</h1>
  <TodoReadComponent></TodoReadComponent>
</template>

<script setup>

import {useRoute} from "vue-router";
import TodoReadComponent from "@/components/todo/TodoReadComponent.vue";

const route = useRoute();

console.log(route.params)

</script>

<style scoped>

</style>
