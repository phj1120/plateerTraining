<template>
  <v-btn @click="handleClickComplete(todo)">완료</v-btn>
  <v-btn @click="handleClickCancel(id)">취소</v-btn>
  <v-table>
    <tbody>
    <tr>
      <td> title</td>
      <td>
        <v-text-field v-model=todo.title></v-text-field>
      </td>
    </tr>
    <tr>
      <td> writer</td>
      <v-text-field v-model=todo.writer></v-text-field>
    </tr>
    </tbody>
  </v-table>
</template>

<script setup>
import {getTodo, putTodo} from "@/apis/todoApis";
import Swal from "sweetalert2";
import {ref} from "vue";
import {useRoute} from "vue-router";

const todo = ref({})
const route = useRoute()
const {id} = route.params
todo.value = await getTodo(id)

const emits = defineEmits(['moveTodoListPage', 'moveTodoReadPage'])

const handleClickComplete = async (todo) => {
  await putTodo(todo)
  await Swal.fire(
      'Good job!',
      '수정 완료',
      'success')
  emits('moveTodoListPage')
}

const handleClickCancel = (id) => {
  emits('moveTodoReadPage', id)
}
</script>

<style scoped>

</style>
