<template>
  <h1>Todo Add Component</h1>
  <v-text-field v-model="todo.title"></v-text-field>
  <v-text-field v-model="todo.writer"></v-text-field>
  <v-btn @click="emits('handleClickAdd', todo)">Add</v-btn>
</template>

<script setup>
import {ref} from "vue";

const emits = defineEmits(['handleClickAdd'])
const todo = ref({})

</script>

<style scoped>

</style>
