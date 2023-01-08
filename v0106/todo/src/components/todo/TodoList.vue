<template>
  <v-table>
    <thead>
    <tr>
      <th class="text-left">
        ID
      </th>
      <th class="text-left">
        TITLE
      </th>
      <th class="text-left">
        WRITER
      </th>
    </tr>
    </thead>
    <tbody>
    <tr
      v-for="todo in props.todos"
      :key="todo.id"
    >
      <td>{{ todo.id }}</td>
      <td>{{ todo.title }}</td>
      <td>{{ todo.writer }}</td>
      <v-btn @click="handelClickRemove(todo.id)">x</v-btn>
    </tr>
    </tbody>
  </v-table>

  <TodoModal :removeDialog="removeDialog"
             @handleClickRemoveAgree="handleClickRemoveAgree(removeDialog.id)"></TodoModal>
</template>

<script setup>
import TodoModal from "@/components/todo/TodoModal.vue";
import {deleteTodo} from "@/apis/TodoApis";
import {ref} from "vue";

const props = defineProps(['todos'])
const emits = defineEmits(['refreshTodos'])
const removeDialog = ref({id: '', open: false})

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
    emits('refreshTodos')
    removeDialog.value.open = false
  })
}

</script>

<style scoped>

</style>
