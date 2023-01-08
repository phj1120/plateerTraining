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
      <v-btn @click="handleClickModify(todo)">수정</v-btn>
      <v-btn @click="handelClickRemove(todo.id)">삭제</v-btn>
    </tr>
    </tbody>
  </v-table>

  <TodoModalRemove :removeDialog="removeDialog"
                   @handleClickRemoveAgree="handleClickRemoveAgree(removeDialog.id)"></TodoModalRemove>
  <TodoModalModify :modifyDialog="modifyDialog" @refreshTodos="emits('refreshTodos')"></TodoModalModify>
</template>

<script setup>
import TodoModalRemove from "@/components/todo/TodoModalRemove.vue";
import {deleteTodo} from "@/apis/TodoApis";
import {ref} from "vue";
import TodoModalModify from "@/components/todo/TodoModalModify.vue";

const props = defineProps(['todos'])
const emits = defineEmits(['refreshTodos'])
const removeDialog = ref({id: '', open: false})
const modifyDialog = ref({id: '', open: false, todo: {}})

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

const handleClickModify = (todo) => {
  clickModify(todo)
}

const clickModify = (todo) => {
  modifyDialog.value.id = todo.id
  modifyDialog.value.open = true
  modifyDialog.value.todo = todo
}

</script>

<style scoped>

</style>
