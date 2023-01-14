<template>
  <h1>Todo Read Component</h1>
  <v-btn @click="handleClickModify(id)">수정</v-btn>
  <v-btn @click="handleClickDelete(id)">삭제</v-btn>
  <v-table>
    <tbody>
    <tr>
      <td> title</td>
      <td>{{ todo.title }}</td>
    </tr>
    <tr>
      <td> writer</td>
      <td>{{ todo.writer }}</td>
    </tr>
    </tbody>
  </v-table>
</template>

<script setup>

import {useRoute} from "vue-router";
import {deleteTodo, getTodo} from "@/apis/todoApis";
import {ref} from "vue";
import Swal from "sweetalert2";

const emits = defineEmits(['MoveTodoListPage', 'MoveTodoModifyPage'])

const route = useRoute()
const {id} = route.params
const todo = ref({})
todo.value = await getTodo(id)

const handleClickModify = (id) => {
  emits('MoveTodoModifyPage', id)
}

const handleClickDelete = async (id) => {
  await deleteTodo(id)
  await Swal.fire(
    'Good job!',
    '삭제 성공',
    'success'
  )
  emits('MoveTodoListPage')
}


</script>

<style scoped>

</style>
