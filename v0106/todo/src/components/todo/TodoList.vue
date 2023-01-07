<template>
  <v-table>
    <thead>
    <tr>
      <th class="text-left">
        ID
      </th>
      <th class="text-left">
        CONTENT
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
      <td>{{ todo.content }}</td>
      <td>{{ todo.writer }}</td>
      <v-btn @click="emits('clickRemove',todo.id)">x</v-btn>

    </tr>
    </tbody>
  </v-table>
</template>

<script setup>
const props = defineProps(['todos'])
const emits = defineEmits(['clickRemove'])
</script>

<style scoped>

</style>
