<template>
  <h1>Todo Add Component</h1>
  <v-text-field v-model="todo.title"></v-text-field>
  <v-text-field v-model="todo.writer"></v-text-field>
  <v-btn @click="handleClickAdd(todo)">Add</v-btn>
</template>

<script setup>
import {ref} from "vue";
import {postTodo} from "@/apis/todoApis";
import Swal from "sweetalert2";

const emits = defineEmits(['moveListPage'])
const todo = ref({})

const handleClickAdd = async (todo) => {
  await postTodo(todo)
  await Swal.fire('Good job!', '추가 완료', 'success')
  emits('moveListPage', todo)
}

// const handleClickAdd = (todo) =>{
//   postTodo(todo).then(() => {
//     Swal.fire(
//       'Good job!',
//       '추가 완료',
//       'success').then(() => {
//       emits('moveListPage', todo)
//     })
//   })
// }


</script>

<style scoped>

</style>
