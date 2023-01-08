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
      <v-btn @click="emits('handelClickRemove',todo.id)">x</v-btn>
    </tr>
    </tbody>
  </v-table>

  <TodoModal :removeId="removeId" :removeDialog="removeDialog"
             @handleClickRemoveAgree="emits('handleClickRemoveAgree', removeId)"></TodoModal>
</template>

<script setup>
import TodoModal from "@/components/todo/TodoModal.vue";

const props = defineProps(['removeId', 'todos', 'removeDialog'])
const emits = defineEmits(['handleClickRemoveAgree', 'handelClickRemove'])
</script>

<style scoped>

</style>
